package com.example.prcticaapps

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var txtNombre: EditText
    private lateinit var txtApellido: EditText
    private lateinit var txtTelefono: EditText
    private lateinit var buttonGuardar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val establecimientos =
            arrayOf("Hospital Regional", "Hospital Belen", "Hospital La Noria")

        val spinnerEstablecimiento: Spinner = findViewById(R.id.spinnerEstablecimiento)
        val adapterEstablecimiento = ArrayAdapter(this, android.R.layout.simple_spinner_item, establecimientos)
        adapterEstablecimiento.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerEstablecimiento.adapter = adapterEstablecimiento

        val especialidades =
            arrayOf("Cardiología", "Dermatología", "Nutrición")

        val spinnerEspecialidad: Spinner = findViewById(R.id.spinnerEspecialidad)
        val adapterEspecialidad = ArrayAdapter(this, android.R.layout.simple_spinner_item, especialidades)
        adapterEspecialidad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerEspecialidad.adapter = adapterEspecialidad

        val fechas =
            arrayOf("lunes", "martes", "miércoles", "jueves", "viernes")

        val spinnerFecha: Spinner = findViewById(R.id.spinnerFecha)
        val adapterFecha = ArrayAdapter(this, android.R.layout.simple_spinner_item, fechas)
        adapterFecha.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerFecha.adapter = adapterFecha

        txtNombre = findViewById(R.id.txt_nombre)
        txtApellido = findViewById(R.id.txt_apellido)
        txtTelefono = findViewById(R.id.txt_telefono)
        buttonGuardar = findViewById(R.id.buttonGuardar)

        buttonGuardar.setOnClickListener {
            if (validateFields()) {
                mostrarDialogoReservaGuardada()
            } else {
                mostrarDialogoCamposIncompletos()
            }
        }
    }

    private fun validateFields(): Boolean {
        return txtNombre.text.isNotBlank() && txtApellido.text.isNotBlank() && txtTelefono.text.isNotBlank()
    }

    private fun mostrarDialogoReservaGuardada() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Reserva guardada")
        builder.setMessage("¡Su reserva ha sido guardada correctamente!")
        builder.setPositiveButton("Aceptar", null)
        val dialog = builder.create()
        dialog.show()
    }

    private fun mostrarDialogoCamposIncompletos() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Campos incompletos")
        builder.setMessage("Por favor, complete todos los campos antes de guardar.")
        builder.setPositiveButton("Aceptar", null)
        val dialog = builder.create()
        dialog.show()
    }
}

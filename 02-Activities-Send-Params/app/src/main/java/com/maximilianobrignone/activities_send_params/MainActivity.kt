package com.maximilianobrignone.activities_send_params

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var texto : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById<TextView>(R.id.textView)
        val boton = findViewById<Button>(R.id.btnAccion)

        boton.setOnClickListener {
            navegarSegundaActivity()
        }
    }

    private fun navegarSegundaActivity(){
        val intent = Intent(this, SegundaActivity::class.java)
        intent.putExtra("nombre", "Curso Android")
        initActivityForResult.launch(intent) // --> enviar datos a Segunda Activity y recibir datos de Segunda Activity
    }

    private val initActivityForResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                texto.text = it.data?.getStringExtra("nombre2")
            }
        }
}
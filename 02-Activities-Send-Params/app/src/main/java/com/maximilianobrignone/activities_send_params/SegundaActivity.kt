package com.maximilianobrignone.activities_send_params

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SegundaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        var texto = findViewById<TextView>(R.id.textView2)
        val button = findViewById<Button>(R.id.btnAccion2)

        // si es null el extra no ejecuta el bloque
        // si no es null ejecuta lo que esta dentro del bloque
        intent.extras?.let {bundle->
            texto.text = bundle.getString("nombre")
        }

        button.setOnClickListener{

            val intent = Intent()
            intent.putExtra("nombre2", "Hola Desde Segunda Activity!")
            setResult(Activity.RESULT_OK, intent)

            finish()
        }
    }
}
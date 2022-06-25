package com.maximilianobrignone.fragments_send_params

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Primer fragment a inflarse en el fragment container
        // dentro de la activity (Programaticamente sin hacerlo desde XML)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.fragment_container_view, PrimerFragment())
        }
    }
}
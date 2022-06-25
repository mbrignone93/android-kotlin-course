package com.maximilianobrignone.fragments_send_params

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResult

class SegundoFragment : Fragment(R.layout.fragment_segundo) {

    private var nombre : String? = ""
    private var edad : Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // primer metodo de obtencion de argumentos
        /*
        nombre = arguments?.getString(MI_NOMBRE)
        edad = arguments?.getInt(MI_EDAD)
        */

        // segundo metodo de obtención de argumentos
        nombre = requireArguments().getString(MI_NOMBRE)
        edad = requireArguments().getInt(MI_EDAD)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val texto = view.findViewById<TextView>(R.id.textViewOutput)
        val boton = view.findViewById<Button>(R.id.btn_volver)

        texto.text = "$nombre $edad años"

        // enviar argumento al primer fragment (funciona idem al registerForActivityResult con Activities)
        boton.setOnClickListener{
            val result = "Argumento Recibido de Fragment 2"
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))

            requireActivity().supportFragmentManager.commit {
                replace(R.id.fragment_container_view, PrimerFragment())
                addToBackStack("segundoFragment")
            }
        }
    }

    // creacion de constantes que recibira el segundo fragment del primero (params)
    private companion object {
        private const val MI_NOMBRE = "nombre"
        private const val MI_EDAD = "edad"
    }

    // metodo para aplicar los parametros recibidos del primer fragment a las constantes creadas
    fun newInstance(nombre : String, edad : Int) = SegundoFragment().apply {
        arguments = bundleOf(MI_NOMBRE to nombre, MI_EDAD to edad)
    }
}
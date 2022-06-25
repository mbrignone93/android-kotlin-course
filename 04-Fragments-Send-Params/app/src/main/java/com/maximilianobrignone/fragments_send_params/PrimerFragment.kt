package com.maximilianobrignone.fragments_send_params

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener

class PrimerFragment : Fragment(R.layout.fragment_primer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val texto = view.findViewById<TextView>(R.id.textView)
        val button = view.findViewById<Button>(R.id.btn_navegar)

        // recibir argumento del segundo fragment
        setFragmentResultListener("requestKey"){ key, bundle ->
            val result = bundle.getString("bundleKey")
            texto.text = result
        }

        button.setOnClickListener{
            // navegar al segundo fragment
            // reemplazo primer fragment en el fragmentContainerView
            // por el segundo fragment
            requireActivity().supportFragmentManager.commit {
                replace(R.id.fragment_container_view, SegundoFragment().newInstance("Maximiliano", 28))
                addToBackStack("primerFragment")
            }
        }
    }
}
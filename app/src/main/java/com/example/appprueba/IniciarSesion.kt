package com.example.appprueba


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appprueba.databinding.ActivityIniciarSesionBinding

class IniciarSesion : AppCompatActivity() {

    private lateinit var binding: ActivityIniciarSesionBinding

    // Constantes de usuario y contraseña

    private val MYEMAIL = "correo"
    private val MYPASS = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIniciarSesionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.EnlaceRegistrarse.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        // Lógica de comprobación al hacer clic en el botón Validar

        binding.BotonIniciarSesion.setOnClickListener {
            val contraseña = binding.CampoContraseA.text.toString()
            val email = binding.CampoEmailIniciarSesion.text.toString()


            // Comprobar usuario y contraseña

            if (email == MYEMAIL && contraseña == MYPASS) {
                // Si la validación es correcta, iniciar el Activity principal
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                // Si la validación no es correcta, mostrar un Toast informando al usuario
                Toast.makeText(
                    this,
                    "Email o contraseña incorrectos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

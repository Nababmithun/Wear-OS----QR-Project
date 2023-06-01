package app.humbihealth.lifesafer.ui.auth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import app.humbihealth.lifesafer.databinding.ActivityLoginBinding
import app.humbihealth.lifesafer.ui.MainActivity

class LoginActivity : Activity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnVerify.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
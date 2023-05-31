package app.humbihealth.lifesafer.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.humbihealth.lifesafer.R
import app.humbihealth.lifesafer.databinding.ActivityLoginBinding
import app.humbihealth.lifesafer.databinding.ActivityLoginBinding.inflate
import app.humbihealth.lifesafer.databinding.ActivityMainBinding

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
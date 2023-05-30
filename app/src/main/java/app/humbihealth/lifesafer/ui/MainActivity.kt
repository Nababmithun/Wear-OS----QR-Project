package app.humbihealth.lifesafer.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import app.humbihealth.lifesafer.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivQr.setOnClickListener {
            val intent = Intent(this, ShareMyAccount::class.java)
            startActivity(intent)
        }
        binding.ivSos.setOnClickListener {
            Toast.makeText(this@MainActivity, "An SOS has sent", Toast.LENGTH_SHORT).show()

        }
    }
}
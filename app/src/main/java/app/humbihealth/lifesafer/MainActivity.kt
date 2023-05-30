package app.humbihealth.lifesafer

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
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
package app.humbihealth.lifesafer.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import app.humbihealth.lifesafer.R

class SplashScreen : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }, 2000)
    }
}
package app.humbihealth.lifesafer.ui.splash

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import app.humbihealth.lifesafer.R
import app.humbihealth.lifesafer.ui.auth.LoginActivity

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
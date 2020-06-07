package com.dhruvsondhi.myproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        var mainButton = findViewById<Button>(R.id.mainButton)

        mainButton.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            finish()
//            overridePendingTransition( 0, 0);
            startActivity(intent)
//            overridePendingTransition( 0, 0);
        }
    }
}
package com.dhruvsondhi.myproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RulesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules)

        var backButton = findViewById<Button>(R.id.backBtn)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            finish()
//            overridePendingTransition( 0, 0);
            startActivity(intent)
//            overridePendingTransition( 0, 0);
        }

        var playButton = findViewById<Button>(R.id.playButton)
        playButton.setOnClickListener {
            val intent = Intent(this, PlayActivity::class.java)
//            finish()
//            overridePendingTransition( 0, 0);
            startActivity(intent)
//            overridePendingTransition( 0, 0);
        }
    }
}
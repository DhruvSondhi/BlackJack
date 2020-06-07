package com.dhruvsondhi.myproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        var playButton = findViewById<Button>(R.id.playBtn)
        var howToPlayButton = findViewById<Button>(R.id.rulesBtn)
        var aboutButton = findViewById<Button>(R.id.aboutBtn)

        playButton.setOnClickListener {
            val intent = Intent(this, PlayActivity::class.java)
            overridePendingTransition( 0, 0);
            startActivity(intent)
            overridePendingTransition( 0, 0);
        }

        howToPlayButton.setOnClickListener {
            val intent = Intent(this, RulesActivity::class.java)
            finish()
            overridePendingTransition( 0, 0);
            startActivity(intent)
            overridePendingTransition( 0, 0);
        }

        aboutButton.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            finish()
            overridePendingTransition( 0, 0);
            startActivity(intent)
            overridePendingTransition( 0, 0);
        }

    }
}
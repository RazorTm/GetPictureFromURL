package com.example.randompic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.randompic.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_URI = "com.uri"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, PictureActivity::class.java)
            intent.putExtra(EXTRA_URI, binding.uri.text.toString())
            startActivity(intent)
        }

    }
}
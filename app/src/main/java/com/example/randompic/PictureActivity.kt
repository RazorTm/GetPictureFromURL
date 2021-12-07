package com.example.randompic

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.randompic.databinding.ActivityPictureBinding


class PictureActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPictureBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPictureBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        val imageUri = intent.getStringExtra(MainActivity.EXTRA_URI)


        Glide.with(this)
            .load(imageUri)
            .error(R.drawable.ic_baseline_error_24)
            .listener(object : RequestListener<Drawable?> {

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable?>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable?>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Toast.makeText(this@PictureActivity, "Network Not Available", Toast.LENGTH_LONG)
                        .show()
                    return false
                }
            })
            .fitCenter()
            .into(binding.imageViewUri)
    }
}
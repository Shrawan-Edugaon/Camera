package com.example.camera

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    internal lateinit var cImg:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cBtn = findViewById<Button>(R.id.button) as Button
        cImg = findViewById<ImageView>(R.id.cImage)
        cBtn.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            val CAMERA_REQUEST = 0
            startActivityForResult(intent,CAMERA_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val CAMERA_REQUEST = null
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK)
        {
            val cPhoto = data!!.extras?.get("data") as Bitmap
            cImg.setImageBitmap(cPhoto)
        }
    }
    companion object{
        private val CAMERA_REQUEST = 123
    }
}
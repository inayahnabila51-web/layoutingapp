package com.example.pertemuan3

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PhotoDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PHOTO_RES = "extra_photo_res"
        const val EXTRA_ACCOUNT_NAME = "extra_account_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_detail)

        val ivPhotoDetail = findViewById<ImageView>(R.id.ivPhotoDetail)
        val tvAccountName = findViewById<TextView>(R.id.tvAccountName)
        val btnKembali = findViewById<Button>(R.id.btnKembali)

        val photoRes = intent.getIntExtra(EXTRA_PHOTO_RES, R.drawable.foto_profil)
        val accountName = intent.getStringExtra(EXTRA_ACCOUNT_NAME) ?: ""

        ivPhotoDetail.setImageResource(photoRes)
        tvAccountName.text = accountName

        btnKembali.setOnClickListener {
            finish()
        }
    }
}
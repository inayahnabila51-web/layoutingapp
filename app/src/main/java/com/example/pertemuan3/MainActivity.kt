package com.example.pertemuan3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var tvUsername: TextView
    private lateinit var tvBio: TextView

    private val editProfileLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val newName = result.data?.getStringExtra(EditProfileActivity.EXTRA_NAME)
            val newBio = result.data?.getStringExtra(EditProfileActivity.EXTRA_BIO)
            if (newName != null) tvUsername.text = newName
            if (newBio != null) tvBio.text = newBio
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvUsername = findViewById(R.id.tvUsername)
        tvBio = findViewById(R.id.tvBio)
        val btnEditProfile = findViewById<Button>(R.id.btnEditProfile)
        val ivProfilePhoto = findViewById<ImageView>(R.id.ivProfilePhoto)

        // 1. Klik Edit Profile -> buka EditProfileActivity, bawa data nama & bio yang sekarang
        btnEditProfile.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java).apply {
                putExtra(EditProfileActivity.EXTRA_NAME, tvUsername.text.toString())
                putExtra(EditProfileActivity.EXTRA_BIO, tvBio.text.toString())
            }
            editProfileLauncher.launch(intent)
        }

        // 2. Klik foto profil -> buka PhotoDetailActivity, bawa foto profil & nama akun
        ivProfilePhoto.setOnClickListener {
            val intent = Intent(this, PhotoDetailActivity::class.java).apply {
                putExtra(PhotoDetailActivity.EXTRA_PHOTO_RES, R.drawable.foto_profil)
                putExtra(PhotoDetailActivity.EXTRA_ACCOUNT_NAME, tvUsername.text.toString())
            }
            startActivity(intent)
        }
    }
}
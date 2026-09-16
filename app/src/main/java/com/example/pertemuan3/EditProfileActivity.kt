package com.example.pertemuan3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_BIO = "extra_bio"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val etName = findViewById<EditText>(R.id.etName)
        val etBio = findViewById<EditText>(R.id.etBio)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)

        val currentName = intent.getStringExtra(EXTRA_NAME) ?: ""
        val currentBio = intent.getStringExtra(EXTRA_BIO) ?: ""
        etName.setText(currentName)
        etBio.setText(currentBio)

        btnSimpan.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra(EXTRA_NAME, etName.text.toString())
                putExtra(EXTRA_BIO, etBio.text.toString())
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}
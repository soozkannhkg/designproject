package com.hkg.designproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class YeniDokuman : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yeni_dokuman)
        supportActionBar?.hide()
    }
}
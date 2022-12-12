package com.hkg.designproject

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import com.hkg.designproject.databinding.ActivityHosgeldinizsayfasiBinding
import com.hkg.designproject.databinding.ActivityKayitSayfasiBinding
import kotlinx.android.synthetic.main.activity_kayit_sayfasi.*

class hosgeldinizsayfasi : AppCompatActivity() {
    private val secondsplash = 4000
    lateinit var binding: ActivityHosgeldinizsayfasiBinding
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHosgeldinizsayfasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        //xml veri çekme
        preferences = getSharedPreferences("Bilgiler", MODE_PRIVATE)
        var kayitIsim = preferences.getString("isim","")
        //verileri aktarma işlemi
        binding.kullaniciBilgisi.text=kayitIsim.toString()

        Handler().postDelayed({
            val intent = Intent(this,AnaMenu::class.java)
            startActivity(intent)
            finish()
        },secondsplash.toLong())
    }
}
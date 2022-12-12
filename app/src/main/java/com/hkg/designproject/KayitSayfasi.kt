package com.hkg.designproject

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hkg.designproject.databinding.ActivityKayitSayfasiBinding
import kotlinx.android.synthetic.main.activity_kayit_sayfasi.*

@Suppress("DEPRECATION")
class KayitSayfasi : AppCompatActivity() {
    lateinit var binding: ActivityKayitSayfasiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKayitSayfasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.btnkayit.setOnClickListener{
            var kullaniciIsim = binding.kayitIsim.text.toString()
            var kullaniciBilgisi = binding.kayitkullaniciadi.text.toString()
            var kullaniciParola = binding.kayitparola.text.toString()
            var SharedPreferences = this.getSharedPreferences("Bilgiler", MODE_PRIVATE)
            var editor = SharedPreferences.edit()

            // Veri Ekleme Kısmı
            editor.putString("isim","$kullaniciIsim").apply()
            editor.putString("kullanici","$kullaniciBilgisi").apply()
            editor.putString("parola","$kullaniciParola").apply()
            Toast.makeText(applicationContext,"Kayıt Başarılı",Toast.LENGTH_LONG).show()
            binding.kayitIsim.text.clear()
            binding.kayitkullaniciadi.text.clear()
            binding.kayitparola.text.clear()
        }



        binding.btngirisdonus.setOnClickListener{
            intent = Intent(applicationContext,GirisSayfasi::class.java)
            startActivity(intent)
        }
    }
}
package com.hkg.designproject

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hkg.designproject.databinding.ActivityGirisSayfasiBinding

class GirisSayfasi : AppCompatActivity() {
    lateinit var binding: ActivityGirisSayfasiBinding
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGirisSayfasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        preferences = getSharedPreferences("Bilgiler", MODE_PRIVATE)
        binding.btnGiris.setOnClickListener{
            var kayitliIsim = preferences.getString("isim","")
            var kayitliKullanici = preferences.getString("kullanici","")
            var kayitliParola = preferences.getString("parola","")

            var girisKullanici = binding.giriskullaniciadi.text.toString()
            var girisParola = binding.girisparola.text.toString()

            if ((kayitliKullanici==girisKullanici) && (kayitliParola)==(girisParola)){
                intent = Intent(applicationContext,hosgeldinizsayfasi::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(applicationContext,"Giriş Bilgileri Hatalı !",Toast.LENGTH_LONG).show()
            }





        }
        binding.btnKayit.setOnClickListener{
            intent = Intent(applicationContext,KayitSayfasi::class.java)
            startActivity(intent)
        }
    }
}
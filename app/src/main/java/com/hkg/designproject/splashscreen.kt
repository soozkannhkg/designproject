package com.hkg.designproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.hkg.designproject.databinding.ActivitySplashBinding

@Suppress("DEPRECATION")
class splashscreen : AppCompatActivity() {
    private val acilis = 5000
    lateinit var binding: ActivitySplashBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val anim1=AnimationUtils.loadAnimation(this,R.anim.anim1)
        val anim2=AnimationUtils.loadAnimation(this,R.anim.anim2)
        val anim3=AnimationUtils.loadAnimation(this,R.anim.anim3)

        val baret = binding.baret
        val baslik = binding.baslik
        val aciklama = binding.aciklama

        baret.animation=anim1
        baslik.animation=anim3
        aciklama.animation=anim3

        Handler().postDelayed({
        val intent = Intent(this,GirisSayfasi::class.java)
            startActivity(intent)
            finish()
        },acilis.toLong())
    }

}
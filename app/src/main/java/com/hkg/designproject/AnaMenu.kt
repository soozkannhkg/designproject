package com.hkg.designproject

import android.content.Intent
import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.hkg.designproject.databinding.ActivityAnaMenuBinding
import com.hkg.designproject.databinding.ActivityHosgeldinizsayfasiBinding
import com.klinker.android.link_builder.Link
import java.nio.channels.AsynchronousFileChannel.open

class AnaMenu : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setTitle("GUVENLINSAAT")
        setContentView(R.layout.activity_ana_menu)
        val yenidokumanlink = findViewById(R.id.textView6) as TextView
        yenidokumanlink.setOnClickListener{
            val intent = Intent(this,YeniDokuman::class.java)
            startActivity(intent)
        }



        drawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            it.isChecked = true

            when(it.itemId){
                R.id.nav_yenidokuman -> {
                    val intent = Intent(this,YeniDokuman::class.java)
                    startActivity(intent)
                }
                R.id.nav_ac -> Toast.makeText(applicationContext,"Mevcut Doküman Seçilecek",Toast.LENGTH_SHORT).show()
                R.id.nav_farklikaydet -> Toast.makeText(applicationContext,"Farklý Kaydediliyor",Toast.LENGTH_SHORT).show()
                R.id.nav_sablonolustur -> Toast.makeText(applicationContext,"Yeni Þablon Oluþturuluyor",Toast.LENGTH_SHORT).show()
                R.id.nav_dokumanisil -> Toast.makeText(applicationContext,"Doküman Silinecek",Toast.LENGTH_SHORT).show()
                R.id.nav_cikis -> {
                    val intent = Intent(this,GirisSayfasi::class.java)
                    startActivity(intent)
                }
                R.id.nav_word -> Toast.makeText(applicationContext,"WORD formatýnda çýkartýlýyor",Toast.LENGTH_SHORT).show()
                R.id.nav_pdf -> Toast.makeText(applicationContext,"PDF formatýnda çýkartýlýyor",Toast.LENGTH_SHORT).show()
                R.id.nav_xml -> Toast.makeText(applicationContext,"XML formatýnda çýkartýlýyor",Toast.LENGTH_SHORT).show()
                R.id.nav_gorunum-> replaceFragment(gorunum(),it.title.toString())
                R.id.nav_araclar -> replaceFragment(araclar(),it.title.toString())
                R.id.nav_yardim -> replaceFragment(yardim(),it.title.toString())
                R.id.nav_iletisim -> replaceFragment(iletisim(),it.title.toString())
                R.id.nav_hakkinda -> replaceFragment(hakkinda(),it.title.toString())
            }
            true
        }


    }

    private fun replaceFragment(fragment: Fragment,title: String){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
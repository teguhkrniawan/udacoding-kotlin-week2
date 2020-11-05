package com.teguh.week2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.teguh.week2.model.Artikel
import kotlinx.android.synthetic.main.activity_detail_artikel.*

class DetailArtikelActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_artikel)

        val dataArtikel = intent.getParcelableExtra<Artikel>(ImplementasiRvActivity.ARTIKEL_EXTRA_KEY)

        detail_artikel_judul.text = dataArtikel?.judul
        detail_artikel_deskripsi.text = dataArtikel?.deskripsi

        detail_artikel_btn.setOnClickListener {
            val url = dataArtikel?.url
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(url))
            startActivity(intent)
        }
    }

}
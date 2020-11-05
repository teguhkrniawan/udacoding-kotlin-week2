package com.teguh.week2

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.teguh.week2.adapter.ArtikelAdapter
import com.teguh.week2.model.Artikel
import kotlinx.android.synthetic.main.activity_implementasi_rv.*

class ImplementasiRvActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implementasi_rv)

        val listArtikel = ArrayList<Artikel>()
        listArtikel.add(
            Artikel(
                R.drawable.artikel1,
                "Cara menaikkan berat badan dengan cepat",
                getString(R.string.deskripis),
                "https://www.alodokter.com/menambah-berat-badan-menjadi-lebih-ideal"
            ))

        listArtikel.add(
            Artikel(
                R.drawable.artikel2,
                "5 Makanan yang membuatmu sehat",
                getString(R.string.deskripis),
                "https://www.fimela.com/beauty-health/read/3751427/5-makanan-sehat-yang-wajib-kita-konsumsi"
            ))

        listArtikel.add(
            Artikel(
                R.drawable.artikel3,
                "Apa manfaat buah bagi kesehatan?",
                getString(R.string.deskripis),
                "http://www.p2ptm.kemkes.go.id/infographic-p2ptm/obesitas/page/18/apa-saja-manfaat-buah-buahan-bagi-tubuh-kita"
            ))

        val adapter = ArtikelAdapter(this, listArtikel, object: ArtikelAdapter.onClickListener{
            override fun detailArtikel(item: Artikel) {
               val intent = Intent(this@ImplementasiRvActivity, DetailArtikelActivity::class.java)
               intent.putExtra(ARTIKEL_EXTRA_KEY, item)
               startActivity(intent)
            }
        })
        rv_artikel.setHasFixedSize(true)
        rv_artikel.layoutManager = LinearLayoutManager(this)
        rv_artikel.adapter = adapter

    }

    companion object {
        const val ARTIKEL_EXTRA_KEY = "artikel_extra_key"
    }
}
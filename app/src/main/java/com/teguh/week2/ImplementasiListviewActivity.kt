package com.teguh.week2

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.teguh.week2.adapter.DokterAdapter
import com.teguh.week2.model.Dokter
import kotlinx.android.synthetic.main.activity_implementasi_listview.*
import java.lang.String


class ImplementasiListviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implementasi_listview)

        val listDokter = ArrayList<Dokter>()
        listDokter.add(
            Dokter(
            "dr.Gilang Andika",
            R.drawable.avatar,
            "Gizi",
             getString(R.string.deskripis),
            "+6282283775912"
        )
        )

        listDokter.add(Dokter(
            "dr.Ahwan Insan",
            R.drawable.avatar2,
            "Jantung",
            getString(R.string.deskripis),
            "+6282283775912"
        ))

        listDokter.add(Dokter(
            "dr.Imam Taufik",
            R.drawable.avatar3,
            "Kesehatan Batin",
            getString(R.string.deskripis),
            "+6282283775912"
        ))

        val adapter = DokterAdapter(this, listDokter)
        dokterListView.adapter = adapter

        dokterListView.setOnItemClickListener { parent, view, potition, id ->
           Dialog(this).apply {
               requestWindowFeature(Window.FEATURE_NO_TITLE)
               setContentView(R.layout.detail_dokter_dialog)

               val detailFoto = findViewById<ImageView>(R.id.detail_dokter_foto)
               val detailNama = findViewById<TextView>(R.id.detail_dokter_name)
               val detailDesc = findViewById<TextView>(R.id.detail_dokter_deskripsi)
               val detailWhatsapp = findViewById<Button>(R.id.detail_btn_whastapp)

               val item = listDokter[potition]
               detailFoto.setImageResource(item.foto)
               detailNama.text = item.nama
               detailDesc.text = item.deskripsi

               val numberWhatsapp = item.nomorSeluler
               val message = "Hai saya ingin berkonsultasi"

               detailWhatsapp.setOnClickListener {
                   try {
                      val intent = Intent(Intent.ACTION_VIEW, Uri.parse(
                                   String.format(
                                       "https://api.whatsapp.com/send?phone=%s&text=%s",
                                       numberWhatsapp,
                                       message
                                   )
                               )
                           )
                       startActivity(intent)
                   } catch (e: Exception) {
                       Toast.makeText(applicationContext, "error: "+e.message, Toast.LENGTH_SHORT).show()
                   }

               }

           }.show()

        }
    }
}
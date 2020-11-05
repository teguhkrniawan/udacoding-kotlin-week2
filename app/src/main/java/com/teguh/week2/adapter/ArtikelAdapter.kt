package com.teguh.week2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.teguh.week2.R
import com.teguh.week2.model.Artikel

class ArtikelAdapter(
    private val context: Context,
    private val data: List<Artikel>,
    private val itemClick: onClickListener
) : RecyclerView.Adapter<ArtikelAdapter.MyViewHolder>(){

    inner class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val fotoArtikel = view.findViewById<ImageView>(R.id.artikel_img)
        val judulArtikel = view.findViewById<TextView>(R.id.artikel_judul)
        val deskripsiArtikel = view.findViewById<TextView>(R.id.artikel_deskripsi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_artikel, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = data[position]

        holder.fotoArtikel.setImageResource(item.foto)
        holder.judulArtikel.text = item.judul
        holder.deskripsiArtikel.text = item.deskripsi

        holder.itemView.setOnClickListener {
            itemClick.detailArtikel(item)
        }

    }

    interface onClickListener {
        fun detailArtikel(item: Artikel)
    }
}


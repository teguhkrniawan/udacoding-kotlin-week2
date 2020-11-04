package com.teguh.week2.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.teguh.week2.R
import com.teguh.week2.model.Dokter

class DokterAdapter(private val context: Context,private val data: List<Dokter>?) : BaseAdapter() {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_list_dokter, parent, false)

        val fotoDokter = view.findViewById<ImageView>(R.id.item_foto_dokter)
        val namaDokter = view.findViewById<TextView>(R.id.item_nama_dokter)

        fotoDokter.setImageResource(data?.get(position)?.foto ?: 0)
        namaDokter.text = data?.get(position)?.nama ?: "Null data"

        return view
    }

    override fun getItem(position: Int): Any {
        return data?.get(position) ?: 0
    }

    override fun getItemId(potition: Int): Long {
        return potition.toLong()
    }

    override fun getCount(): Int {
        return data?.size ?: 0
    }

}
package com.teguh.week2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Artikel (
    val foto: Int,
    val judul: String,
    val deskripsi: String,
    val url: String
) : Parcelable
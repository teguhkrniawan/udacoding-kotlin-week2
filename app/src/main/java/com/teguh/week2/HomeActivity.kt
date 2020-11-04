package com.teguh.week2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import java.text.DecimalFormat

class HomeActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val name = intent.getStringExtra(MemberIdentityActivity.NAME_EXTRA_KEY)
        val bmi = intent.getDoubleExtra(MemberIdentityActivity.BMI_EXTRA_KEY, 0.0)

        txtNameHome.text = name
        val decimalFormat = DecimalFormat("#.##")
        val textBmi = decimalFormat.format(bmi)
        txtBmiHome.text = "BMI : $textBmi"

        when (bmi) {
            in 18.5..25.0 -> {
                txtStatusBMI.text = "Sehat"
            }
            in 26.0..30.0 -> {
                txtStatusBMI.text = "Obesitas"
            }
            in 1.0..18.0 -> {
                txtStatusBMI.text = "Kurus"
            }
            else -> {
                txtStatusBMI.text = "Over Weight"
            }
        }

        konsultasiDokterBtn.setOnClickListener {
            val intent = Intent(this, ImplementasiListviewActivity::class.java)
            startActivity(intent)
        }

    }
}
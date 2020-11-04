package com.teguh.week2

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.teguh.week2.customdialog.DatePickerDialog
import com.teguh.week2.customdialog.IDatePicker
import kotlinx.android.synthetic.main.activity_member_identity.*
import java.text.SimpleDateFormat
import java.util.*

class MemberIdentityActivity : AppCompatActivity(), IDatePicker {

    private var age: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_identity)

        dateMemberIdentity.setOnClickListener{
            val datePickerDialog = DatePickerDialog()
            datePickerDialog.show(supportFragmentManager, DATE_PICKER_TAG)
        }

        lanjutkanBtnMemberIdentity.setOnClickListener {

            val name = nameMemberIdentity.text.toString()
            val weight = weightMember.text.toString()
            val height = heightMember.text.toString()

            if (weight.isEmpty() && height.isEmpty()){
                Toast.makeText(applicationContext, "Semua field wajib di isi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

           // Penrhitungan BMI
           val heightToMeter: Double = height.toDouble() / 100
           val bmi: Double? =  weight.toDouble() / (heightToMeter.toDouble()*heightToMeter.toDouble())

           if (age != null && bmi != null) {
               if (age!! > 20){
                   val intent = Intent(this, HomeActivity::class.java)
                   intent.putExtra(NAME_EXTRA_KEY, name)
                   intent.putExtra(BMI_EXTRA_KEY, bmi)
                   startActivity(intent)
                   finish()
               } else {
                   ageNotValidDialog(age!!)
               }
           } else
               Toast.makeText(applicationContext, "Semua field wajib di isi", Toast.LENGTH_SHORT).show()
        }
    }

    // callback dari tanggal
    override fun onDateSelected(year: Int, month: Int, day: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)
        age = yourAge(year, month, day)

        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        dateMemberIdentity.setText(dateFormat.format(calendar.time))
    }

    // function hitung umur
    private fun yourAge(year: Int, month: Int,day: Int) : Int{

        val today = Calendar.getInstance()
        val dateSelected = Calendar.getInstance()

        dateSelected.set(year, month, day)

        val ageOfYears = today.get(Calendar.YEAR) - dateSelected.get(Calendar.YEAR)
//        var ageOfMonths = today.get(Calendar.MONTH) - dateSelected.get(Calendar.MONTH)
//        var ageOfDays = today.get(Calendar.DAY_OF_MONTH) - dateSelected.get(Calendar.DAY_OF_MONTH)

//        if (ageOfDays <  0){
//            ageOfMonths--
//            ageOfDays += dateSelected.getActualMaximum(Calendar.DAY_OF_MONTH)
//        }
//
//        if (ageOfMonths < 0){
//            ageOfYears--
//            ageOfMonths += 12
//        }

//        return "$ageOfYears Tahun, $ageOfMonths Bulan, $ageOfDays Hari"
        return ageOfYears
    }

    // function dialog belum cukup umur
    @SuppressLint("SetTextI18n")
    private fun ageNotValidDialog(age: Int){
        if (age < 20) {
           Dialog(this).apply {
               requestWindowFeature(Window.FEATURE_NO_TITLE)
               setCancelable(false)
               setContentView(R.layout.dialog_umur)

               val message = this.findViewById<TextView>(R.id.dialog_message)
               message.text = "Umurmu $age tahun dan kamu tidak di izinkan " +
                       "untuk melanjutkan menggunakan aplikasi ini"

               val btnOk = this.findViewById<Button>(R.id.dialog_button)
               btnOk.setOnClickListener {
                    this.dismiss()
               }

           }.show()
        }
    }

    companion object {
        const val DATE_PICKER_TAG = "date_picker_dialog"
        const val NAME_EXTRA_KEY = "name_extra_key"
        const val BMI_EXTRA_KEY = "bmi_extra_key"
    }
}
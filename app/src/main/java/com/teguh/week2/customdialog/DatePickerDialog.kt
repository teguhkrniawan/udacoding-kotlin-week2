package com.teguh.week2.customdialog

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerDialog : DialogFragment(), DatePickerDialog.OnDateSetListener {

    private var dateListener: IDatePicker? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context != null)
            dateListener = context as IDatePicker
    }

    override fun onDetach() {
        super.onDetach()
        if (dateListener != null)
            dateListener = null
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(activity as Context, this, year, month, day)
    }

    override fun onDateSet(datePicker: DatePicker?, year: Int, month: Int, day: Int) {
        dateListener?.onDateSelected(year,month, day)
    }
}

interface IDatePicker {
    fun onDateSelected(year: Int, month: Int, day: Int)
}
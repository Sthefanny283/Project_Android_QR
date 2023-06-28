package com.cursoklotin.intento.utils

import java.util.Calendar
import java.text.SimpleDateFormat

object DateTimeUtils {
    fun getCurrentDateTime(): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return dateFormat.format(calendar.time)
    }
}

package com.laundry.mendadaklaundry.Class

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalTime
import java.util.Date

class Converters {
    @TypeConverter
    fun fromDatestamp(value: String?): LocalDate? {
        return value?.let { LocalDate.parse(it) }
    }
    @TypeConverter
    fun dateToString(date: LocalDate?): String? {
        return date?.toString()
    }
}
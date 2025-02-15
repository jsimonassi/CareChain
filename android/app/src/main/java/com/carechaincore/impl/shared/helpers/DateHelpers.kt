package com.carechaincore.impl.shared.helpers

import android.annotation.SuppressLint
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.Period
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

object DateHelpers {
    const val dateISOFormat: String = "yyyy-MM-dd'T'HH:mm:ss"
    const val zonedDateISOFormat: String = "yyyy-MM-dd'T'HH:mm:ssZZZZZ"
    const val dateOnlyISOFormat: String = "yyyy-MM-dd"

    @JvmStatic
    fun formatDate(date: Date?, format: String?): String {
        val dateFormatStartDay: DateFormat = SimpleDateFormat(format, Locale.getDefault())
        return dateFormatStartDay.format(date)
    }

    @JvmStatic
    fun convertStringToDate(dateString: String?, format: String?): Date {
        val dateFormatStartDay: DateFormat = SimpleDateFormat(format, Locale.getDefault())
        return dateFormatStartDay.parse(dateString)
    }

    @JvmStatic
    fun formatDate(date: LocalDateTime, format: String?): String {
        val formatter = DateTimeFormatter.ofPattern(format)
        return date.format(formatter)
    }

    @JvmStatic
    fun formatDate(date: ZonedDateTime, format: String?): String {
        val formatter = DateTimeFormatter.ofPattern(format)
        return date.format(formatter)
    }

    @JvmStatic
    fun formatDateISO(date: Date?): String {
        return formatDate(date, dateISOFormat)
    }

    @JvmStatic
    fun formatDateISO(calendar: Calendar): String {
        return formatDate(calendar.time, dateISOFormat)
    }

    @JvmStatic
    fun formatDateISO(date: LocalDateTime): String {
        return date.format(DateTimeFormatter.ofPattern(dateISOFormat))
    }

    @JvmStatic
    fun formatZonedDateISO(date: Date?): String {
        return formatDate(date, zonedDateISOFormat)
    }

    @JvmStatic
    fun formatZonedDateISO(date: ZonedDateTime): String {
        return formatDate(date, zonedDateISOFormat)
    }

    @JvmStatic
    fun formatEpochToISO(epochTimestamp: Long): String {
        val date = Date(epochTimestamp)
        val pattern = dateISOFormat
        @SuppressLint("SimpleDateFormat") val sdf = SimpleDateFormat(pattern)
        return sdf.format(date)
    }

    @JvmStatic
    fun formatDateOnlyISO(date: Date?): String {
        return formatDate(date, dateOnlyISOFormat)
    }

    @JvmStatic
    fun formatDateOnlyISO(date: LocalDateTime): String {
        return date.format(DateTimeFormatter.ofPattern(dateOnlyISOFormat))
    }

    @JvmStatic
    fun formatDateOnlyISO(date: LocalDate): String {
        return date.format(DateTimeFormatter.ofPattern(dateOnlyISOFormat))
    }

    @JvmStatic
    fun addDateMonths(date: Date?, months: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.MONTH, months)
        return calendar.time
    }

    @JvmStatic
    fun addDateMinutes(date: Date?, minutes: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.MINUTE, minutes)
        return calendar.time
    }

    @JvmStatic
    fun addDateSeconds(date: Date?, seconds: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.SECOND, seconds)
        return calendar.time
    }

    @JvmStatic
    fun addDateDays(date: Date?, days: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.DAY_OF_MONTH, days)
        return calendar.time
    }

    @JvmStatic
    fun addStringDateDays(date: Date, days: Int): String {
        val localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
        val modifiedDateTime = localDateTime.minusDays(days.toLong())
        val formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm")
        return modifiedDateTime.format(formatter)
    }

    @JvmStatic
    fun convertToDateTimeKey(calendarTime: String): String {
        val year = calendarTime.substring(0, 4)
        val month = calendarTime.substring(4, 6)
        val day = calendarTime.substring(6, 8)
        val hour = calendarTime.substring(8, 10)
        return year + "-" + month + "-" + day + "T" + hour
    }

    @JvmStatic
    fun convertToDateKey(calendarTime: String): String {
        val year = calendarTime.substring(0, 4)
        val month = calendarTime.substring(4, 6)
        val day = calendarTime.substring(6, 8)
        return "$year-$month-$day"
    }

    @JvmStatic
    fun convertStringToDateKey(dateString: String?): LocalDate {
        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
        return LocalDate.parse(dateString, formatter)
    }

    @JvmStatic
    fun setTimeOfDate(
        date: Date?,
        hours: Int,
        minutes: Int,
        seconds: Int,
        milliseconds: Int
    ): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date

        calendar[Calendar.HOUR_OF_DAY] = hours
        calendar[Calendar.MINUTE] = minutes
        calendar[Calendar.SECOND] = seconds
        calendar[Calendar.MILLISECOND] = milliseconds

        return calendar.time
    }

    @JvmStatic
    fun getDateOnDay(year: Int, month: Int, day: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, 0, 0, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.time
    }

    @JvmStatic
    fun setTimeOfDate(date: Date?, hours: Int, minutes: Int): Date {
        return setTimeOfDate(date, hours, minutes, 0, 0)
    }

    @JvmStatic
    fun addDateHours(date: Date?, hours: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.HOUR_OF_DAY, hours)
        return calendar.time
    }

    @JvmStatic
    fun getDifferenceFullDays(dateA: Date, dateB: Date): Long {
        val diff = dateA.time - dateB.time
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)
    }

    @JvmStatic
    fun getDifferenceYears(dateA: Date, dateB: Date): Int {
        val localDateA = convertToLocalDate(dateA)
        val localDateB = convertToLocalDate(dateB)

        return Period.between(localDateB, localDateA).years
    }

    @JvmStatic
    fun getDifferenceMinutes(dateA: Date, dateB: Date): Long {
        val diff = dateA.time - dateB.time
        return TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS)
    }

    fun getDifferenceSeconds(dateA: Date, dateB: Date): Long {
        val diff = dateA.time - dateB.time
        return TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS)
    }

    @JvmStatic
    fun getSecondsDifferenceByEpoch(endTimestamp: Long, startTimestamp: Long): Int {
        val differenceInSeconds = (endTimestamp - startTimestamp) / 1000
        return differenceInSeconds.toInt()
    }

    @JvmStatic
    fun getStartOfDay(date: Date?): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar[Calendar.HOUR_OF_DAY] = 0
        calendar[Calendar.MINUTE] = 0
        calendar[Calendar.SECOND] = 0
        calendar[Calendar.MILLISECOND] = 0
        return calendar.time
    }

    @JvmStatic
    fun getStartOfHour(date: Date?): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar[Calendar.MINUTE] = 0
        calendar[Calendar.SECOND] = 0
        calendar[Calendar.MILLISECOND] = 0
        return calendar.time
    }

    @JvmStatic
    fun getStartOfHour(isoDate: String?): String? {
        try {
            val date = parseISODate(isoDate)
            val calendar = Calendar.getInstance()
            calendar.time = date
            calendar[Calendar.MINUTE] = 0
            calendar[Calendar.SECOND] = 0
            calendar[Calendar.MILLISECOND] = 0
            return formatDateISO(calendar.time)
        } catch (e: ParseException) {
            return isoDate
        }
    }

    @JvmStatic
    fun getEndOfDay(date: Date?): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar[Calendar.HOUR_OF_DAY] = 23
        calendar[Calendar.MINUTE] = 59
        calendar[Calendar.SECOND] = 59
        calendar[Calendar.MILLISECOND] = 999
        return calendar.time
    }

    @JvmStatic
    fun getHourOfDay(date: Date?): Int {
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar[Calendar.HOUR_OF_DAY]
    }

    @JvmStatic
    fun getMinuteOfHour(date: Date?): Int {
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar[Calendar.MINUTE]
    }

    @Throws(ParseException::class)
    fun parseDate(dateString: String?, format: String?): Date {
        val dateFormatStartDay: DateFormat = SimpleDateFormat(format)
        return dateFormatStartDay.parse(dateString)
    }

    @JvmStatic
    @Throws(ParseException::class)
    fun parseISODate(dateString: String?): Date {
        val dateFormatStartDay: DateFormat = SimpleDateFormat(dateISOFormat)
        return dateFormatStartDay.parse(dateString)
    }

    @Throws(ParseException::class)
    @JvmStatic
    fun parseISODateOnly(dateString: String?): Date {
        val dateFormatStartDay: DateFormat = SimpleDateFormat(dateOnlyISOFormat)
        return dateFormatStartDay.parse(dateString)
    }

    @JvmStatic
    fun parseISODateLocalDate(dateString: String?): LocalDate {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(dateISOFormat))
    }

    @JvmStatic
    fun parseISODateLocalDateTime(dateString: String?): LocalDateTime {
        return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(dateISOFormat))
    }

    @JvmStatic
    fun parseZonedISODateLocalTime(dateString: String?): LocalTime {
        return LocalTime.parse(dateString, DateTimeFormatter.ofPattern(zonedDateISOFormat))
    }

    @JvmStatic
    fun checkIsSameDay(dateA: Date, dateB: Date): Boolean {
        val instantA = dateA.toInstant().truncatedTo(ChronoUnit.DAYS)
        val instantB = dateB.toInstant().truncatedTo(ChronoUnit.DAYS)
        return instantA == instantB
    }

    @JvmStatic
    fun checkIsDateAfter(dateA: Date, dateB: Date): Boolean {
        val instantA = dateA.toInstant()
        val instantB = dateB.toInstant()
        return instantA.compareTo(instantB) > 0
    }

    @JvmStatic
    fun checkIsDateBefore(dateA: Date, dateB: Date): Boolean {
        val instantA = dateA.toInstant()
        val instantB = dateB.toInstant()
        return instantA.compareTo(instantB) < 0
    }

    @JvmStatic
    fun convertToLocalDate(date: Date): LocalDate {
        return date.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate()
    }

    @JvmStatic
    fun getDateTimeFromComponents(
        year: Int,
        month: Int,
        day: Int,
        hour: Int,
        minute: Int,
        second: Int
    ): Date {
        val calendar = Calendar.getInstance()
        calendar[Calendar.YEAR] = year
        calendar[Calendar.MONTH] = month
        calendar[Calendar.DAY_OF_MONTH] = day
        calendar[Calendar.HOUR_OF_DAY] = hour
        calendar[Calendar.MINUTE] = minute
        calendar[Calendar.SECOND] = second
        calendar[Calendar.MILLISECOND] = 0
        return calendar.time
    }
}

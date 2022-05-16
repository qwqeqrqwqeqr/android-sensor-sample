package com.qwqeqrqwqeqr.sensor.util

import com.qwqeqrqwqeqr.sensor.util.Constants.DATE_FORMAT
import com.qwqeqrqwqeqr.sensor.util.Constants.SENSOR_FILE_DATE_FORMAT
import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    fun getDate(): String =
    SimpleDateFormat(DATE_FORMAT, Locale.KOREA).format(Calendar.getInstance().time)


    fun getFileFormatDate(): String =
        SimpleDateFormat(SENSOR_FILE_DATE_FORMAT, Locale.KOREA).format(Calendar.getInstance().time)

}
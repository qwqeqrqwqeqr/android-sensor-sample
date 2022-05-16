package com.qwqeqrqwqeqr.sensor.util

import android.hardware.Sensor

object Constants {

    const val MEASURE_DELAY_TIME = 1000L

    const val LOADING = "loading"

    const val DATE_FORMAT = "yyyy.MM.dd HH:mm:ss"

    const val SENSOR_FILE_DATE_FORMAT = "yyyy_MM_dd_HH_mm_ss"
    const val SENSOR_FILE_TIME_NAME_FORMAT = "시간단위측정_"
    const val SENSOR_FILE_EXTENSIONS_FORMAT = ".csv"

    const val TYPE_ACCELEROMETER = Sensor.TYPE_ACCELEROMETER
    const val TYPE_GAME_ROTATION_VECTOR = Sensor.TYPE_GAME_ROTATION_VECTOR
    const val TYPE_GRAVITY = Sensor.TYPE_GRAVITY
    const val TYPE_GYROSCOPE = Sensor.TYPE_GYROSCOPE
    const val TYPE_LINEAR_ACCELERATION = Sensor.TYPE_LINEAR_ACCELERATION
    const val TYPE_ROTATION_VECTOR = Sensor.TYPE_ROTATION_VECTOR


    const val TYPE_ALL =Sensor.TYPE_ALL

    const val MEASURE_STOP_TOAST_MESSAGE ="측정을 종료합니다."
    const val MEASURE_START_TOAST_MESSAGE = "측정을 시작합니다."

    const val SAVE_FILE_TOAST_MESSAGE = "파일을 저장하였습니다. 파일명 :  "
    const val SAVE_FILE_PATH_TOAST_MESSAGE = "파일경로 :  "

    const val STRING_ACCELEROMETER = "가속도 센서"
    const val STRING_TYPE_GAME_ROTATION_VECTOR = "게임 회전 벡터 센서"
    const val STRING_TYPE_GRAVITY = "중력 센서"
    const val STRING_TYPE_GYROSCOPE = "자이로 스코프 센서"
    const val STRING_TYPE_LINEAR_ACCELERATION = "선형 가속도 센서"
    const val STRING_TYPE_ROTATION_VECTOR = "회전 벡터 센서"

    val SENSOR_DATA_LIST_HEADER : Array<String> =
    arrayOf(
    "측정시각",
    "선형가속도 센서 X",
    "선형가속도 센서 Y",
    "선형가속도 센서 Z",
    "가속도 센서 X",
    "가속도 센서 Y",
    "가속도 센서 Z",
    "자이로스코프 센서 X",
    "자이로스코프 센서 Y",
    "자이로스코프 센서 Z",
    "회전벡터 센서 X",
    "회전벡터 센서 Y",
    "회전벡터 센서 Z",
    "게임회전벡터 센서 X",
    "게임회전벡터 센서 Y",
    "게임회전벡터 센서 Z",
    "중력 센서 X",
    "중력 센서 Y",
    "중력 센서 Z")
}
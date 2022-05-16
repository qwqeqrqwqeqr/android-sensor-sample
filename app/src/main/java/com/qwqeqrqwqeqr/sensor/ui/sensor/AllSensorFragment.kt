package com.qwqeqrqwqeqr.sensor.ui.sensor

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qwqeqrqwqeqr.sensor.databinding.FragmentAllSensorBinding
import com.qwqeqrqwqeqr.sensor.helper.CsvHelper
import com.qwqeqrqwqeqr.sensor.helper.SensorHelper
import com.qwqeqrqwqeqr.sensor.util.Constants
import com.qwqeqrqwqeqr.sensor.util.Constants.MEASURE_DELAY_TIME
import com.qwqeqrqwqeqr.sensor.util.Constants.MEASURE_START_TOAST_MESSAGE
import com.qwqeqrqwqeqr.sensor.util.Constants.SAVE_FILE_PATH_TOAST_MESSAGE
import com.qwqeqrqwqeqr.sensor.util.Constants.SAVE_FILE_TOAST_MESSAGE
import com.qwqeqrqwqeqr.sensor.util.Constants.SENSOR_DATA_LIST_HEADER
import com.qwqeqrqwqeqr.sensor.util.Constants.SENSOR_FILE_EXTENSIONS_FORMAT
import com.qwqeqrqwqeqr.sensor.util.Constants.SENSOR_FILE_TIME_NAME_FORMAT
import com.qwqeqrqwqeqr.sensor.util.DateUtil
import com.qwqeqrqwqeqr.sensor.util.FileUtils.getFilePath
import com.qwqeqrqwqeqr.sensor.util.showToast
import kotlinx.coroutines.*
import kotlin.collections.ArrayList

class AllSensorFragment : Fragment(), SensorEventListener {

    private var _binding: FragmentAllSensorBinding? = null
    private val binding get() = _binding!!
    private lateinit var linearAccelerationSensorHelper: SensorHelper
    private lateinit var accelerometerSensorHelper: SensorHelper
    private lateinit var gameRotationVectorSensorHelper: SensorHelper
    private lateinit var gravitySensorHelper: SensorHelper
    private lateinit var gyroscopeSensorHelper: SensorHelper
    private lateinit var rotationVectorSensorHelper: SensorHelper

    private lateinit var csvHelper: CsvHelper
    private lateinit var dataList: ArrayList<Array<String>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllSensorBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        registerListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        unRegisterListener()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linearAccelerationSensorHelper =
            SensorHelper(requireContext(), Constants.TYPE_LINEAR_ACCELERATION, this)
        accelerometerSensorHelper =
            SensorHelper(requireContext(), Constants.TYPE_ACCELEROMETER, this)
        gameRotationVectorSensorHelper =
            SensorHelper(requireContext(), Constants.TYPE_GAME_ROTATION_VECTOR, this)
        gravitySensorHelper = SensorHelper(requireContext(), Constants.TYPE_GRAVITY, this)
        gyroscopeSensorHelper = SensorHelper(requireContext(), Constants.TYPE_GYROSCOPE, this)
        rotationVectorSensorHelper =
            SensorHelper(requireContext(), Constants.TYPE_ROTATION_VECTOR, this)
        registerListener()


        csvHelper = CsvHelper(requireActivity().getFilePath)
        dataList = arrayListOf<Array<String>>()


        binding.allSensorFragmentTimeMeasureStartBtn.setOnClickListener {
            setStartTimeMeasureView()
            writeTimeSensorData()
        }


    }



    private fun writeTimeSensorData() =
        CoroutineScope(Dispatchers.IO).launch {
            dataList.add(SENSOR_DATA_LIST_HEADER)
            while (true) {
                addSensorData()
                delay(MEASURE_DELAY_TIME)
                binding.allSensorFragmentTimeMeasureStopBtn.setOnClickListener {
                    this.cancel()
                    val fileName = createTimeSensorFile()
                    csvHelper.writeData(fileName, dataList)
                    dataList.clear()
                    requireActivity().showToast(SAVE_FILE_TOAST_MESSAGE + fileName + "\n"+ SAVE_FILE_PATH_TOAST_MESSAGE +   requireActivity().getFilePath)
                    setStopTimeMeasureView()
                }
            }
        }


    private fun registerListener() {
        linearAccelerationSensorHelper.registerListener()
        accelerometerSensorHelper.registerListener()
        gameRotationVectorSensorHelper.registerListener()
        gravitySensorHelper.registerListener()
        gyroscopeSensorHelper.registerListener()
        rotationVectorSensorHelper.registerListener()
    }

    private fun unRegisterListener() {
        linearAccelerationSensorHelper.unRegisterListener()
        accelerometerSensorHelper.unRegisterListener()
        gameRotationVectorSensorHelper.unRegisterListener()
        gravitySensorHelper.unRegisterListener()
        gyroscopeSensorHelper.unRegisterListener()
        rotationVectorSensorHelper.unRegisterListener()
    }


    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor == linearAccelerationSensorHelper.getSensor()) {
            binding.linearAccelerationXAxisText.text = event.values[0].toString()
            binding.linearAccelerationYAxisText.text = event.values[1].toString()
            binding.linearAccelerationZAxisText.text = event.values[2].toString()
        }
        if (event.sensor == accelerometerSensorHelper.getSensor()) {
            binding.accelerometerXAxisText.text = event.values[0].toString()
            binding.accelerometerYAxisText.text = event.values[1].toString()
            binding.accelerometerZAxisText.text = event.values[2].toString()
        }
        if (event.sensor == gameRotationVectorSensorHelper.getSensor()) {
            binding.gameRotationVectorXAxisText.text = event.values[0].toString()
            binding.gameRotationVectorYAxisText.text = event.values[1].toString()
            binding.gameRotationVectorZAxisText.text = event.values[2].toString()
        }
        if (event.sensor == gyroscopeSensorHelper.getSensor()) {
            binding.gyroscopeXAxisText.text = event.values[0].toString()
            binding.gyroscopeYAxisText.text = event.values[1].toString()
            binding.gyroscopeZAxisText.text = event.values[2].toString()
        }
        if (event.sensor == gravitySensorHelper.getSensor()) {
            binding.gravityXAxisText.text = event.values[0].toString()
            binding.gravityYAxisText.text = event.values[1].toString()
            binding.gravityZAxisText.text = event.values[2].toString()
        }
        if (event.sensor == rotationVectorSensorHelper.getSensor()) {
            binding.rotationVectorXAxisText.text = event.values[0].toString()
            binding.rotationVectorYAxisText.text = event.values[1].toString()
            binding.rotationVectorZAxisText.text = event.values[2].toString()
        }


    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }



    private fun setStartTimeMeasureView() {
        binding.allSensorFragmentTimeMeasureStartBtn.visibility = View.GONE
        binding.allSensorFragmentTimeMeasureStopBtn.visibility = View.VISIBLE
        requireActivity().showToast(MEASURE_START_TOAST_MESSAGE)



    }

    private fun setStopTimeMeasureView() {
        binding.allSensorFragmentTimeMeasureStartBtn.visibility = View.VISIBLE
        binding.allSensorFragmentTimeMeasureStopBtn.visibility = View.GONE
    }

    private fun addSensorData() {
        dataList.add(
            arrayOf(
                DateUtil.getDate(),
                binding.linearAccelerationXAxisText.text.toString(),
                binding.linearAccelerationYAxisText.text.toString(),
                binding.linearAccelerationZAxisText.text.toString(),
                binding.accelerometerXAxisText.text.toString(),
                binding.accelerometerYAxisText.text.toString(),
                binding.accelerometerZAxisText.text.toString(),
                binding.gyroscopeXAxisText.text.toString(),
                binding.gyroscopeYAxisText.text.toString(),
                binding.gyroscopeZAxisText.text.toString(),
                binding.rotationVectorXAxisText.text.toString(),
                binding.rotationVectorYAxisText.text.toString(),
                binding.rotationVectorZAxisText.text.toString(),
                binding.gameRotationVectorXAxisText.text.toString(),
                binding.gameRotationVectorYAxisText.text.toString(),
                binding.gameRotationVectorZAxisText.text.toString(),
                binding.gravityXAxisText.text.toString(),
                binding.gravityYAxisText.text.toString(),
                binding.gravityZAxisText.text.toString()
            )
        )
    }

    private fun createTimeSensorFile(): String =
        SENSOR_FILE_TIME_NAME_FORMAT + DateUtil.getFileFormatDate() + SENSOR_FILE_EXTENSIONS_FORMAT







}
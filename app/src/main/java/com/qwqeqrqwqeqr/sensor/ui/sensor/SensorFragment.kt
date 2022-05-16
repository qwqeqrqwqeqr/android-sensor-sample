package com.qwqeqrqwqeqr.sensor.ui.sensor

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.qwqeqrqwqeqr.sensor.databinding.FragmentSensorBinding
import com.qwqeqrqwqeqr.sensor.helper.SensorHelper



class SensorFragment : Fragment(),SensorEventListener {


    private val args : SensorFragmentArgs by navArgs()
    private var _binding :  FragmentSensorBinding? = null
    private val binding get() = _binding!!
    private  lateinit var sensorHelper: SensorHelper


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding  = FragmentSensorBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sensorHelper = SensorHelper(requireContext(), args.sensorType,this)
        setSensorTitle()
        registerListener()
    }


    override fun onResume() {
        super.onResume()
        registerListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        unRegisterListener()
    }

    private fun registerListener() {
        sensorHelper.registerListener()
    }

    private fun unRegisterListener(){
        sensorHelper.unRegisterListener()
    }

    private fun setSensorTitle(){ binding.sensorTitleText.text = args.sensorName }

    override fun onSensorChanged(event: SensorEvent) {
        binding.sensorXAxisText.text = event.values[0].toString()
        binding.sensorYAxisText.text = event.values[1].toString()
        binding.sensorZAxisText.text = event.values[2].toString()
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}


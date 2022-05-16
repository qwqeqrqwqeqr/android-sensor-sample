package com.qwqeqrqwqeqr.sensor.ui

import android.hardware.Sensor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.qwqeqrqwqeqr.sensor.R
import com.qwqeqrqwqeqr.sensor.databinding.FragmentMainBinding
import com.qwqeqrqwqeqr.sensor.util.Constants



class MainFragment : Fragment() {

    private lateinit var binding : FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBtnClickListener()
    }

    private fun setBtnClickListener(){

        binding.mainAllSensorBtn.setOnClickListener {
            Navigation.findNavController(requireActivity(),R.id.main_fragment_container).navigate(
                MainFragmentDirections.actionMainToAllSensor()
            )
        }
        binding.mainHistorySensorBtn.setOnClickListener {
            Navigation.findNavController(requireActivity(),R.id.main_fragment_container).navigate(
                MainFragmentDirections.actionMainToHistory()
            )
        }
        binding.mainGravitySensorBtn.setOnClickListener {
            Navigation.findNavController(requireActivity(),R.id.main_fragment_container).navigate(
                MainFragmentDirections.actionMainToSensor(Constants.TYPE_GRAVITY,Constants.STRING_TYPE_GRAVITY)
            )
        }
        binding.mainAccelometorSensorBtn.setOnClickListener {
            Navigation.findNavController(requireActivity(),R.id.main_fragment_container).navigate(
                MainFragmentDirections.actionMainToSensor(Constants.TYPE_ACCELEROMETER,Constants.STRING_ACCELEROMETER)
            )
        }
        binding.mainLinearAccelerationSensorBtn.setOnClickListener {
            Navigation.findNavController(requireActivity(),R.id.main_fragment_container).navigate(
                MainFragmentDirections.actionMainToSensor(Sensor.TYPE_LINEAR_ACCELERATION,Constants.STRING_TYPE_LINEAR_ACCELERATION)
            )
        }
        binding.mainGameRotaionVectorSensorBtn.setOnClickListener {
            Navigation.findNavController(requireActivity(),R.id.main_fragment_container).navigate(
                MainFragmentDirections.actionMainToSensor(Constants.TYPE_GAME_ROTATION_VECTOR,Constants.STRING_TYPE_GAME_ROTATION_VECTOR)
            )
        }
        binding.mainGyroscopeSensorBtn.setOnClickListener {
            Navigation.findNavController(requireActivity(),R.id.main_fragment_container).navigate(
                MainFragmentDirections.actionMainToSensor(Constants.TYPE_GYROSCOPE,Constants.STRING_TYPE_GYROSCOPE)
            )
        }
        binding.mainRotaionVectorSensorBtn.setOnClickListener {
            Navigation.findNavController(requireActivity(),R.id.main_fragment_container).navigate(
                MainFragmentDirections.actionMainToSensor(Constants.TYPE_ROTATION_VECTOR,Constants.STRING_TYPE_ROTATION_VECTOR)
            )
          }
    }



}
package com.qwqeqrqwqeqr.sensor.ui.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qwqeqrqwqeqr.sensor.model.HistoryEntry
import com.qwqeqrqwqeqr.sensor.databinding.FragmentHistoryBinding
import com.qwqeqrqwqeqr.sensor.util.FileUtils.getFilePath
import java.io.File


class HistoryFragment : Fragment() {

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var historyRecyclerView:RecyclerView
    private lateinit var historyAdapter: HistoryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHistoryBinding.inflate(layoutInflater)

        historyRecyclerView = binding.historyRecyclerView

        historyAdapter = HistoryAdapter(requireContext())


        historyRecyclerView.apply {
            adapter = historyAdapter
            historyAdapter.submitList(getFileList())
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        return binding.root


    }


    fun getFileList():MutableList<HistoryEntry> {
        val directory =  File(requireActivity().getFilePath)
        val files: Array<File> = directory.listFiles()
        var historyEntryList = mutableListOf<HistoryEntry>()

        files.forEach {
            historyEntryList.add(HistoryEntry(it.name))
        }
        if(historyEntryList.isEmpty()){
            historyEntryList.add(HistoryEntry("리스트가 비어있습니다."))
        }
        return historyEntryList

    }

}
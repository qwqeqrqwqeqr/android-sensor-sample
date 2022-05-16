package com.qwqeqrqwqeqr.sensor.ui.history

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.qwqeqrqwqeqr.sensor.model.HistoryEntry
import com.qwqeqrqwqeqr.sensor.databinding.HistoryListEntryBinding

class HistoryAdapter(private val context: Context) :
    RecyclerView.Adapter<HistoryAdapter.HistoryEntriesViewHolder>() {

    inner class HistoryEntriesViewHolder(val binding: HistoryListEntryBinding) :
        RecyclerView.ViewHolder(binding.root)


    private var entries = mutableListOf<HistoryEntry>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistoryAdapter.HistoryEntriesViewHolder {
        return HistoryEntriesViewHolder(
            HistoryListEntryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    }

    override fun onBindViewHolder(holder: HistoryAdapter.HistoryEntriesViewHolder, position: Int) {
        val historyEntry = getItem(position)
        holder.binding.historyItemText.text = historyEntry.name

    }

    var onItemClickListener: ((HistoryEntry) -> Unit)? = null

    fun setItemClickListener(listener: ((HistoryEntry) -> Unit)?) {
        onItemClickListener = listener
    }


    fun submitList(entries: MutableList<HistoryEntry>) {
        this.entries.clear()
        this.entries = entries
        notifyDataSetChanged()}



    override fun getItemCount(): Int {
       return entries.size
    }

    fun getItem(position: Int): HistoryEntry = entries[position]
}
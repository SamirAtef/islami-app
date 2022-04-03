package com.example.islami_final.ui.hadithDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami_final.R

class HadithContenteAdapter : RecyclerView.Adapter<HadithContenteAdapter.ViewHolder>() {
    var items: List<String>? = null;

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val content: TextView = itemView.findViewById(R.id.hadith_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hadith_name, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val versesName = items?.get(position)
        holder.content.setText(versesName)
    }


    override fun getItemCount(): Int = items?.size ?: 0

    fun changeData(verses: List<String>) {
        this.items = verses
        notifyDataSetChanged()

    }


}
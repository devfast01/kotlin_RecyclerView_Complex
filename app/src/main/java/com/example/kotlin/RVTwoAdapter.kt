package com.example.kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RVTwoAdapter    // Parameterized constructor of this
// class to initialize tutorialSubList
    ( // Sub-list item titles will be stored here
    private val tutorialSubList: List<RVTwoModel>
) :
    RecyclerView.Adapter<RVTwoAdapter.ViewHolder>() {
    // Attach the item layout with the proper xml file
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_card_layout_vertical, parent, false)
        return ViewHolder(view)
    }

    // It deals with the setting of different data and methods
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(tutorialSubList[position].name)
    }

    // It returns the length of the RecyclerView
    override fun getItemCount(): Int {
        return tutorialSubList.size
    }

    // The ViewHolder is a java class that stores
    // the reference to the item layout views
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rvTwoText: TextView

        // Link up the Sub-List items layout components with their respective id
        init {
            rvTwoText = itemView.findViewById(R.id.singleItemTextViewRVTwo)
        }

        // setText in Sub-List title text
        fun setData(name: String?) {
            rvTwoText.text = name
        }
    }
}



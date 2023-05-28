package com.example.kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class RVOneAdapter    // Parameterized constructor of this class to initialize tutorialList
    ( // Main-list item titles will be stored here
    private val tutorialList: List<RVOneModel>
) :
    RecyclerView.Adapter<RVOneAdapter.ViewHolder>() {
    // Need this clickListener for the Main-list item onClick events
    private var listener: OnItemsClickListener? = null

    // Main-list item clickListener is initialized
    // This will be used in MainActivity
    fun setWhenClickListener(listener: OnItemsClickListener?) {
        this.listener = listener
    }

    // Attach the item layout with the proper xml file
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.single_card_layout, parent, false)
        return ViewHolder(view)
    }

    // It deals with the setting of different data and methods
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modelItems = tutorialList[position]
        holder.setData(tutorialList[position].name)
        holder.singleItemCardView.setOnClickListener {
            if (listener != null) {
                listener!!.onItemClick(modelItems)
            }
        }
    }

    // It returns the length of the RecyclerView
    override fun getItemCount(): Int {
        return tutorialList.size
    }

    // The ViewHolder is a java class that stores
    // the reference to the item layout views
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var singleItemCardView: CardView
        var singleItemTextView: TextView

        // Link up the Main-List items layout components with their respective id
        init {
            singleItemCardView = itemView.findViewById(R.id.singleItemCardView)
            singleItemTextView = itemView.findViewById(R.id.singleItemTextView)
        }

        // setText in Main-List title text
        fun setData(name: String?) {
            singleItemTextView.text = name
        }
    }

    // Interface to perform events on Main-List item click
    interface OnItemsClickListener {
        fun onItemClick(rvOneModel: RVOneModel?)
    }
}

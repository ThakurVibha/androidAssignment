package com.example.onlinesaleaiassignment.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinesaleaiassignment.R
import com.example.onlinesaleaiassignment.room.entity.MathExpressionEntity


class HistoryAdapter(var listOf: List<MathExpressionEntity?>) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = listOf?.get(position)
        holder.expressionValue.text = ItemsViewModel?.expressionValue

    }

    override fun getItemCount(): Int {
        return listOf.size!!
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val expressionValue: AppCompatTextView = itemView.findViewById(R.id.textView)
    }
}
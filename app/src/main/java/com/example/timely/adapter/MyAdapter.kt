package com.example.timely.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.timely.dataClasses.Periods
import com.example.timely.R

class MyAdapter(private val PeriodList: ArrayList<Periods>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    //this is an adapter class for viewing current period, time, and teachers for that particular day

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = PeriodList[position]
        holder.period.text = currentItem.periodno
        holder.time.text = currentItem.time

        if (currentItem.teacher.toString() != "null") {
            holder.teacher.text = currentItem.teacher
        }
        else{
            holder.teacher.text = ""
        }
        if (currentItem.subject.toString() != "null") {
            holder.subject.text = currentItem.subject
        }
        else{
            holder.subject.text = ""
        }


    }

    override fun getItemCount(): Int {
        return PeriodList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val period: TextView = itemView.findViewById(R.id.Period)
        val teacher: TextView = itemView.findViewById(R.id.Teacher)
        val subject: TextView = itemView.findViewById(R.id.Subject)
        val time: TextView = itemView.findViewById(R.id.Time)
    }
}

package com.instanect.task.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.instanect.task.R
import com.instanect.task.business_layer.TaskEntity

class TaskListAdapter(list: List<TaskEntity>) : RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {

    private var list: List<TaskEntity> = ArrayList();

    init {
        this.list = list
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewId: TextView? = itemView.findViewById(R.id.textViewIdTask)
        val textViewTask: TextView? = itemView.findViewById(R.id.textViewTask)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.task_list_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = list[position];
        holder.textViewTask?.text = task.task
        holder.textViewId?.text = task.idTask.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }


    fun setData(newData: List<TaskEntity>) {
        this.list = newData
        notifyDataSetChanged()
    }

}
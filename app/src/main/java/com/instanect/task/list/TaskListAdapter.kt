package com.instanect.task.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.instanect.task.R
import com.instanect.task.business_layer.database.TaskEntity

class TaskListAdapter(list: List<TaskEntity>, taskListAdapterListener: TaskListAdapterListener) :
    RecyclerView.Adapter<TaskListAdapter.ViewHolder>(),
    View.OnClickListener {

    private var list: List<TaskEntity> = ArrayList()
    private var taskListAdapterListener: TaskListAdapterListener? = null

    init {
        this.list = list
        this.taskListAdapterListener = taskListAdapterListener
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewId: TextView? = view.findViewById(R.id.textViewIdTask)
        val textViewTask: TextView? = view.findViewById(R.id.textViewTask)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.task_list_item,
            parent, false
        )
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = list[position]
        holder.textViewTask?.text = task.task
        holder.textViewId?.text = task.idTask.toString()
        holder.itemView.setOnClickListener(this)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    fun setData(newData: List<TaskEntity>) {
        this.list = newData
        notifyDataSetChanged()
    }

    override fun onClick(v: View?) {
        taskListAdapterListener?.onItemClick(v)
    }

}
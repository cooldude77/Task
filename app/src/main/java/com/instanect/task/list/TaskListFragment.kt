package com.instanect.task.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.instanect.task.R
import com.instanect.task.business_layer.database.TaskEntity

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TaskListFragment : Fragment(),TaskListAdapterListener {


    private lateinit var taskListAdapter: TaskListAdapter
    private var list: List<TaskEntity> = ArrayList()

    private var taskListFragmentInterface: TaskListFragmentInterface? = null

    companion object {

        fun newInstance(
            list: List<TaskEntity>,
            taskListFragmentInterface: TaskListFragmentInterface?
        ): TaskListFragment {
            val f = TaskListFragment()
            f.list = list
            f.taskListFragmentInterface = taskListFragmentInterface
            return f

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.task_list_fragment, container, false)
        taskListAdapter = TaskListAdapter(list,this)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler_view_task_list)

        recycler.adapter = taskListAdapter
        recycler.layoutManager = LinearLayoutManager(activity)
        // Inflate the layout for this fragment
        return view
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.title = "Task List"
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        taskListFragmentInterface?.onTaskListAdded()
    }

    fun updateList(list: List<TaskEntity>) {
        this.list = list
        taskListAdapter.setData(list)
    }

    override fun onItemClick(v: View?) {
        taskListFragmentInterface?.onClick(v)
    }
}

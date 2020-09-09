package com.instanect.task.create

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.instanect.task.R
import com.instanect.task.business_layer.TaskEntity
import kotlinx.android.synthetic.main.task_operation_fragment.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class TaskDetailFragment() : Fragment() {

    private  var idTask: Int = -1
    private lateinit var taskOperationInterface: TaskOperationInterface

    companion object {
        public fun newInstance(
            taskCreateInterface: TaskOperationInterface,
            idTask: Int
        ): TaskDetailFragment {
            val f = TaskDetailFragment();
            f.idTask = idTask
            f.taskOperationInterface = taskCreateInterface
            return f
        }
        public fun newInstance(
            taskCreateInterface: TaskOperationInterface
        ): TaskDetailFragment {
            val f = TaskDetailFragment();
            f.taskOperationInterface = taskCreateInterface
            return f
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.task_operation_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(idTask != -1)
            taskOperationInterface.getTaskEntityFromIdTask(idTask)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

         }

    private fun updateFragment(task: TaskEntity) {
        TODO("Not yet implemented")
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true);
        (activity as AppCompatActivity).supportActionBar?.title = "Create New Task";

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_operation, menu);
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> showExitAlert();
            R.id.save -> validateAndSave()
        }
        return false;
    }

    private fun validateAndSave() {

        (activity as AppCompatActivity).supportFragmentManager.popBackStack();
        taskOperationInterface.onSavePressed(editTextTask.text.toString());

    }

    private fun showExitAlert() {
        (activity as AppCompatActivity).supportFragmentManager.popBackStack();
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false);
    }

    fun updateLayout(task: TaskEntity) {
        view?.findViewById<TextView>(R.id.textViewIdTask)?.text = task.idTask.toString()
        view?.findViewById<EditText>(R.id.editTextTask)?.setText( task.task)
    }
}

package com.instanect.task.create

import android.os.Bundle
import android.view.*
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.instanect.task.R
import com.instanect.task.business_layer.TaskEntity
import kotlinx.android.synthetic.main.task_operation_fragment.*


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class TaskDetailFragment : Fragment() {

    private var tilTask: TextInputLayout? = null
    private var tITask: TextInputEditText? = null
    private var tvIdTask: TextView? = null

    private var idTask: Int = -1
    private lateinit var taskOperationInterface: TaskOperationInterface

    companion object {
        fun newInstance(
            taskCreateInterface: TaskOperationInterface,
            idTask: Int
        ): TaskDetailFragment {
            val f = TaskDetailFragment()
            f.idTask = idTask
            f.taskOperationInterface = taskCreateInterface
            return f
        }

        fun newInstance(
            taskCreateInterface: TaskOperationInterface
        ): TaskDetailFragment {
            val f = TaskDetailFragment()
            f.taskOperationInterface = taskCreateInterface
            return f
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)

        val view = inflater.inflate(R.layout.task_operation_fragment, container, false)
        tITask = view.findViewById(R.id.editTextTask)
        tvIdTask = view.findViewById(R.id.textViewIdTask)
        tilTask = view.findViewById(R.id.textInputLayout)

        tvIdTask?.text = (-1).toString()

        // Inflate the layout for this fragment
        return view
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.title = "Create New Task"
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_operation, menu)

        //   if (idTask == -1)
        //     menu.findItem(R.id.delete).isVisible = false

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> showExitAlert()
            R.id.save -> validateAndSave()
            R.id.delete -> deleteTask()
        }
        return false
    }

    private fun deleteTask() {
         (activity as AppCompatActivity).supportFragmentManager.popBackStack()
        taskOperationInterface.onDeletePressed(
            textViewIdTask.text.toString().toInt()
        )

    }

    private fun validateAndSave() {
        if (tITask == null)
            textInputLayout.error = "Task Cannot be null"
        else {
            (activity as AppCompatActivity).supportFragmentManager.popBackStack()
            taskOperationInterface.onSavePressed(
                textViewIdTask.text.toString().toInt(),
                editTextTask.text.toString()
            )
        }
    }

    private fun showExitAlert() {
        (activity as AppCompatActivity).supportFragmentManager.popBackStack()
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    fun updateLayout(task: TaskEntity) {
        view?.findViewById<TextView>(R.id.textViewIdTask)?.text = task.idTask.toString()
        view?.findViewById<EditText>(R.id.editTextTask)?.setText(task.task)
    }
}

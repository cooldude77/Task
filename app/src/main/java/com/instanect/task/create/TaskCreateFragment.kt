package com.instanect.task.create

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.instanect.task.R
import kotlinx.android.synthetic.main.task_create_fragment.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class TaskCreateFragment : Fragment() {

    private lateinit var taskCreateInterface: TaskCreateInterface
    private var isNew: Boolean = true

    companion object {
        public fun newInstance(taskCreateInterface: TaskCreateInterface): TaskCreateFragment {
            var f = TaskCreateFragment();
            f.taskCreateInterface = taskCreateInterface
            return f
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (arguments == null)
            isNew = true;

        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.task_create_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true);
        (activity as AppCompatActivity).supportActionBar?.title = "Create New Task";

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_create, menu);
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
        taskCreateInterface.onSavePressed(editTextTask.text.toString());

    }

    private fun showExitAlert() {
        (activity as AppCompatActivity).supportFragmentManager.popBackStack();
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false);
    }
}

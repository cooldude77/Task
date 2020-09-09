package com.instanect.task

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import com.instanect.task.business_layer.TaskDatabase
import com.instanect.task.business_layer.TaskEntity
import com.instanect.task.create.TaskDetailFragment
import com.instanect.task.create.TaskOperationInterface
import com.instanect.task.list.TaskListFragment
import com.instanect.task.list.TaskListFragmentInterface
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity(), TaskOperationInterface, TaskListFragmentInterface {

    private var list: List<TaskEntity> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        loadListFragment()

        fab.setOnClickListener { view ->
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.id_fragment,
                    TaskDetailFragment.newInstance(this),
                    "TAG_CREATE"
                )
                .addToBackStack(null)
                .commit()
        }
    }

    private fun getDb(): TaskDatabase {
        return Room.databaseBuilder(
            applicationContext,
            TaskDatabase::class.java, "task.db"
        ).build()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onSavePressed(idTask: Int, text: String) {

        GlobalScope.launch { // coroutine on Main

            val db = getDb()

            if (idTask == -1) {
                val task = TaskEntity()
                task.task = text
                db.taskDAO.insert(task)
                Snackbar.make(findViewById(R.id.fab), "Task Created", Snackbar.LENGTH_SHORT).show()
            } else {
                val task = db.taskDAO.findById(idTask)
                task.task = text
                db.taskDAO.update(task)
                Snackbar.make(findViewById(R.id.fab), "Task Updated", Snackbar.LENGTH_SHORT).show()

            }
        }
    }

    override fun getTaskEntityFromIdTask(idTask: Int) {
        GlobalScope.launch(Dispatchers.IO) {
            val task = getDb().taskDAO.findById(idTask)

            withContext(Dispatchers.Main) {
                val listFragment =
                    supportFragmentManager.findFragmentByTag("TAG_UPDATE") as TaskDetailFragment

                listFragment.updateLayout(task)
            }
        }
    }

    override fun onDeletePressed(idTask: Int) {
        GlobalScope.launch { // coroutine on Main
            val db = getDb()
            val task = db.taskDAO.findById(idTask)
            db.taskDAO.delete(task)
            Snackbar.make(findViewById(R.id.fab), "Task Deleted", Snackbar.LENGTH_SHORT).show()

        }
    }


    private fun loadList() {
        GlobalScope.launch(Dispatchers.IO) { // coroutine on Main
            list = getDb().taskDAO.getAll()
            withContext(Dispatchers.Main) {
                updateList(list)
            }
        }
    }

    private fun loadListFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.id_fragment,
                TaskListFragment.newInstance(list, this),
                "TAG_LIST"
            )
            .addToBackStack(null)
            .commit()
    }

    private fun updateList(list: List<TaskEntity>) {
        val listFragment =
            supportFragmentManager.findFragmentByTag("TAG_LIST") as TaskListFragment

        listFragment.updateList(list)

    }

    override fun onTaskListAdded() {
        loadList()
    }

    override fun onClick(v: View?) {

        val idTask = v?.findViewById<TextView>(R.id.textViewIdTask)?.text.toString().toInt()

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.id_fragment,
                TaskDetailFragment.newInstance(this, idTask),
                "TAG_UPDATE"
            )
            .commit()

    }


}

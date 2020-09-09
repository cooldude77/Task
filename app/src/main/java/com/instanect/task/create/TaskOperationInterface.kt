package com.instanect.task.create

interface TaskOperationInterface {
    fun onSavePressed(idTask: Int, text: String)
    fun getTaskEntityFromIdTask(idTask: Int)
    fun onDeletePressed(idTask: Int)
}
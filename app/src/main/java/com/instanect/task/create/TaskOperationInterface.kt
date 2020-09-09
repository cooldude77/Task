package com.instanect.task.create

import com.instanect.task.business_layer.TaskEntity

interface TaskOperationInterface {
    fun onSavePressed(text: String)
    fun getTaskEntityFromIdTask(idTask: Int)
}
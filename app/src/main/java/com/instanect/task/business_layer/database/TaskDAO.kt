package com.instanect.task.business_layer.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface TaskDAO {
    @Insert
    fun insert(task: TaskEntity)

    @Update
    fun update(task: TaskEntity)

    @Delete
    fun delete(task: TaskEntity)

    // @Query("SELECT * FROM task")
    // fun getAll(): List<TaskEntity>

    // @Query("SELECT * FROM task WHERE idTask LIKE :idTask")
    //fun findById(idTask: Int): TaskEntity


}
package com.instanect.task.business_layer

import androidx.room.*

@Dao
interface TaskDAO {
    @Insert
    fun insert(task: TaskEntity)

    @Update
    fun update(task: TaskEntity)

    @Delete
    fun delete(task: TaskEntity)

    @Query("SELECT * FROM task")
    fun getAll(): List<TaskEntity>

    @Query("SELECT * FROM task WHERE idTask LIKE :idTask")
    fun findById(idTask: Int): TaskEntity


}
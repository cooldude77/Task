package com.instanect.task.business_layer

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "task")
class TaskEntity {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idTask")
    var idTask: Int? = null

    @NonNull
    @ColumnInfo(name = "task")
    lateinit var task: String

    @NonNull
    @ColumnInfo(name = "createAt")
    var createdAt: String = Date(System.currentTimeMillis()).toString()

    @NonNull
    @ColumnInfo(name = "updatedAt")
    var updatedAt: String

    init {
        updatedAt = createdAt

    }
}
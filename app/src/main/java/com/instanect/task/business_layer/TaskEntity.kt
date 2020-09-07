package com.instanect.task.business_layer

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "task")
public class TaskEntity() {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idTask")
    var idTask: Int? = null

    @NonNull
    @ColumnInfo(name = "task")
    var task: String? = null

    @NonNull
    @ColumnInfo(name = "createAt")
    var createdAt: String? = null

    @NonNull
    @ColumnInfo(name = "updatedAt")
    var updatedAt: String? = null

    init {
        createdAt = Date(System.currentTimeMillis()).toString()
        updatedAt = createdAt

    }
}
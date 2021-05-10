package com.demo.daggerroomdbdemo.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_entity")
class UserEntity(
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id") val id: Int =0,
    @ColumnInfo(name = "desc")val name: String
)

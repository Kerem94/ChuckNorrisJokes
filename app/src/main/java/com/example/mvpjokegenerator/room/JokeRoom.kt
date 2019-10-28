package com.example.mvpjokegenerator.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "joke_table")
data class JokeRoom(@PrimaryKey @ColumnInfo val joke: String, val id: Int, val category: MutableList<String>)

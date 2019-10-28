package com.example.mvpjokegenerator.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvpjokegenerator.model.Joke

@Dao
interface JokeDao{
    @Query("SELECT * from joke_table ORDER BY joke ASC")
    fun getAplhabetizedWords(): LiveData<List<Joke>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(joke: Joke)

    @Query("DELETE FROM joke_table")
    suspend fun deleteALL()
}
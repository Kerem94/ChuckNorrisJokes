package com.example.mvpjokegenerator.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvpjokegenerator.model.Joke

@Database(entities = arrayOf(Joke::class),version = 1)
public abstract class JokeRoomDatabase : RoomDatabase(){

    abstract fun jokeDao(): JokeDao

    companion object{

        @Volatile
        private var INSTANCE : JokeRoomDatabase? = null

        fun getDatabase(conext: Context): JokeRoomDatabase{
            val temInstance = INSTANCE
            if(temInstance != null){
                return temInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    conext.applicationContext,
                    JokeRoomDatabase::class.java,
                    "joke_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}
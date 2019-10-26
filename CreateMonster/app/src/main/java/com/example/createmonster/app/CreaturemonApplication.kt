package com.example.createmonster.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.createmonster.model.room.CreatureDatabase

class CreaturemonApplication : AppCompatActivity() {

    companion object {
        lateinit var database: CreatureDatabase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        database = Room.databaseBuilder(this, CreatureDatabase::class.java, "creature_database").build()
    }
}

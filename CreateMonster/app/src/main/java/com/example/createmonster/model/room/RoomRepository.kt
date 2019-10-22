package com.example.createmonster.model.room

import android.os.AsyncTask
import com.example.createmonster.app.CreaturemonApplication
import com.example.createmonster.model.Creature
import com.example.createmonster.model.CreatureRepository

class RoomRepository : CreatureRepository {
    private val creatureDao: CreatureDao = CreaturemonApplication.database.creatureDao()

    private class InsertAsyncTask internal constructor(private val dao: CreatureDao) : AsyncTask<Creature, Void, Void>() {
        override fun doInBackground(vararg params: Creature): Void? {
            return null
        }
    }

    private class DeleteAsyncTask internal constructor(private val dao: CreatureDao) : AsyncTask<Creature, Void, Void>() {
        override fun doInBackground(vararg params: Creature): Void? {
            return null
        }
    }
}

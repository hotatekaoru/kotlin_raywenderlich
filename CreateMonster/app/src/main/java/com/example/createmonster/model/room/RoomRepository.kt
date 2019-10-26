package com.example.createmonster.model.room

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.createmonster.app.CreaturemonApplication
import com.example.createmonster.model.Creature
import com.example.createmonster.model.CreatureRepository

class RoomRepository : CreatureRepository {
    private val creatureDao: CreatureDao = CreaturemonApplication.database.creatureDao()
    private val allCreatures: LiveData<List<Creature>>

    init {
        allCreatures = creatureDao.getAllCreatures()
    }

    override fun saveCreature(creature: Creature) {
        InsertAsyncTask(creatureDao).execute(creature)
    }

    override fun getAllCreatures(): LiveData<List<Creature>> = allCreatures

    override fun clearAllCreatures() {
        val creatureArray = allCreatures.value?.toTypedArray()
        if (creatureArray != null && creatureArray.isNotEmpty()) {
            DeleteAsyncTask(creatureDao).execute(*creatureArray)
        }
    }

    private class InsertAsyncTask internal constructor(private val dao: CreatureDao) : AsyncTask<Creature, Void, Void>() {
        override fun doInBackground(vararg params: Creature): Void? {
            dao.insert(params[0])
            return null
        }
    }

    private class DeleteAsyncTask internal constructor(private val dao: CreatureDao) : AsyncTask<Creature, Void, Void>() {
        override fun doInBackground(vararg params: Creature): Void? {
            dao.clearCreatures(*params)
            return null
        }
    }
}

package com.example.createmonster.viewmodel

import androidx.lifecycle.ViewModel
import com.example.createmonster.model.CreatureRepository
import com.example.createmonster.model.room.RoomRepository

class AllCreaturesViewModel(private val repository: CreatureRepository = RoomRepository()) : ViewModel() {

    private val allCreaturesLiveData = repository.getAllCreatures()

    fun getAllCreaturesLiveData() = allCreaturesLiveData
    fun clearAllCreatures() = repository.clearAllCreatures()
}

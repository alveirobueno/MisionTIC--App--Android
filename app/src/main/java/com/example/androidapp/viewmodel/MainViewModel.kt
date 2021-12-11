package com.example.androidapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidapp.model.SiteModel
import com.example.androidapp.network.RetroInstance
import com.example.androidapp.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class MainViewModel: ViewModel() {
    var recyclerListLiveData: MutableLiveData<ArrayList<SiteModel>> = MutableLiveData()

    fun getRecyclerListObserver(): MutableLiveData<ArrayList<SiteModel>> {
        return recyclerListLiveData
    }

    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance()
            val retroService = retroInstance.create(RetroService::class.java)
            val response = retroService.getDataFromApi()
            recyclerListLiveData.postValue(response)

        }
    }
}

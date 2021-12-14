package com.example.sitiosmisiontic.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidapp.model.SiteModel
import com.example.sitiosmisiontic.network.RetrofitInstance
import com.example.sitiosmisiontic.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.create

class MainViewModel : ViewModel() {

    private var SiteModelLiveData : MutableLiveData<SiteModel> = MutableLiveData()

    fun getSiteModelObserver(): MutableLiveData<SiteModel> {
        return SiteModelLiveData
    }

    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetrofitInstance.getRetroInstance()
            val retroService = retroInstance.create(RetrofitService::class.java)
            val response = retroService.getDataFromApi()
            SiteModelLiveData.postValue(response)
        }
    }
}
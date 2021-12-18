package com.example.sitiosmisiontic.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sitiosmisiontic.model.SiteModel
import com.example.sitiosmisiontic.network.RetrofitInstance
import com.example.sitiosmisiontic.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var siteModelLiveData: MutableLiveData<SiteModel> = MutableLiveData()
    private val retroService = RetrofitInstance.getRetroInstance().create(RetrofitService::class.java)

    fun getSiteModelObserver(): LiveData<SiteModel> {
        return siteModelLiveData
    }

    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = retroService.requestPois()
            siteModelLiveData.postValue(response)
        }
    }

    fun makeApiCall2() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = retroService.requestPois()
            siteModelLiveData.postValue(response)
        }
    }
}
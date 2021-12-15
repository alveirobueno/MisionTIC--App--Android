package com.mintic.travelappfinal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ListViewModel: ViewModel() {

    private var apiService = RetrofitFactory.apiService()
    private var sitiosList = MutableLiveData<List<Sitios>>()
    private var isFailure = MutableLiveData(false)

    init{
        requestCityFromService()
    }

    fun getIsFailure(): LiveData<Boolean> = isFailure

    fun getSitios(): LiveData<List<Sitios>> = sitiosList


    private fun requestCityFromService(){
        viewModelScope.launch{
            sitiosList.value = apiService.requestSitios()
        }

    }

}
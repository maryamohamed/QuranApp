package com.tech.quranapp.ui.surahdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tech.quranapp.networking.RetrofitConnection
import com.tech.quranapp.util.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val retrofitConnection : RetrofitConnection) :
    ViewModel() {

    private val _ayahsData = MutableLiveData<NetworkState>()
    val ayahsData get() = _ayahsData
    fun loadAyahsData(surahId : Int) {
        _ayahsData.postValue(NetworkState.LOADING)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = retrofitConnection.getSurahDetails(surahId)
                _ayahsData.postValue(NetworkState.getLoaded(data))
            } catch (ex : Exception) {
                _ayahsData.postValue(NetworkState.getErrorMessage(ex))
            }
        }
    }
}
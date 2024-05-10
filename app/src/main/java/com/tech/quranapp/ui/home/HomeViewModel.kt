package com.tech.quranapp.ui.home

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
class HomeViewModel @Inject constructor(private val retrofitConnection : RetrofitConnection) :
    ViewModel() {

    private val _homeViewModel = MutableLiveData<NetworkState>()
    val homeViewModel
        get() = _homeViewModel

    fun getSurah() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = retrofitConnection.getSurah()
                _homeViewModel.postValue(NetworkState.getLoaded(data))
            } catch (ex : Exception) {
                _homeViewModel.postValue(NetworkState.getErrorMessage(ex))
            }
        }
    }

}

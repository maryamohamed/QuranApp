package com.tech.quranapp.ui.surahdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tech.quranapp.data.remote.model.Ayah
import com.tech.quranapp.data.remote.model.Surah
import com.tech.quranapp.networking.RetrofitConnection
import com.tech.quranapp.utils.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class DetailsViewModel @Inject constructor(private val retrofitConnection : RetrofitConnection) :
    ViewModel() {

    private val _ayatData = MutableLiveData<NetworkState>()
    val ayatData get() = _ayatData
    fun loadAyatData(surah : Surah){
        _ayatData.postValue(NetworkState.LOADING)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = retrofitConnection.getAyat()
                _ayatData.postValue(NetworkState.getLoaded(data))
            } catch (ex: Exception) {
                _ayatData.postValue(NetworkState.getErrorMessage(ex))
            }
        }
    }
}
package com.example.newsapiclient.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newsapiclient.data.model.APIResponse
import com.example.newsapiclient.data.util.Resource
import com.example.newsapiclient.domain.usecase.GetNewsHeadlinesUseCase
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(
    private val app: Application,
    val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase
) : AndroidViewModel(app) {

    private val newHeadlies: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getNewsHeadlines(country: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        newHeadlies.postValue(Resource.Loading())
        try {
            if (isNetworkAvalilable(app)) {
                val apiResult = getNewsHeadlinesUseCase(country, page)
                newHeadlies.postValue(apiResult)

            } else {
                newHeadlies.postValue(Resource.Error("Internet no disponible"))
            }

        } catch (e: Exception) {
            newHeadlies.postValue(Resource.Error(e.message.orEmpty()))
        }
    }

    private fun isNetworkAvalilable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }

        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null &&
                activeNetworkInfo.isConnected
            ) {
                return true
            }
        }
        return false
    }
}
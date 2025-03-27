package com.example.amphibians

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.AmphibianApi
import kotlinx.coroutines.launch

class AmphibiansViewModel : ViewModel() {
    var uiState: UiState by mutableStateOf(UiState.Loading)
        private set

    init {
        getAmphibians()
    }

    private fun getAmphibians() {
        viewModelScope.launch {
            uiState = try {
                val listResult = AmphibianApi.retrofitService.getAmphibians()
                UiState.Success(listResult)
            } catch (e: Exception) {
                UiState.Error
            }
        }
    }
}

sealed interface UiState {
    object Loading : UiState
    data class Success(val amphibians: List<Amphibian>) : UiState
    object Error : UiState
}
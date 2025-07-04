package com.engineers100X.pocketbills.utils.viewState

import com.engineers100X.pocketbills.model.Transaction

sealed class DetailState {
    object Loading : DetailState()
    object Empty : DetailState()
    data class Success(val transaction: Transaction) : DetailState()
    data class Error(val exception: Throwable) : DetailState()
}

package com.engineers100X.pocketbills.utils.viewState

import com.engineers100X.pocketbills.model.Transaction

sealed class ViewState {
    object Loading : ViewState()
    object Empty : ViewState()
    data class Success(val transaction: List<Transaction>) : ViewState()
    data class Error(val exception: Throwable) : ViewState()
}

package com.example.mvvmwithretrofit.model

data class BaseResponseModel(
    val status_code: Int,
    val status_message: String,
    val success: Boolean
)
package com.example.mvvmwithretrofit.model

data class Movies(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int,
    val status_code: Int,
    val status_message: String,
    val success: Boolean
)
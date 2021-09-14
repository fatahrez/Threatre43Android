package com.fatah.data.remote.models

import com.google.gson.annotations.SerializedName

data class ResultNetworkWrapper(
    @SerializedName("page")val page: Number,
    @SerializedName("results") val results: ArrayList<ResultNetwork>,
    @SerializedName("total_pages") val totalPages: Number,
    @SerializedName("total_results") val totalResults: Number
)

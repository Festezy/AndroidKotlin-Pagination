package com.example.testpagination2.data


import com.google.gson.annotations.SerializedName

data class DataJObject(
    @SerializedName("current_page")
    val currentPage: Int?, // 2
    @SerializedName("data")
    val `data`: List<DataJArrray>?,
    @SerializedName("per_page")
    val perPage: Int? // 4
)
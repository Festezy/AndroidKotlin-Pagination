package com.example.testpagination2.data.response


import com.google.gson.annotations.SerializedName

data class CampaignResponse(
    @SerializedName("data")
    val `data`: DataJObject?,
    @SerializedName("message")
    val message: String?, // List Data Campaigns
    @SerializedName("success")
    val success: Boolean? // true
)
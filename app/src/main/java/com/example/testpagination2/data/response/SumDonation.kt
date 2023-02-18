package com.example.testpagination2.data.response


import com.google.gson.annotations.SerializedName

data class SumDonation(
    @SerializedName("campaign_id")
    val campaignId: String?, // 2
    @SerializedName("total")
    val total: String? // 10000
)
package com.example.testpagination2.services

import com.example.testpagination2.data.response.CampaignResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("campaign")
    fun getCampaign(
        @QueryMap parameters: HashMap<String, String>
    ): Call<CampaignResponse>

}
package com.example.testpagination2.data.response


import com.google.gson.annotations.SerializedName

data class DataJArrray(
    @SerializedName("category_id")
    val categoryId: String?, // 1
    @SerializedName("created_at")
    val createdAt: String?, // 2023-02-08T10:03:43.000000Z
    @SerializedName("description")
    val description: String?, // <p>kabur cok</p>
    @SerializedName("id")
    val id: Int?, // 2
    @SerializedName("image")
    val image: String?, // https://backend-donasi.zoinix.com/storage/campaigns/wmhGzI70ShxadgM9VjFlowj8e6WdzZFtoD9rJVux.png
    @SerializedName("max_date")
    val maxDate: String?, // 2023-03-31
    @SerializedName("slug")
    val slug: String?, // tsunami-besar
    @SerializedName("sum_donation")
    val sumDonation: List<SumDonation?>?,
    @SerializedName("target_donation")
    val targetDonation: String?, // 15000000
    @SerializedName("title")
    val title: String?, // Tsunami Besar
    @SerializedName("updated_at")
    val updatedAt: String?, // 2023-02-08T10:03:43.000000Z
    @SerializedName("user")
    val user: UserAdmin?,
    @SerializedName("user_id")
    val userId: String? // 1
)
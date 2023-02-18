package com.example.testpagination2.data.response


import com.google.gson.annotations.SerializedName

data class UserAdmin(
    @SerializedName("avatar")
    val avatar: String?, // https://ui-avatars.com/api/?name=Admin+Donasi&background=4e73df&color=ffffff&size=100
    @SerializedName("created_at")
    val createdAt: Any?, // null
    @SerializedName("email")
    val email: String?, // admin@gmail.com
    @SerializedName("email_verified_at")
    val emailVerifiedAt: Any?, // null
    @SerializedName("id")
    val id: Int?, // 1
    @SerializedName("name")
    val name: String?, // Admin Donasi
    @SerializedName("updated_at")
    val updatedAt: Any? // null
)
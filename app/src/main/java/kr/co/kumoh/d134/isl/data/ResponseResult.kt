package kr.co.kumoh.d134.isl.base.response

import com.google.gson.annotations.SerializedName

/**
 * Created by KimBH on 2022/07/12.
 */
data class ResponseResult(
    @SerializedName("code")
    val code: Int,

    @SerializedName("message")
    val message: String,

    @SerializedName("action")
    val action: String
)

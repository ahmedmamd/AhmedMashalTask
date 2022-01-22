package com.example.task.pojo.popularStare

import com.google.gson.annotations.SerializedName
import retrofit2.http.Url

class Owner {

    @SerializedName("login")
    var login:String?=null
    @SerializedName("id")
    var id:Int=0
    @SerializedName("node_id")
    var node_id:String?=null
    @SerializedName("avatar_url")
    var avatar_url: String?=null
}
package com.example.task.pojo.popularStare

import com.google.gson.annotations.SerializedName

class Items {

    @SerializedName("id")
    var id:Int=0
    @SerializedName("node_id")
    var node_id:String?=null
    @SerializedName("name")
    var name:String?=null
    @SerializedName("full_name")
    var full_name:String?=null
    @SerializedName("private")
    var private:Boolean=false
    @SerializedName("language")
    var language:String?=null
    @SerializedName("owner")
    var owner:Owner=Owner()


}
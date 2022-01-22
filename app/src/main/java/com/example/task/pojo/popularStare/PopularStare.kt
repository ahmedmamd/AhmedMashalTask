package com.example.task.pojo.popularStare

import com.google.gson.annotations.SerializedName
import java.util.HashMap

class PopularStare {

    @SerializedName("total_count")
    var total_count:Int=0
    @SerializedName("incomplete_results")
    var incomplete_results:Boolean = true
    @SerializedName("total_pages")
    var total_pages:Int = 0
    @SerializedName("items")
    var items:ArrayList<Items> = ArrayList()

}
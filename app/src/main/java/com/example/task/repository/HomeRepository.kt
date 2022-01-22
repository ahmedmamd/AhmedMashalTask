package com.example.task.repository

import android.content.Context
import com.example.task.data.ApiServices
import com.example.task.data.Apiinterface
import com.example.task.pojo.popularStare.PopularStare
import io.reactivex.rxjava3.core.Observable


class HomeRepository(context: Context?)  {
    var apiInterface: Apiinterface? = null

    val q= "created:>2019-01-10"
    val sort = "stars"
    val order = "desc"

    fun popular(context: Context?): Observable<PopularStare> {
        apiInterface = ApiServices().getINSTANCE(context)
        return apiInterface!!.popularStar(q, sort, order)
    }
}
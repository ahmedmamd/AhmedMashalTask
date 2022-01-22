package com.example.task.data

import com.example.task.pojo.popularStare.PopularStare
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

open interface Apiinterface {

    @GET("search/repositories")
    fun  popularStar(@Query("q") q:String,
                     @Query("sort") sort:String,
                     @Query("order") order:String ): Observable<PopularStare>

}
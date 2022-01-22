package com.example.task.data

import android.content.Context
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class ApiServices {

    private val BASE_URL = "https://api.github.com/"

    //    private static String BASE_URL;
    private var apiInterface: Apiinterface? = null
    open fun getINSTANCE(context: Context?): Apiinterface? {
        val client = OkHttpClient.Builder()
            .build()
        if (apiInterface == null) {
            apiInterface = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build().create(Apiinterface::class.java)
            //apiInterface = retrofit.create(ApiInterface.class);
        }
        return apiInterface
    }
}
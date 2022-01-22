package com.example.task.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.task.base.BaseViewModel
import com.example.task.data.ApiServices
import com.example.task.data.Apiinterface
import com.example.task.pojo.popularStare.Items
import com.example.task.pojo.popularStare.PopularStare
import com.example.task.repository.HomeRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel : BaseViewModel() {
    var homeRepository: HomeRepository? = null
    var apiInterface: Apiinterface? = null

    var popularStarMutableLiveData: MutableLiveData<ArrayList<Items>?> = MutableLiveData<ArrayList<Items>?>()

    fun popularLiveData(): LiveData<ArrayList<Items>?>? {
        return popularStarMutableLiveData
    }
// get popular star
    fun getPopularStar(context: Context?) {
        apiInterface = ApiServices().getINSTANCE(context)
        homeRepository = HomeRepository(context)
        homeRepository!!.popular(context)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .unsubscribeOn(Schedulers.io())
            .subscribe(object : Observer<PopularStare?> {
                override fun onSubscribe(d: @NonNull Disposable?) {}
                override fun onNext(myResponse: @NonNull PopularStare?) {
                    popularStarMutableLiveData.setValue(myResponse?.items)
                }

                override fun onError(e: @NonNull Throwable?) {
                    Log.e("getPopularStare", "onError: " + e?.message)
                }
                override fun onComplete() {}
            })
    }
}
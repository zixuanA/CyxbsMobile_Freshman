package com.mredrock.cyxbs.freshman.data.Model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import android.provider.Settings
import com.mredrock.cyxbs.freshman.data.ViewModelCallback.*
import com.mredrock.cyxbs.freshman.data.bean.*
import com.mredrock.cyxbs.freshman.util.apiService
import retrofit2.Call
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream
import java.util.concurrent.Executors

class FreshmanModel<T : ViewModelCallback>(callback: T) {
    init {
        when {
            callback is NecessityViewModelCallback -> {
                apiService.getNecessityBean().enqueue(object : retrofit2.Callback<NecessityBean> {
                    override fun onFailure(call: Call<NecessityBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(call: Call<NecessityBean>, response: Response<NecessityBean>) {
                        if (response.code() == 200)
                            callback.onNecessityBeanReady(response.body())
                        else
                            callback.onFaire()
                    }
                })
            }



            callback is ProcessViewModelCallback -> {
                apiService.getProcessBean().enqueue(object : retrofit2.Callback<ProcessBean> {
                    override fun onFailure(call: Call<ProcessBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(call: Call<ProcessBean>, response: Response<ProcessBean>) {
                        if (response.code() == 200)
                            callback.onProcessBeanReady(response.body())
                        else
                            callback.onFaire()

                    }
                })
            }

            callback is OnlineCommunicationViewModelCallback -> {
                apiService.getOnlineActivitiesBean().enqueue(object : retrofit2.Callback<OnlineActivitiesBean> {
                    override fun onFailure(call: Call<OnlineActivitiesBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(
                        call: Call<OnlineActivitiesBean>,
                        response: Response<OnlineActivitiesBean>
                    ) {
                        if (response.code() == 200)
                            callback.onOnlineActivitiesBean(response.body())
                        else
                            callback.onFaire()

                    }
                })
                apiService.getGroupHometownBean().enqueue(object : retrofit2.Callback<GroupHomeBean> {
                    override fun onFailure(call: Call<GroupHomeBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(call: Call<GroupHomeBean>, response: Response<GroupHomeBean>) {
                        if (response.code() == 200)
                            callback.onOnlineHomeBean(response.body())
                        else
                            callback.onFaire()
                    }
                })
                apiService.getGroupStudentBean().enqueue(object : retrofit2.Callback<GroupStudentBean> {
                    override fun onFailure(call: Call<GroupStudentBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(call: Call<GroupStudentBean>, response: Response<GroupStudentBean>) {
                        if (response.code() == 200)
                            callback.onOnlineStudentBean(response.body())
                        else
                            callback.onFaire()
                    }
                })

            }

            callback is GuidedViewModelCallback -> {
                apiService.getGuideBusBean().enqueue(object : retrofit2.Callback<GuideBusBean> {
                    override fun onFailure(call: Call<GuideBusBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(call: Call<GuideBusBean>, response: Response<GuideBusBean>) {
                        if (response.code() == 200)
                            callback.onGuideBusBeanReady(response.body())
                        else
                            callback.onFaire()

                    }

                })
                apiService.getCampusSightseeingBean().enqueue(object : retrofit2.Callback<CampusSightseeingBean> {
                    override fun onFailure(call: Call<CampusSightseeingBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(
                        call: Call<CampusSightseeingBean>,
                        response: Response<CampusSightseeingBean>
                    ) {
                        if (response.code() == 200)
                            callback.onCampusSightseeingBeanReady(response.body())
                        else
                            callback.onFaire()

                    }
                })
            }

            callback is CampusGuideViewModelCallback -> {
                apiService.getCampusGuideBasicBean().enqueue(object : retrofit2.Callback<CampusGuideBasicBean> {
                    override fun onFailure(call: Call<CampusGuideBasicBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(
                        call: Call<CampusGuideBasicBean>,
                        response: Response<CampusGuideBasicBean>
                    ) {
                        if (response.code() == 200)
                            callback.onCampusGuideBasicBeanReady(response.body())
                        else
                            callback.onFaire()

                    }
                })
                apiService.getCampusGuideExpressDeliveryBean()
                    .enqueue(object : retrofit2.Callback<CampusGuideExpressDeliveryBean> {
                        override fun onFailure(call: Call<CampusGuideExpressDeliveryBean>, t: Throwable) {
                            callback.onFaire()
                        }

                        override fun onResponse(
                            call: Call<CampusGuideExpressDeliveryBean>,
                            response: Response<CampusGuideExpressDeliveryBean>
                        ) {
                            if (response.code() == 200)
                                callback.onCampusGuideExpressDeliveryBeanReady(response.body())
                            else
                                callback.onFaire()

                        }

                    })
                apiService.getCampusGuideSubjectBean().enqueue(object : retrofit2.Callback<CampusGuideSubjectBean> {
                    override fun onFailure(call: Call<CampusGuideSubjectBean>, t: Throwable) {
                        callback.onFaire()
                    }

                    override fun onResponse(
                        call: Call<CampusGuideSubjectBean>,
                        response: Response<CampusGuideSubjectBean>
                    ) {
                        if (response.code() == 200)
                            callback.ononCampusGuideSubjectBeanReady(response.body())
                        else
                            callback.onFaire()

                    }

                })

                apiService.getCampusGuideManAndWomanBean()
                    .enqueue(object : retrofit2.Callback<CampusGuideManAndWomanBean> {
                        override fun onFailure(call: Call<CampusGuideManAndWomanBean>, t: Throwable) {
                            callback.onFaire()
                        }

                        override fun onResponse(
                            call: Call<CampusGuideManAndWomanBean>,
                            response: Response<CampusGuideManAndWomanBean>
                        ) {
                            if (response.code() == 200)
                                callback.onCampusGuideManAndWomanBeanReady(response.body())
                            else
                                callback.onFaire()

                        }

                    })
            }
        }
    }
    fun saveBitmap(bitmap:Bitmap,name:String){
        val file = File(Environment.DIRECTORY_PICTURES,name)
        val outputStream = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream)
        outputStream.flush()
        outputStream.close()
    }

}
package com.dashingqi.base.application

import android.app.Application
import com.dashingqi.base.providers.application.IApplicationProvider
import com.orhanobut.logger.Logger

/**
 * @author : zhangqi
 * @time : 2020/5/20
 * desc :
 */
class BaseApplication : IApplicationProvider {
    override fun init(application: Application) {

    }

    override fun onCreate() {
        Logger.d("base-application-create")

    }

    override fun onLowMemory() {

    }

    override fun onTerminate() {

    }

    override fun getPriority(): Int {
        return 100
    }
}
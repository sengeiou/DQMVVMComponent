package com.dashingqi.mvvmcomponent

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.dashingqi.base.application.ApplicationController
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy


/**
 * @author : zhangqi
 * @time : 2020/5/16
 * desc :
 */
class AppApplication : Application() {

    init {
        //初始化打印
        initLog()
        ApplicationController.init(this, true)
    }

    override fun onCreate() {
        super.onCreate()
        ApplicationController.transformOnCreate()
        initARouter()

    }

    /**
     * 在模拟器上，在整个应用退出的时候会回调这个方法
     * 在真机上，整个应用退出的时候，是不会回调这个方法的。
     */
    override fun onTerminate() {
        super.onTerminate()
    }

    /**
     *当手机的内存存在紧张的时候，
     * 系统中进程的等级（前台--> 后台进程），通过AMS 给进程打个分，然后在linux中去做回收
     * 被回收的进程，在杀死的时候，会去回调这个方法
     */
    override fun onLowMemory() {
        ApplicationController.transformOnLowMemory()
        super.onLowMemory()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
    }

    /**
     * 初始化路由
     */
    private fun initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    /**
     * 初始化日志的打印
     */
    private fun initLog() {
        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .methodCount(0)
                .methodOffset(7)
                .tag("dq-m-v-v-m-component")
                .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }
}
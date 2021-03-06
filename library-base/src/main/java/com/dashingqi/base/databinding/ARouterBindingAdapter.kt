package com.dashingqi.base.databinding

import android.view.View
import androidx.databinding.BindingAdapter
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.Logger

/**
 * @author : zhangqi
 * @time : 2020/5/17
 * desc : 用于使用ARouter来自定义控件属性的类
 */
object ARouterBindingAdapter {

    /**
     * 使用ARouter进行跳转
     */
    @JvmStatic
    @BindingAdapter(value = ["arPath"], requireAll = true)
    fun arPath(view: View, arPath: String) {
        Logger.d("arPath onClick")
        view?.let {
            arPath?.let {
                view.setOnClickListener(AntiOnClickListener(View.OnClickListener {
                    ARouter.getInstance().build(arPath).navigation()
                }))
            }
        }
    }
}

package com.xiaojinzi.template

import android.app.Application
import android.content.Context
import com.xiaojinzi.component.Component
import com.xiaojinzi.component.Config
import com.xiaojinzi.module.base.support.DevelopHelper
import com.xiaojinzi.support.init.AppInstance
import com.xiaojinzi.support.ktx.LogSupport

class App: Application() {

    override fun attachBaseContext(baseContext: Context) {
        super.attachBaseContext(baseContext)
        val debug = BuildConfig.DEBUG
        AppInstance.app = this
        AppInstance.isDebug = debug
        LogSupport.logAble = debug
        DevelopHelper.init(debug)
    }

    override fun onCreate() {
        super.onCreate()

        Component.init(
            application = this,
            isDebug = true,
            config = Config
                .Builder()
                .optimizeInit(true)
                .autoRegisterModule(true)
                .build(),
        )

    }

}
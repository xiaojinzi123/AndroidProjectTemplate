package com.xiaojinzi.template

import android.app.Application
import com.xiaojinzi.component.Component
import com.xiaojinzi.component.Config

class App: Application() {

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
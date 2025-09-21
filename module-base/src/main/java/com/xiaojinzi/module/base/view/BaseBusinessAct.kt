package com.xiaojinzi.module.base.view

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.xiaojinzi.component.Component
import com.xiaojinzi.reactive.view.BaseViewModel

open class BaseBusinessAct<VM : BaseViewModel> : AppCompatActivity() {

    /*上下文*/
    protected lateinit var mContext: FragmentActivity

    protected var mViewModel: VM? = null

    protected open fun getViewModelClass(): Class<VM>? {
        return null
    }

    fun requiredViewModel(): VM {
        return mViewModel!!
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            window.isNavigationBarContrastEnforced = false
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.navigationBarColor = android.graphics.Color.TRANSPARENT
        }
        super.onCreate(savedInstanceState)
        mContext = this
        val viewModelClass = getViewModelClass()
        if (viewModelClass != null) {
            mViewModel = ViewModelProvider(this)[viewModelClass]
        }
        Component.inject(this)
    }

}
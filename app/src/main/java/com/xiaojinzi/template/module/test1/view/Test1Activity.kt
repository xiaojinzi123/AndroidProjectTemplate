package com.xiaojinzi.template.module.test1.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.xiaojinzi.component.anno.RouterAnno
import com.xiaojinzi.lib.res.ui.theme.AppTheme
import com.xiaojinzi.module.base.AppRouterConfig
import com.xiaojinzi.reactive.template.view.BusinessContentView
import com.xiaojinzi.support.ktx.nothing

@RouterAnno(
    hostAndPath = AppRouterConfig.APP_TEST1,
)
class Test1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                BusinessContentView<Test1ViewModel> { vm ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .statusBarsPadding(),
                    ) {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .nothing(),
                            onClick = {
                                vm.test()
                                // finishAndRemoveTask()
                            },
                        ) {
                            Text(
                                text = "Test1",
                            )
                        }
                    }
                }
            }
        }
    }
}
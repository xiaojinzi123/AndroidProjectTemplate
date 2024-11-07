package com.xiaojinzi.template.module.test1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.xiaojinzi.component.anno.RouterAnno
import com.xiaojinzi.module.base.AppRouterConfig
import com.xiaojinzi.template.ui.theme.ProjectTemplateTheme

@RouterAnno(
    hostAndPath = AppRouterConfig.APP_TEST1,
)
class Test1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectTemplateTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                ) {
                    Text(
                        text = "Test1",
                    )
                }
            }
        }
    }
}
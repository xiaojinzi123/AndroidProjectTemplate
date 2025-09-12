package com.xiaojinzi.template

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.xiaojinzi.component.impl.Router
import com.xiaojinzi.lib.res.ui.APP_PADDING_NORMAL
import com.xiaojinzi.lib.res.ui.AppHeightSpace
import com.xiaojinzi.lib.res.ui.theme.ProjectTemplateTheme
import com.xiaojinzi.module.base.AppRouterConfig
import com.xiaojinzi.support.ktx.nothing

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectTemplateTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                        .padding(horizontal = APP_PADDING_NORMAL.dp, vertical = 0.dp)
                        .nothing(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    AppHeightSpace()
                    AppHeightSpace()
                    AppHeightSpace()
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .nothing(),
                        onClick = {
                            Router
                                .with(context = this@MainActivity)
                                .hostAndPath(hostAndPath = AppRouterConfig.APP_TEST1)
                                .addIntentFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                .forward()
                        },
                    ) {
                        Text(
                            text = "点我"
                        )
                    }
                    AppHeightSpace()

                    val composition by rememberLottieComposition(
                        LottieCompositionSpec.RawRes(com.xiaojinzi.lib.res.R.raw.res_empty1)
                    )
                    LottieAnimation(
                        modifier = Modifier
                            .size(size = 120.dp)
                            .nothing(),
                        composition = composition,
                        iterations = LottieConstants.IterateForever,
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjectTemplateTheme {
        Greeting("Android")
    }
}
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.multiplatform.webview.request.RequestInterceptor
import com.multiplatform.webview.request.WebRequest
import com.multiplatform.webview.request.WebRequestInterceptResult
import com.multiplatform.webview.web.LoadingState
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.WebViewNavigator
import com.multiplatform.webview.web.rememberWebViewNavigator
import com.multiplatform.webview.web.rememberWebViewState
import com.multiplatform.webview.web.rememberWebViewStateWithHTMLFile
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import webview_kmpcompose.composeapp.generated.resources.Res
import webview_kmpcompose.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {

        // Mark: Library link
        // https://github.com/KevinnZou/compose-webview-multiplatform

        // Mark
//         Initial Load from web
        var webViewState = rememberWebViewState("https://google.com")

        // Initial Load From Local
//        var webViewState = rememberWebViewStateWithHTMLFile(
//            fileName = "index.html"
//        )


        val navigator = rememberWebViewNavigator()

        // Interceptor to handle custom request/event
//        val navigator = rememberWebViewNavigator(
//            requestInterceptor = object : RequestInterceptor {
//                override fun onInterceptUrlRequest(request: WebRequest, navigator: WebViewNavigator, ): WebRequestInterceptResult {
//                    return if (request.url.contains("search")) {
//                        WebRequestInterceptResult.Modify(
//                            WebRequest(
//                                url = "https://yahoo.com",
//                                headers = mutableMapOf("info" to "test"),
//                            ),
//                        )
//                    } else {
//                        WebRequestInterceptResult.Allow
//                    }
//                }
//            },
//        )

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Row {
                Button(onClick = {
                    navigator.loadUrl("https://touhidtech.com")
                }) {
                    Text(text = "My Site")
                }

                Spacer(Modifier.width(Dp(3F)))

                Button(onClick = {
                    navigator.loadHtmlFile("index.html")
                }) {
                    Text(text = "Local")
                }

                Spacer(Modifier.weight(1f))

                Button(onClick = {
                    if (navigator.canGoBack) {
                        navigator.navigateBack()
                    }
                }) {
                    Text(text = "Back")
                }

                Spacer(Modifier.width(Dp(3F)))

                Button(onClick = {
                    if (navigator.canGoForward) {
                        navigator.navigateForward()
                    }
                }) {
                    Text(text = "Forword")
                }
            }

            // Webpage data
            val text = webViewState.let {
                "State: ${it.loadingState}\nTitle: ${it.pageTitle ?: ""}\nURL: ${it.lastLoadedUrl ?: ""}"
            }
            Text(text = text, maxLines = 4, modifier = Modifier.fillMaxWidth())

            // Webpage loading progress
            val loadingState = webViewState.loadingState
            if (loadingState is LoadingState.Loading) {
                LinearProgressIndicator(
                    progress = loadingState.progress,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // WebView
            WebView(
                state = webViewState,
                navigator = navigator,
                modifier = Modifier.fillMaxSize()
            )

        }
    }
}
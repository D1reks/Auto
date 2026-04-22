package by.vladislav.test.presentation.ui.screens

import android.R.attr.onClick
import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import by.vladislav.test.presentation.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

val anyText = compositionLocalOf { "some Text" }

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CompositionLocalProvider( anyText provides "GetMeSomeTea"){
                MainScreen(mainViewModel)
            }
        }
    }
}

@SuppressLint("ContextCastToActivity")
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun MainScreen(viewModel: MainViewModel) {
    var someData by remember { mutableStateOf("Hello")}
    val windowSizeClass = calculateWindowSizeClass(activity = LocalContext.current as Activity)

    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> CompactSizeClass(changeStateValue = {someData = "new data"}, someData)
        WindowWidthSizeClass.Medium -> MediumSizeClass(viewModel)
    }
}

@Composable
fun MediumSizeClass(viewModel: MainViewModel){
    val textValue by viewModel.userData.collectAsStateWithLifecycle()
    val numberOfClicks by viewModel.screenTime.collectAsStateWithLifecycle()
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = textValue.toString())
        Text(text = numberOfClicks.toString())
    }
}

@Composable
fun CompactSizeClass(
    changeStateValue: () -> Unit,
    valueText: String
){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "мелкий экран")
        Text(text = valueText)
        ComposableButton(changeStateValue)
    }
}

@Composable
fun ComposableButton(
    changeStateValue: () -> Unit
){
    Button(
        onClick = changeStateValue,
        enabled = true
    ){
        Text(text = "изменить стейт текста")
    }
}
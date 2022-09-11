package vtsen.hashnode.dev.workmanagerdemo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import vtsen.hashnode.dev.workmanagerdemo.ui.screens.MainScreen
import vtsen.hashnode.dev.workmanagerdemo.ui.theme.NewEmptyComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewEmptyComposeAppTheme {
                MainScreen()
            }
        }
    }
}

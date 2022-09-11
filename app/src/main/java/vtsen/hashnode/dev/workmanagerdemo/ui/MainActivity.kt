package vtsen.hashnode.dev.workmanagerdemo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.work.WorkManager
import vtsen.hashnode.dev.workmanagerdemo.ui.screens.MainScreen
import vtsen.hashnode.dev.workmanagerdemo.ui.screens.MainViewModel
import vtsen.hashnode.dev.workmanagerdemo.ui.theme.NewEmptyComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewEmptyComposeAppTheme {
                val viewModel: MainViewModel = viewModel()
                viewModel.setWorkManager(WorkManager.getInstance(applicationContext))

                MainScreen()
            }
        }
    }
}

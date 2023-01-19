package vtsen.hashnode.dev.workmanagerdemo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(viewModel: MainViewModel) {

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Button(onClick = {
            viewModel.runOneTimeWorkRequest()
        }) {
            Text("One Time Work Request")
        }

        Button(onClick = {
            viewModel.runOneTimeExpeditedWorkRequest()
        }) {
            Text("One Time Expedite Work Request")
        }

        Button(onClick = {
            viewModel.runPeriodicWorkRequest()
        }) {
            Text("Periodic Work Request")
        }

        Button(onClick = {
            viewModel.runPeriodicWorkRequestInitialDelay()
        }) {
            Text("Periodic Work Request - Initial Delay")
        }


        Button(onClick = {
            viewModel.cancelWorker()
        }) {
            Text("Cancel Worker!")
        }
    }
}

package vtsen.hashnode.dev.workmanagerdemo.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import vtsen.hashnode.dev.workmanagerdemo.R
import vtsen.hashnode.dev.workmanagerdemo.ui.theme.NewEmptyComposeAppTheme

@Composable
fun MainScreen(viewModel: MainViewModel) {
    Text(text = stringResource(id = R.string.hello_android))
}

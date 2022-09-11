package vtsen.hashnode.dev.workmanagerdemo.ui.screens

import androidx.lifecycle.ViewModel
import androidx.work.WorkManager

class MainViewModel: ViewModel() {
    private lateinit var workManager: WorkManager

    fun setWorkManager(workManager: WorkManager) {
        this.workManager = workManager
    }


}
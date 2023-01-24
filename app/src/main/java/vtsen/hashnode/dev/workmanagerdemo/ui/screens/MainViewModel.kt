package vtsen.hashnode.dev.workmanagerdemo.ui.screens

import androidx.lifecycle.ViewModel
import androidx.work.*
import vtsen.hashnode.dev.workmanagerdemo.workers.DemoWorker
import java.util.concurrent.TimeUnit

class MainViewModel: ViewModel() {
    private lateinit var workManager: WorkManager
    private val constraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .build()
    private val workName = "DemoWorker"

    fun setWorkManager(workManager: WorkManager) {
        this.workManager = workManager
    }

    fun runOneTimeWorkRequest() {
        val workRequest = OneTimeWorkRequestBuilder<DemoWorker>()
            .setConstraints(constraints)
            .build()

        workManager.enqueueUniqueWork(
            workName,
            ExistingWorkPolicy.REPLACE,
            workRequest)
    }

    fun runOneTimeExpeditedWorkRequest() {
        val workRequest = OneTimeWorkRequestBuilder<DemoWorker>()
            .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
            .setConstraints(constraints)
            .build()

        workManager.enqueueUniqueWork(
            workName,
            ExistingWorkPolicy.REPLACE,
            workRequest)
    }

    fun runPeriodicWorkRequest() {

        //Note: repeatInterval must be >= MIN_PERIODIC_INTERVAL_MILLIS (15 minutes)
        val workRequest = PeriodicWorkRequestBuilder<DemoWorker>(
            repeatInterval = 15,
            TimeUnit.MINUTES
        )
            .build()

        workManager.enqueueUniquePeriodicWork(
            workName,
            ExistingPeriodicWorkPolicy.REPLACE,
            workRequest)

    }

    fun runPeriodicWorkRequestInitialDelay() {

        //Note: repeatInterval must be >= MIN_PERIODIC_INTERVAL_MILLIS (15 minutes)
        val workRequest = PeriodicWorkRequestBuilder<DemoWorker>(
            repeatInterval = 15,
            TimeUnit.MINUTES
        )
            .setInitialDelay(5, TimeUnit.SECONDS)
            .build()

        workManager.enqueueUniquePeriodicWork(
            workName,
            ExistingPeriodicWorkPolicy.REPLACE,
            workRequest)

    }

    fun cancelWorker() {
        workManager.cancelUniqueWork(workName)
    }
}
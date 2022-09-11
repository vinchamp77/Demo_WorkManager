package vtsen.hashnode.dev.workmanagerdemo.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class DemoWorker(appContext: Context, params: WorkerParameters)
    : CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {

        return Result.retry()
    }
}
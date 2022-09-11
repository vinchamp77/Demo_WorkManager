package vtsen.hashnode.dev.workmanagerdemo.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay

class DemoWorker(appContext: Context, params: WorkerParameters)
    : CoroutineWorker(appContext, params) {

    private var count = 0

    override suspend fun doWork(): Result {
        delay(5000)
        Log.d("DemoWorker", "do work done! - count:$count")
        ++count
        return Result.success()
    }
}
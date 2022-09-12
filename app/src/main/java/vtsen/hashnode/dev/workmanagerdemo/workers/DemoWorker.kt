package vtsen.hashnode.dev.workmanagerdemo.workers

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay
import vtsen.hashnode.dev.workmanagerdemo.R
import vtsen.hashnode.dev.workmanagerdemo.ui.MainActivity
import kotlin.properties.Delegates

//Note: a new worker is created everytime when it runs
class DemoWorker(appContext: Context, params: WorkerParameters)
    : CoroutineWorker(appContext, params) {

    private val notificationChannelId = "DemoNotificationChannelId"

    @RequiresApi(Build.VERSION_CODES.M)
    override suspend fun doWork(): Result {
        delay(5000)
        Log.d("DemoWorker", "do work done!")

        with(NotificationManagerCompat.from(applicationContext)) {
            notify(0, createNotification())
        }

        return Result.success()
    }

    // required only when .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
    override suspend fun getForegroundInfo(): ForegroundInfo {
        return ForegroundInfo(
            0, createNotification()
        )
    }

    private fun createNotification() : Notification {
        createNotificationChannel()

        val mainActivityIntent = Intent(applicationContext, MainActivity::class.java)

        var pendingIntentFlag by Delegates.notNull<Int>()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            pendingIntentFlag = PendingIntent.FLAG_IMMUTABLE
        } else {
            pendingIntentFlag = PendingIntent.FLAG_UPDATE_CURRENT
        }

        val mainActivityPendingIntent = PendingIntent.getActivity(
            applicationContext,
            0,
            mainActivityIntent,
            pendingIntentFlag)


        return NotificationCompat.Builder(applicationContext, notificationChannelId)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(applicationContext.getString(R.string.app_name))
            .setContentText("Work Request Done!")
            .setContentIntent(mainActivityPendingIntent)
            .setAutoCancel(true)
            .build()
    }

    private fun createNotificationChannel()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val notificationChannel = NotificationChannel(
                notificationChannelId,
                "DemoWorker",
                NotificationManager.IMPORTANCE_DEFAULT,
            )

            val notificationManager: NotificationManager? =
                getSystemService(applicationContext, NotificationManager::class.java)

            notificationManager?.createNotificationChannel(notificationChannel)
        }
    }
}
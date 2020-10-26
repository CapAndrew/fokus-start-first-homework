package app.com.fokus_start_first_homework.reminder_service

import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.widget.Toast
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

class ReminderService : Service() {

    private companion object {
        const val REQUEST_CODE = 111
        var count = 0
    }

    private val executorService = Executors.newSingleThreadScheduledExecutor()
    private lateinit var future: ScheduledFuture<*>

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val handler = Handler(Looper.getMainLooper())

        startReminding(handler)


        return START_STICKY
    }

    private fun startReminding(handler: Handler) {
        future = executorService.scheduleAtFixedRate({
            handler.post {
                count++
            }
        }, 0, 1, TimeUnit.SECONDS)
    }

    override fun onDestroy() {
        super.onDestroy()
        future.cancel(true)
        val notificationManager =
            getSystemService(Service.NOTIFICATION_SERVICE) as? NotificationManager
        notificationManager?.cancel(REQUEST_CODE)

        Toast.makeText(application, "Вы отсутствовали на экране секунд: $count", Toast.LENGTH_LONG)
            .show()
        count = 0
    }
}
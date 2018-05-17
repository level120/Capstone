package kr.ac.tu.capstone.capstone

import android.app.Notification.DEFAULT_SOUND
import android.app.Notification.DEFAULT_VIBRATE
import android.app.NotificationManager
import android.content.Context
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        if (remoteMessage!!.notification != null) {
            sendNotification(remoteMessage.notification!!.body!!)
        }
    }

    private fun sendNotification(messageBody: String) {
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("FCM Message")
                .setContentText(messageBody)
                .setSound(defaultSoundUri)
                .setVibrate(longArrayOf(100, 0, 100, 0))
                .setDefaults(DEFAULT_SOUND.or(DEFAULT_VIBRATE))


        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0, notificationBuilder.build())
    }
}
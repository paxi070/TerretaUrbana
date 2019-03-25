package com.example.terretaurbana.CloudMessaging;

import android.app.Notification;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.example.terretaurbana.R;
import static com.example.terretaurbana.MainActivity.notificacionChannelID;

public class NotificationHelper
{
    public static void displayNotification(Context context, String title, String body)
    {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, notificacionChannelID);
        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_fondo)
                .setContentTitle(title)
                .setContentText(body)
                .setContentInfo("Info")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(1, notificationBuilder.build());
    }
}

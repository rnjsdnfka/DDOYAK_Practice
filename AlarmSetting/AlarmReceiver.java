package com.example.caucse.ddoyak;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    Context context;
    PendingIntent pendingIntent2;
    NotificationHelper helper;

    public int count=0;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        helper = new NotificationHelper(context);

        //POWERMANAGER 미구현 - LOCK에서 VISIBILITY설정 있는데도 해야하나??
        //소리 or 진동 설정합시당.

        Log.d("ddoyak", "onReceive: alarm gogo");
        Toast.makeText(context, "복용시간 알림",Toast.LENGTH_SHORT).show();
        try{
            intent = new Intent(context, AlarmSetting.class);
            PendingIntent[] pendingIntent = new PendingIntent[100];
            pendingIntent[count+1] = PendingIntent.getActivity(context,count+1,intent, PendingIntent.FLAG_UPDATE_CURRENT);
            pendingIntent[count+1].send();
            count++;

            //pendingIntent2 = PendingIntent.getActivity(context, 121, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            //pendingIntent = PendingIntent.getActivity(context,111,intent, PendingIntent.FLAG_UPDATE_CURRENT);
            //pendingIntent2.send();

        }catch (PendingIntent.CanceledException e){
            e.printStackTrace();
            count++;
        }

        Notification.Builder builder = helper.getChannelNotification("복용 알림","약을 복용할 시간입니다:-)");
        helper.getManager().notify(1, builder.build());

    }
}
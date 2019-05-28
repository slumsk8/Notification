package com.slumdev.testenotificacao;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button send = findViewById(R.id.send);
        text = findViewById(R.id.text);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarNotificaao();
            }
        });
    }

    public void mostrarNotificaao(){
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        PendingIntent p = PendingIntent.getActivity(MainActivity.this, 0, new Intent(MainActivity.this, NotificationActivity.class), 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("My Notification")
                .setContentText(text.getText())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(p)
                .setAutoCancel(true);
        Notification n = builder.build();
        manager.notify(R.mipmap.ic_launcher, n);
    }
}

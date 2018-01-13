package com.hazin.ivan.taskmanager;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class TaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Устанавливает тему без тулбара
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_task);
        //Установка для работы токо в портрентой ориентацыи
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Вызов кнопок
        Button buttonCancel = findViewById(R.id.button_cancel_new_task_activity);
        Button buttonSave = findViewById(R.id.button_save_new_task_activity);
        //Вызов текстового поля
        final EditText Title = findViewById(R.id.Title);
        //Фокусирвание на плое
        Title.setFocusableInTouchMode(true);
        Title.requestFocus();
        //Открытие клавиатуры
        if(Title.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
        // Слушатель кнопки "Отмена"
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TaskActivity.this, MainActivity.class));
            }

        }
        );
        //Слушатель кнопки сохранить
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifity();
            }
        });

    }
    void notifity() {
        int mId = 55;

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notification)
                .setContentTitle("Hello")
                .setContentText("Hello World")
                .setAutoCancel(true);
        mBuilder.setDefaults(Notification.DEFAULT_SOUND);
        mBuilder.setDefaults(Notification.DEFAULT_VIBRATE);

        Intent resultIntent =new Intent(this, TaskActivity.class);
        TaskStackBuilder stackBuilder= TaskStackBuilder.create(this);
        stackBuilder.addParentStack(TaskActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntetnt =stackBuilder.getPendingIntent(
                0,
                PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntetnt);
        NotificationManager mNotifocationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifocationManager.notify(mId,mBuilder.build());
        }

    }

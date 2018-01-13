package com.hazin.ivan.taskmanager;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.audiofx.EnvironmentalReverb;
import android.os.Environment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by ivan on 10.12.17.
 * Данные сохранаются в базу данных MySql lite
 * Title Description Time
 */

public class Worker{
//    SQLiteOpenHelper helper = ;
    String workDir = "";
    String nameDB = "main";
    String tableName = "Tasks";
    void CreateDB(){}
    void OpenDB(){}
    void ReadDB(){}
    void newWrtieDB(){}
    void WrtiteDB(){}
    void deleteRowOnDB(){}
    void CloseDB(){}


}

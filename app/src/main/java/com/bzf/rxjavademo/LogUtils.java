package com.bzf.rxjavademo;

import android.util.Log;

public class LogUtils {

    private static String TAG = "bzf";

    public static void printI(String message){
        Log.i(TAG,message);
    }

    public static void printD(String message){
        Log.d(TAG,message);
    }

    public static void printJava(String message){
        System.out.println(message);
    }
}

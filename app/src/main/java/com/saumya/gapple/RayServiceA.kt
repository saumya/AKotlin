package com.saumya.gapple

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class RayServiceA : Service() {

    val TAG = "RayServiceA"

    init {
        Log.d(TAG,"Service is running ...")
    }

    /*
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
    */
    override fun onBind(intent: Intent?): IBinder? {
        //TODO("Not yet implemented")
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val sData = intent?.getStringExtra("S_DATA")
        sData?.let {
            Log.d(TAG,sData)
        }

        // Starting a Thread
        Thread{
            while (true){
                Log.d(TAG,"In while ...")
            }
        }


        //return super.onStartCommand(intent, flags, startId)
        //return START_NOT_STICKY
        return START_STICKY
        //return START_REDELIVER_INTENT
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"Service is being Killed ...")
    }
}
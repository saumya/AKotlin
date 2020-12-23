package com.saumya.gapple

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class RayServiceA : Service() {

    val TAG = "RayServiceA"
    var isRunning = false

    init {
        Log.d(TAG,"init : Service is running ...")
    }

    /*
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
    */
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        isRunning = true
        val sData = intent?.getStringExtra("S_DATA")
        sData?.let {
            Log.d(TAG,sData)
        }

        // Starting a Thread
        Thread{

            while (isRunning){
                Log.d(TAG,"In while")
                val tStop = Toast.makeText(applicationContext,"... THREAD WHILE ...", Toast.LENGTH_SHORT)
                tStop.show()
                Thread.sleep(5000)
            }

        }


        //return super.onStartCommand(intent, flags, startId)

        //return START_NOT_STICKY
        //return START_STICKY
        //return START_REDELIVER_INTENT

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"Service is being Killed ...")
        /*
        // can not update UI from another Thread
        val tStop = Toast.makeText(applicationContext,"Service dying ...", Toast.LENGTH_LONG)
        tStop.show()
        */
        isRunning = false
    }

}
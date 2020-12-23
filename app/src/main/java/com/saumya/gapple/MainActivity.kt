package com.saumya.gapple

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val TAG = "Ray"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initThisView()
    }

    fun initThisView(){
        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnStop = findViewById<Button>(R.id.btnStop)
        val btnSendData = findViewById<Button>(R.id.btnSendData)

        btnStart.setOnClickListener {
            Toast.makeText(applicationContext,"Start Click", Toast.LENGTH_SHORT).show()
            
            Log.d(TAG,"Click : Start")

            Intent(this,RayServiceA::class.java).also {
                startService(it)
            }
        }

        btnStop.setOnClickListener {
            Toast.makeText(applicationContext,"Stop Click", Toast.LENGTH_SHORT).show()

            Log.d(TAG,"Click : Stop")

            Intent(this,RayServiceA::class.java).also {
                stopService(it)
            }
        }

        btnSendData.setOnClickListener {
            Intent(this,RayServiceA::class.java).also {
                val sDataString = "Sent From MainActivity"
                it.putExtra("S_DATA",sDataString)
                startService(it)
            }
        }
    }

}
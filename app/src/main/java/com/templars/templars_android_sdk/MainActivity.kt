package com.templars.templars_android_sdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.templars.templars.Templars

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val templars = Templars("sk-28d8355f89744fdcbe3ca487e568061f")
        templars.getDocuments {
            it.first?.let { res ->
                Log.d(TAG, res.data.first().name)
            }
        }

        templars.getDocument("093a1a63-cf0e-461d-b238-c7dd749d0c63"){
            it.first?.let { res ->
                Log.d(TAG, res.data.name)
            }
            it.second?.let { err ->
                Log.d(TAG, err.message!!)
            }
        }

        templars.getSessions {
            it.first?.let { res ->
                Log.d(TAG, res.data.first().id)
            }
            it.second?.let { err ->
                Log.d(TAG, err.message!!)
            }
        }

        templars.getSession("0d257a09-96ec-4bd0-addc-c03108eaf000"){
            it.first?.let { res ->
                Log.d(TAG, res.data.title)
            }
            it.second?.let { err ->
                Log.d(TAG, err.message!!)
            }
        }

        templars.getRegistrations {
            it.first?.let { res ->
                Log.d(TAG, "Registration: ${res.data.first().id}")
            }
            it.second?.let { err ->
                Log.d(TAG, "Reg: ${err.message!!}")
            }
        }

        templars.getRegistration("bf33e29c-2f9a-47c4-b031-78a70e18bf3e"){
            it.first?.let { res ->
                Log.d(TAG, "Reg: ${res.data.fields}")
            }
            it.second?.let { err ->
                Log.d(TAG, "Reg: ${err.message!!}")
            }
        }

    }

    companion object{

        const val TAG = "MainActivity"

    }
}
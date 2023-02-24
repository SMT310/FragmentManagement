package com.example.fragmentmanagement

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        Log.e("Life Cycle","My own on Create");

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, firstFragment)
            commit()
        }
        findViewById<Button>(R.id.btnFragment1).setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, firstFragment)
                addToBackStack(null)
                commit()
            }
        }
        findViewById<Button>(R.id.btnFragment2).setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, secondFragment)
                addToBackStack(null)
                commit()
            }
        }
    }

    override fun onStart() {
        super.onStart();
        Log.e("Life Cycle", "My own on Start");
    }

    override fun onResume() {
        super.onResume();
        Log.e("Life Cycle", "My own on Resume")
    }
}
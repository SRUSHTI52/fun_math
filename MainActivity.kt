package com.example.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import javax.microedition.khronos.egl.EGL10

class MainActivity : AppCompatActivity() {

    lateinit var button1 : Button
    lateinit var button2 : Button
    lateinit var button3 : Button
    lateinit var button4 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)

        button1.setOnClickListener {
            val intent = Intent(this@MainActivity, Logic_Add::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this@MainActivity, Logic_Sub::class.java)
            startActivity(intent)
        }

        button3.setOnClickListener {
            val intent = Intent(this@MainActivity, Logic_Mul::class.java)
            startActivity(intent)
        }

        button4.setOnClickListener {
            val intent = Intent(this@MainActivity, Logic_Div::class.java)
            startActivity(intent)
        }


    }
}

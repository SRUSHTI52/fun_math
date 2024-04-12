package com.example.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Locale
import kotlin.random.Random

class Logic_Mul : AppCompatActivity() {

    lateinit var textscore1: TextView
    lateinit var textscore2: TextView
    lateinit var textlife1: TextView
    lateinit var textlife2: TextView
    lateinit var texttime1: TextView
    lateinit var texttime2: TextView
    lateinit var textque: TextView
    lateinit var textans: EditText
    lateinit var done: Button
    lateinit var next: Button
    lateinit var home : Button
    lateinit var quit : Button
    var ans = 0
    var score = 0
    var life = 3
    lateinit var timer: CountDownTimer
    private val starttime: Long = 60000
    var timeinmil: Long = starttime


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        textscore1 = findViewById(R.id.textscore1)
        textscore2 = findViewById(R.id.textscore2)
        textlife1 = findViewById(R.id.textLife1)
        textlife2 = findViewById(R.id.textLife2)
        texttime1 = findViewById(R.id.texttime1)
        texttime2 = findViewById(R.id.texttime2)
        textque = findViewById(R.id.textque)
        textans = findViewById(R.id.textans)
        done = findViewById(R.id.done)
        next = findViewById(R.id.next)
        home = findViewById(R.id.home)
        quit = findViewById(R.id.quit)
        start()
        done.setOnClickListener {
            val input = textans.text.toString()
            if (input=="")
            {
                Toast.makeText(applicationContext,"Enter answer",Toast.LENGTH_SHORT).show()
            }
            else
            {
                timepause()
                val user_ans : Int
                try{ user_ans = input.toInt()
                    if (user_ans==ans)
                    {
                        score= score+10
                        textque.text = "correct!"
                        textscore2.text = score.toString()
                    }
                    else
                    {
                        life--
                        textque.text = "incorrect!"
                        textlife2.text = life.toString()

                    }}
                catch (e:Exception)
                { Toast.makeText(applicationContext,"Enter valid answer",Toast.LENGTH_SHORT).show()}

            }

        }


        next.setOnClickListener {
            timepause()
            timereset()
            start()
            textans.setText("")

        }

        home.setOnClickListener {
            val intent = Intent(this@Logic_Mul, MainActivity::class.java)
            startActivity(intent)
           // finish()
        }

        quit.setOnClickListener {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }

    fun start() {
        val n1 = Random.nextInt(0, 10)
        val n2 = Random.nextInt(0, 10)
        textque.text = "$n1 * $n2"
        ans = n1 + n2
        timecounter()
    }

    fun timecounter() {
        timer = object : CountDownTimer(timeinmil, 1000) {

            override fun onTick(timefin: Long) {
                timeinmil = timefin
                change_time()
            }

            override fun onFinish() {
                timepause()
                timereset()
                change_time()

                life--
                textlife2.text = life.toString()
                textque.text = "TIME'S UP"
            }


        }.start()
    }


    fun change_time() {
        val timerem: Int = (timeinmil / 1000).toInt()
        texttime2.text = String.format(Locale.getDefault(), "%02d", timerem)
    }

    fun timepause() {
        timer.cancel()
    }

    fun timereset() {
        timeinmil = starttime
        change_time()
    }
}

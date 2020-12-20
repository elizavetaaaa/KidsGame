package com.example.quiz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameLevels : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gamelevels)
        val save = getSharedPreferences("Save", Context.MODE_PRIVATE)
        val level = save.getInt("Level", 1)
        val w = window
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val button_back = findViewById<View>(R.id.button_back) as Button
        button_back.setOnClickListener {
            try {
                val intent = Intent(this@GameLevels, MainActivity::class.java)
                startActivity(intent)
                finish()
            } catch (e: Exception) {
            }
        }

        //кнопка для перехода на первый уровень
        val textView1 = findViewById<View>(R.id.textView1) as TextView
        textView1.setOnClickListener {
            try {
                if (level >= 1) {
                    val intent = Intent(this@GameLevels, Level1::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    //пусто
                }
            } catch (e: Exception) {
            }
        }


        //кнопка для перехода на 2 уровень
        val textView2 = findViewById<View>(R.id.textView2) as TextView
        textView2.setOnClickListener {
            try {
                if (level >= 2) {
                    val intent = Intent(this@GameLevels, Level2::class.java)
                    startActivity(intent)
                    finish()
                } else {
                }
            } catch (e: Exception) {
            }
        }


        //кнопка для перехода на 3 уровень
        val textView3 = findViewById<View>(R.id.textView3) as TextView
        textView3.setOnClickListener {
            try {
                if (level >= 3) {
                    val intent = Intent(this@GameLevels, Level3::class.java)
                    startActivity(intent)
                    finish()
                } else {
                }
            } catch (e: Exception) {
            }
        }

        //кнопка для перехода на 4 уровень
        val textView4 = findViewById<View>(R.id.textView4) as TextView
        textView4.setOnClickListener {
            try {
                if (level >= 4) {
                    val intent = Intent(this@GameLevels, Level4::class.java)
                    startActivity(intent)
                    finish()
                } else {
                }
            } catch (e: Exception) {
            }
        }


        //кнопка для перехода на 5 уровень
        val textView5 = findViewById<View>(R.id.textView5) as TextView
        textView5.setOnClickListener {
            try {
                if (level >= 5) {
                    val intent = Intent(this@GameLevels, Level5::class.java)
                    startActivity(intent)
                    finish()
                } else {
                }
            } catch (e: Exception) {
            }
        }

        //кнопка для перехода на 6 уровень
        val textView6 = findViewById<View>(R.id.textView6) as TextView
        textView6.setOnClickListener {
            try {
                if (level >= 6) {
                    val intent = Intent(this@GameLevels, Level6::class.java)
                    startActivity(intent)
                    finish()
                } else {
                }
            } catch (e: Exception) {
            }
        }

        //кнопка для перехода на 7 уровень
        val textView7 = findViewById<View>(R.id.textView7) as TextView
        textView7.setOnClickListener {
            try {
                if (level >= 7) {
                    val intent = Intent(this@GameLevels, Level7::class.java)
                    startActivity(intent)
                    finish()
                } else {
                }
            } catch (e: Exception) {
            }
        }


        //кнопка для перехода на 8 уровень
        val textView8 = findViewById<View>(R.id.textView8) as TextView
        textView8.setOnClickListener {
            try {
                if (level >= 8) {
                    val intent = Intent(this@GameLevels, Level8::class.java)
                    startActivity(intent)
                    finish()
                } else {
                }
            } catch (e: Exception) {
            }
        }

        //кнопка для перехода на 9 уровень
        val textView9 = findViewById<View>(R.id.textView9) as TextView
        textView9.setOnClickListener {
            try {
                if (level >= 9) {
                    val intent = Intent(this@GameLevels, Level9::class.java)
                    startActivity(intent)
                    finish()
                }
            } catch (e: Exception) {
            }
        }


        //кнопка для перехода на 10 уровень
        val textView10 = findViewById<View>(R.id.textView10) as TextView
        textView10.setOnClickListener {
            try {
                if (level >= 10) {
                    val intent = Intent(this@GameLevels, Level10::class.java)
                    startActivity(intent)
                    finish()
                } else {
                }
            } catch (e: Exception) {
            }
        }
        val x = intArrayOf(
                R.id.textView1,
                R.id.textView2,
                R.id.textView3,
                R.id.textView4,
                R.id.textView5,
                R.id.textView6,
                R.id.textView7,
                R.id.textView8,
                R.id.textView9,
                R.id.textView10)
        for (i in 1 until level) {
            val tv = findViewById<TextView>(x[i])
            tv.text = "" + (i + 1)
        }
    }

    //кнопка телефона пр нажатии назад
    override fun onBackPressed() {
        try {
            val intent = Intent(this@GameLevels, MainActivity::class.java)
            startActivity(intent)
            finish()
        } catch (e: Exception) {
        }
    }
}
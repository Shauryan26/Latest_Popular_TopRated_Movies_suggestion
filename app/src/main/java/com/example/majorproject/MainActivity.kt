package com.example.majorproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.ui.graphics.Color
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val popfrag = PopularMovie()
        val topfrag = TopRatedMovie()
        val latfrag= LatestMovie()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, popfrag)
            commit()
        }

        button.setOnClickListener {
            button.setBackgroundColor(getResources().getColor(R.color.black))
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, popfrag)
                addToBackStack(null)
                commit()
            }
        }
        button2.setOnClickListener {
            button2.setBackgroundColor(getResources().getColor(R.color.black))
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, topfrag)
                addToBackStack(null)
                commit()
            }
        }
        button2.setOnClickListener {
            button2.setBackgroundColor(getResources().getColor(R.color.black))
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, topfrag)
                addToBackStack(null)
                commit()
            }
        }
        button3.setOnClickListener {
            button3.setBackgroundColor(getResources().getColor(R.color.black))
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, latfrag)
                addToBackStack(null)
                commit()
            }
        }
    }

}
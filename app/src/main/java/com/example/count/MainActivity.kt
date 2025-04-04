package com.example.count

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var num = 0
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var add = findViewById<FloatingActionButton>(R.id.add)
        var minus = findViewById<FloatingActionButton>(R.id.minus)
        var text = findViewById<TextView>(R.id.text)

        add.setOnClickListener{
            num += 1
            updateText(num, text)
        }
        minus.setOnClickListener {
            if (num > 0) {
                num -= 1
                updateText(num, text)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun updateText(num:Int, text:TextView) {
        text.setText(""+num)
    }
}
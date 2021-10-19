package me.mehdi.groupanimation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class CustomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_draw)
        val custom:CurveBackgroudView = findViewById(R.id.custom_layout)

        custom.setOnClickListener {
            custom.changeLine()
        }
    }
}
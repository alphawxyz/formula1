package com.example.formula1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text


@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val selectedDriver = intent.getParcelableExtra<Driver>("key_driver") as Driver

        val tvName: TextView = findViewById(R.id.tv_name_detail)
        val tvDescription: TextView = findViewById(R.id.tv_description_detail)
        val imgDriver: ImageView = findViewById(R.id.img_driver_detail)
        val tvTeam: TextView = findViewById(R.id.tv_team_detail)

        tvName.text = selectedDriver.name
        tvDescription.text = selectedDriver.description
        imgDriver.setImageResource(selectedDriver?.photo ?: R.drawable.ic_launcher_foreground)
        tvTeam.text = selectedDriver.team


    }
}
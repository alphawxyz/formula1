package com.example.formula1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvF1driver: RecyclerView
    private val list = ArrayList<Driver>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvF1driver = findViewById(R.id.rv_f1drivers)
        rvF1driver.setHasFixedSize(true)

        list.addAll(getListDrivers())
        showRecyclerLIst()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_list -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    @SuppressLint("Recycle")
    private fun getListDrivers(): ArrayList<Driver> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataTeam = resources.getStringArray(R.array.data_team)

        val listDriver = ArrayList<Driver>()
        for (i in dataName.indices) {
            val driver = Driver(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataTeam[i])
            listDriver.add(driver)
        }
        return listDriver
    }

    private fun showRecyclerLIst(){
        rvF1driver.layoutManager = LinearLayoutManager(this)
        val listDriverAdapter = ListDriverAdapter(list)
        rvF1driver.adapter = listDriverAdapter

        supportActionBar?.title = "Formula One 2023 Driver"
    }

}
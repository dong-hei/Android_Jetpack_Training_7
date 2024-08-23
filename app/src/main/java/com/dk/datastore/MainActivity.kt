package com.dk.datastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

/**
 * preferecesDatastore와 비교해서 UI 스레드에서 호출하기에 안정적이다.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var vm : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this).get(MainViewModel::class.java)

        val sv1 = findViewById<Button>(R.id.sv1)
        sv1.setOnClickListener {

            val editTxt = findViewById<EditText>(R.id.editTxt1)
            val insertTxt = editTxt.text.toString()

            vm.insert(insertTxt)
        }

        val read1 = findViewById<Button>(R.id.read1)
        read1.setOnClickListener {
            val readTxt = findViewById<TextView>(R.id.readTxt1)

                vm.read.observe(this, Observer {
                    readTxt.text = it.toString()
                })
        }
    }
}
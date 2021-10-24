package com.example.notesappsaveandretrieve

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var editText:EditText
    lateinit var button: Button
    lateinit var dbhlr :DBHlr
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         editText = findViewById<EditText>(R.id.editText)
        button = findViewById<Button>(R.id.button)

        dbhlr = DBHlr(this)
        show()

        button.setOnClickListener {
            if (!editText.text.isEmpty()) {
                save()
                show()
            } else {
                Toast.makeText(this, "The text is empty", Toast.LENGTH_SHORT).show()
            }
            editText.text.clear()
        }
    }

        fun show(){
            var list = dbhlr.retrive()
            //recycler view
            val myRv = findViewById<RecyclerView>(R.id.recyclerView)
            myRv.adapter = RecyclerViewAdapter(list)
            myRv.layoutManager = LinearLayoutManager(this)
        }

        fun save(){
            var note = editText.text.toString()
            dbhlr.savedata(note)
            Toast.makeText(this, "Save successfully", Toast.LENGTH_SHORT).show()
        }
    }
    //var str = dbhlr.retrive(note)
    // notes.add(str)
    //val notes = arrayListOf<String>()
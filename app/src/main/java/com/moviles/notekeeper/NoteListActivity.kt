package com.moviles.notekeeper

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_note_list.*


class NoteListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        fab.setOnClickListener{
            view -> val activiyIntent = Intent(this,MainActivity::class.java)
            startActivity(activiyIntent)
        }

        listNotes.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,DataManager.notes)
        listNotes.setOnItemClickListener{
            parent,view,position,id ->
            //Using intent
            val activityIntent = Intent(this,MainActivity::class.java)
            //Sending data for a new activity
            activityIntent.putExtra(EXTRA_NOTE_POSITION,position)
            startActivity(activityIntent)
        }
    }
}
package com.moviles.notekeeper

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var notePosition = POSITION_NOT_SET

        @RequiresApi(Build.VERSION_CODES.N)
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapterCourses = ArrayAdapter<CourseInfo>(this,
        android.R.layout.simple_spinner_item,
        DataManager.courses.values.toList())
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerNoteCourses.adapter = adapterCourses

        notePosition = intent.getIntExtra(EXTRA_NOTE_POSITION, POSITION_NOT_SET)

            if(notePosition != POSITION_NOT_SET) displayNote()


    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun displayNote() {
        val note = DataManager.notes(notePosition)
        textNoteTitle.setText(note.title)
        textNoteText.setText(note.text)
        val coursePosition = DataManager.courses.values.indexOf(note.course)
        spinnerNoteCourses.setSelection(coursePosition)
    }
}


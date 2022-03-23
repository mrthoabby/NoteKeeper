package com.moviles.notekeeper

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.indexOf as indexOf1

class MainActivity : AppCompatActivity() {
    private var notePosition = POSITION_NOT_SET

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapterCourses = ArrayAdapter(this,
        android.R.layout.simple_spinner_item,
        DataManager.courses.values.toList())
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerNoteCourses.adapter = adapterCourses

        notePosition = savedInstanceState?.getInt(NOTE_POSITION, POSITION_NOT_SET) ?: intent.getIntExtra(NOTE_POSITION, POSITION_NOT_SET)

            if(notePosition != POSITION_NOT_SET) displayNote()
            else{
                DataManager.notes.add(NoteInfo())
                notePosition = DataManager.notes.lastIndex
            }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(NOTE_POSITION,notePosition)
    }

    override fun onPause(){
        super.onPause()
        saveNote()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if(notePosition >= DataManager.notes.lastIndex){
            val menuItem = menu?.findItem(R.id.action_Next)
            if(menuItem != null){
            menuItem.icon = getDrawable(R.drawable.ic_baseline_not_interested_24)
                menuItem.isEnabled = false
            }
        }
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_settings  -> true
            R.id.action_Next ->{
                moveNext()
                true
            }
            else ->  return super.onOptionsItemSelected(item)
        }
    }

    private fun moveNext() {
        ++notePosition
        displayNote()
        invalidateOptionsMenu()
    }

    private fun saveNote() {
        val note = DataManager.notes[notePosition]
        note.text = textNoteText.text.toString()
        note.title = textNoteTitle.text.toString()
        note.course = spinnerNoteCourses.selectedItem as CourseInfo
    }
    private fun displayNote() {
        val note = DataManager.notes(notePosition)
        textNoteTitle.setText(note.title)
        textNoteText.setText(note.text)
        val coursePosition = DataManager.courses.values.indexOf1(note.course)
        spinnerNoteCourses.setSelection(coursePosition)
    }
}


package com.moviles.notekeeper

import android.os.Build
import android.support.annotation.RequiresApi

const val androidDevelop = "desarrollo_movil"
const val kotlinDevelop = "kotlin_languaje"
const val javaDevelop = "java_languaje"
const val webDevelop = "web_development"
val defaultCourseInfo = CourseInfo("Empty","Developet")
@RequiresApi(Build.VERSION_CODES.N)
object DataManager {
    val courses = HashMap<String,CourseInfo>()
    val notes = ArrayList<NoteInfo>()
    init {
        initializeCourses()
        initializeNotes()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun initializeNotes() {
        var note = NoteInfo(courses.getOrDefault(kotlinDevelop, defaultCourseInfo) ,kotlinDevelop,"A android app can be create with the kotlin languaje")
        notes.add(note)
        note = NoteInfo(courses.getOrDefault(kotlinDevelop, defaultCourseInfo) ,kotlinDevelop,"The kotlin languaje sitax is different to java languaje")
        notes.add(note)
        note = NoteInfo(courses.getOrDefault(androidDevelop, defaultCourseInfo) ,androidDevelop,"The Android apps is better to creat with android studio ide")
        notes.add(note)
        note = NoteInfo(courses.getOrDefault(javaDevelop, defaultCourseInfo) ,androidDevelop,"The Android apps can be create with the java languaje")
        notes.add(note)
        note = NoteInfo(courses.getOrDefault(webDevelop, defaultCourseInfo) ,webDevelop,"A web developer need to underestand the networks and the internet")
        notes.add(note)
        note = NoteInfo(courses.getOrDefault(webDevelop, defaultCourseInfo) ,webDevelop,"Javascript is a languaje tha a web development need to learn")
        notes.add(note)
        note = NoteInfo(courses.getOrDefault(kotlinDevelop, defaultCourseInfo) ,kotlinDevelop,"Kotlin is a languaje confused")
        notes.add(note)

    }

    private fun initializeCourses() {
        var course = CourseInfo(androidDevelop,"Desarrollo de aplicaciones moviles con Android")
        courses.set(course.courseId,course)
        course = CourseInfo(kotlinDevelop,"Desarrollando aplicaciones Android nativas con Kotlin")
        courses.set(course.courseId,course)
        course = CourseInfo(javaDevelop,"Desarrollando aplicaciones Android nativas con Java")
        courses.set(course.courseId,course)
        course = CourseInfo(webDevelop,"Desarrollo Web")
        courses.set(course.courseId,course)
    }

    fun notes(notePosition: Int): NoteInfo {
            return  notes[notePosition]
    }
}
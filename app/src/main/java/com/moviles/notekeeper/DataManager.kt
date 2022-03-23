package com.moviles.notekeeper

import android.os.Build
import android.support.annotation.RequiresApi


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
        var note = NoteInfo(courses.getOrDefault(KOTLIN_DEVELOP_COURSE, DEFAULT_VALUE_COURSEINFO) ,KOTLIN_DEVELOP_COURSE,"A android app can be create with the kotlin languaje")
        notes.add(note)
        note = NoteInfo(courses.getOrDefault(KOTLIN_DEVELOP_COURSE, DEFAULT_VALUE_COURSEINFO) ,KOTLIN_DEVELOP_COURSE,"The kotlin languaje sitax is different to java languaje")
        notes.add(note)
        note = NoteInfo(courses.getOrDefault(ANDROID_DEVELOP_COURSE, DEFAULT_VALUE_COURSEINFO) ,ANDROID_DEVELOP_COURSE,"The Android apps is better to creat with android studio ide")
        notes.add(note)
        note = NoteInfo(courses.getOrDefault(JAVA_DEVELOP_COURSE, DEFAULT_VALUE_COURSEINFO) ,ANDROID_DEVELOP_COURSE,"The Android apps can be create with the java languaje")
        notes.add(note)
        note = NoteInfo(courses.getOrDefault(WEB_DEVELOP_COURSE, DEFAULT_VALUE_COURSEINFO) ,WEB_DEVELOP_COURSE,"A web developer need to underestand the networks and the internet")
        notes.add(note)
        note = NoteInfo(courses.getOrDefault(WEB_DEVELOP_COURSE, DEFAULT_VALUE_COURSEINFO) ,WEB_DEVELOP_COURSE,"Javascript is a languaje tha a web development need to learn")
        notes.add(note)
        note = NoteInfo(courses.getOrDefault(KOTLIN_DEVELOP_COURSE, DEFAULT_VALUE_COURSEINFO) ,KOTLIN_DEVELOP_COURSE,"Kotlin is a languaje confused")
        notes.add(note)

    }

    private fun initializeCourses() {
        var course = CourseInfo(ANDROID_DEVELOP_COURSE,"Desarrollo de aplicaciones moviles con Android")
        courses.set(course.courseId,course)
        course = CourseInfo(KOTLIN_DEVELOP_COURSE,"Desarrollando aplicaciones Android nativas con Kotlin")
        courses.set(course.courseId,course)
        course = CourseInfo(JAVA_DEVELOP_COURSE,"Desarrollando aplicaciones Android nativas con Java")
        courses.set(course.courseId,course)
        course = CourseInfo(WEB_DEVELOP_COURSE,"Desarrollo Web")
        courses.set(course.courseId,course)
    }

    fun notes(notePosition: Int): NoteInfo {
            return  notes[notePosition]
    }
}
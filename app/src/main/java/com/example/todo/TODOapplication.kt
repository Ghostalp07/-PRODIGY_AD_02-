package com.example.todo

import android.app.Application

class TODOapplication: Application() {
    override fun onCreate() {
        super.onCreate()
    Graph.provide(this)
    }
}
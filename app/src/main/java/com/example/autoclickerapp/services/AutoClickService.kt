package com.example.autoclickerapp.services

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.view.accessibility.AccessibilityEvent
import android.widget.Toast
import timber.log.Timber

class AutoClickService: AccessibilityService() {









    override fun onServiceConnected() {
        super.onServiceConnected()
        Timber.e("Service Connected!!!")
    }
    override fun onUnbind(intent: Intent?): Boolean {
        Timber.e("Unbind!!!!")
        return super.onUnbind(intent)
    }
    override fun onAccessibilityEvent(p0: AccessibilityEvent?) {
        Timber.e("Accessibility Event!!")
    }
    override fun onInterrupt() {
        Timber.e("Interrupt")
    }
}
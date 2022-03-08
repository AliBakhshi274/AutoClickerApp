package com.example.autoclickerapp.services

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.view.accessibility.AccessibilityEvent
import com.example.autoclickerapp.utils.Constants
import timber.log.Timber

class AutoClickService : AccessibilityService() {






    // TurnOn Accessibility Service
    override fun onServiceConnected() {
        super.onServiceConnected()
        Timber.e("Timber: Service Connected!!!")
    }
    // TurnOff Accessibility Service
    override fun onUnbind(intent: Intent?): Boolean {
        Timber.e("Timber: Unbind!!!!")
        return super.onUnbind(intent)
    }
    // Execute this method with per touch or click on screen
    override fun onAccessibilityEvent(p0: AccessibilityEvent?) {
        Timber.e("Timber: Accessibility Event!!")
    }
    override fun onInterrupt() {
        Timber.e("Timber: Interrupt")
    }


    override fun onDestroy() {
        super.onDestroy()
    }

}

































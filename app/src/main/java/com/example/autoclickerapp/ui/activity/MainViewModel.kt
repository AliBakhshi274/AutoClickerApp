package com.example.autoclickerapp.ui.activity

import android.app.Application
import android.content.ComponentName
import android.content.Context
import android.os.Build
import android.provider.Settings
import android.text.TextUtils
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import com.example.autoclickerapp.services.AutoClickService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {


    fun isAccessibilityServiceEnabled(
        context: Context,
        accessibilityService: Class<*>?
    ): Boolean {
        val expectedComponentName = ComponentName(context, accessibilityService!!)
        val enabledServicesSetting =
            Settings.Secure.getString(
                context.contentResolver,
                Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES
            )
                ?: return false
        val colonSplitter = TextUtils.SimpleStringSplitter(':')
        colonSplitter.setString(enabledServicesSetting)
        while (colonSplitter.hasNext()) {
            val componentNameString = colonSplitter.next()
            val enabledService = ComponentName.unflattenFromString(componentNameString)
            if (enabledService != null && enabledService == expectedComponentName) return true
        }
        return false
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun isOverlayPermissionEnabled(): Boolean = Settings.canDrawOverlays(getApplication())

    @RequiresApi(Build.VERSION_CODES.M)
    fun areOverlayAndAccessibilityEnabled(): Boolean = isAccessibilityServiceEnabled(
        getApplication(),
        AutoClickService::class.java
    ) && isOverlayPermissionEnabled()


}
















































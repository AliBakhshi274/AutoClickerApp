package com.example.autoclickerapp.ui.activity

import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.example.autoclickerapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DialogPermission().show(supportFragmentManager, "DialogPermission")

//        val isEnable: Boolean =
//            isAccessibilityServiceEnabled(this.applicationContext, AutoClickService::class.java)
//        Toast.makeText(this, "$isEnable", LENGTH_SHORT).show()

    }

//    private fun isAccessibilityServiceEnabled(context: Context, accessibilityService: Class<*>?): Boolean {
//        val expectedComponentName = ComponentName(context, accessibilityService!!)
//        val enabledServicesSetting =
//            Settings.Secure.getString(
//                context.contentResolver,
//                Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES
//            )
//                ?: return false
//        val colonSplitter = SimpleStringSplitter(':')
//        colonSplitter.setString(enabledServicesSetting)
//        while (colonSplitter.hasNext()) {
//            val componentNameString = colonSplitter.next()
//            val enabledService = ComponentName.unflattenFromString(componentNameString)
//            if (enabledService != null && enabledService == expectedComponentName) return true
//        }
//        return false
//    }

//    @RequiresApi(Build.VERSION_CODES.N)
//    private fun isAccessibilityServiceEnabled(
//        context: Context,
//        service: Class<out AccessibilityService?>
//    ): Boolean {
//        val am = context.getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager
//        val enabledServices =
//            am.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.CAPABILITY_CAN_PERFORM_GESTURES)
//        for (enabledService in enabledServices) {
//            val enabledServiceInfo: ServiceInfo = enabledService.resolveInfo.serviceInfo
//            if (enabledServiceInfo.packageName.equals(context.packageName) && enabledServiceInfo.name.equals(
//                    service.name
//                )
//            ) return true
//        }
//        return false
//    }

}





















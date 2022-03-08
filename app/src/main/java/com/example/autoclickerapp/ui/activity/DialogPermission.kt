package com.example.autoclickerapp.ui.activity

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.autoclickerapp.R
import com.example.autoclickerapp.databinding.DialogPermissionBinding
import com.example.autoclickerapp.services.AutoClickService
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber

class DialogPermission : DialogFragment() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: DialogPermissionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.dialog_permission,
            container,
            false
        )
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.bg_permission_dialog)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialogParams()
        listeners()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onResume() {
        super.onResume()
        showDialogCheck()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun showDialogCheck() {
        if (viewModel.areOverlayAndAccessibilityEnabled()) {
            dialog!!.dismiss()
        } else {
            overlayPermission()
            accessibilityService()
            manageDialogButtons()
        }
    }

    private fun dialogParams() {
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.setCanceledOnTouchOutside(false)
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    private fun listeners() {
        binding.dialogPermissionButtonOK.setOnClickListener {
            dialog!!.dismiss()
            Timber.w("Timber: OK")
        }
        binding.dialogPermissionButtonCancel.setOnClickListener {
            Timber.w("Timber: CANCEL")
            val snackbar: Snackbar = Snackbar.make(requireView(), "", Snackbar.LENGTH_SHORT)
            val customSnackbar: View =
                layoutInflater.inflate(R.layout.dialog_permission_snackbar, null)
            snackbar.view.setBackgroundColor(Color.TRANSPARENT)
            val snackbarLayout: Snackbar.SnackbarLayout = snackbar.view as Snackbar.SnackbarLayout
            snackbarLayout.setPadding(0, 0, 0, 0)
            snackbarLayout.addView(customSnackbar, 0)
            snackbar.show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun overlayPermission() {
        if (viewModel.isOverlayPermissionEnabled()) {
            binding.dialogPermissionImageViewOverlay.setImageResource(R.drawable.ic_confirm)
            binding.dialogPermissionParentOverlay.setOnClickListener(null)
        } else {
            binding.dialogPermissionImageViewOverlay.setImageResource(R.drawable.ic_error)
            binding.dialogPermissionParentOverlay.setOnClickListener {
                startActivity(Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION))
            }
        }
    }

    private fun accessibilityService() {
        Timber.w(
            "Timber: Accessibility Service Enabled? ${
                viewModel.isAccessibilityServiceEnabled(
                    requireContext(),
                    AutoClickService::class.java
                )
            }"
        )
        if (viewModel.isAccessibilityServiceEnabled(
                requireContext(),
                AutoClickService::class.java
            )
        ) {
            binding.dialogPermissionImageViewAccessibilityService.setImageResource(R.drawable.ic_confirm)
            binding.dialogPermissionParentAccessibilityService.setOnClickListener(null)
        } else {
            binding.dialogPermissionImageViewAccessibilityService.setImageResource(R.drawable.ic_error)
            binding.dialogPermissionParentAccessibilityService.setOnClickListener {
                startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun manageDialogButtons() {
        if (viewModel.areOverlayAndAccessibilityEnabled()) {
            binding.dialogPermissionButtonOK.setTextColor(Color.BLUE)
            binding.dialogPermissionButtonCancel.setTextColor(Color.GRAY)
            binding.dialogPermissionButtonCancel.isEnabled = false
            binding.dialogPermissionButtonOK.isEnabled = true
        } else {
            binding.dialogPermissionButtonOK.setTextColor(Color.GRAY)
            binding.dialogPermissionButtonOK.isEnabled = false
            binding.dialogPermissionButtonCancel.isEnabled = true
            binding.dialogPermissionButtonCancel.setTextColor(Color.BLUE)
        }
    }

}














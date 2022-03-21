package com.example.autoclickerapp.ui.home.scenarios

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.autoclickerapp.R
import com.example.autoclickerapp.databinding.DialogNewRenameScenarioBinding
import com.example.autoclickerapp.model.Scenario

class DialogName(val viewModel: ScenarioViewModel) : DialogFragment() {


    private lateinit var binding: DialogNewRenameScenarioBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.bg_permission_dialog)
        binding = DialogNewRenameScenarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialogParams()
        setTitle()
        editTextChangeListener(binding.editTextName, binding.btnOk, binding.btnCancel)
        btnOkClickListener(binding.btnOk)
        btnCancelClickListener(binding.btnCancel)
    }

    private fun dialogParams() {
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        dialog!!.setCanceledOnTouchOutside(true)
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    private fun setTitle() {
        if (viewModel.isClickedAddNewScenarioFb.value!!) {
            binding.tVScenarioTitle.text = getString(R.string.add_new_scenario)
        } else {
            binding.tVScenarioTitle.text = getString(R.string.rename_scenario)
        }
    }


    private fun editTextChangeListener(et: EditText, btnOk: Button, btnCancel: Button) {
        et.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (et.text.toString().trim().isEmpty()) {
                    btnOk.isEnabled = false
                    btnCancel.isEnabled = true
                    btnOk.setTextColor(Color.GRAY)
                    btnCancel.setTextColor(Color.BLUE)
                } else {
                    btnOk.isEnabled = true
                    btnCancel.isEnabled = false
                    btnOk.setTextColor(Color.BLUE)
                    btnCancel.setTextColor(Color.GRAY)
                }
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

    }

    private fun btnOkClickListener(btnOk: Button) {
        btnOk.setOnClickListener {
            dismiss()
            viewModel.activeLoadingProgressBar()
            if (viewModel.isClickedAddNewScenarioFb.value!!) {
                viewModel.saveScenario(Scenario(binding.editTextName.text.toString()))
            } else {
                viewModel.renameScenario(binding.editTextName.text.toString())
            }
        }

    }

    private fun btnCancelClickListener(btnCancel: Button) {
        btnCancel.setOnClickListener {
            dismiss()
        }
    }

}









































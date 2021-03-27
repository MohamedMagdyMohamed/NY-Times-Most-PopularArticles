package com.example.nytimesmostpopulararticles.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import com.example.nytimesmostpopulararticles.api.ResultException
import com.example.nytimesmostpopulararticles.ui.activities.MainActivity

abstract class BaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
    }

    open fun observeViewModel() {

    }

    open fun handleErrorResponse(error: ResultException) {
        if (error is ResultException.ApiError) {
            showMessage(error.message)
        } else {
            showMessage(error.messageResource)
        }
    }

    fun showMessage(message: String?) {
        getMainActivity()?.showMessage(message)
    }

    fun showMessage(messageResId: Int) {
        getMainActivity()?.showMessage(messageResId)
    }

    fun getMainActivity() = activity as MainActivity?

    fun handleLoading(show: Boolean) {
        if (show) {
            showProgress()
        } else {
            hideProgress()
        }
    }

    open fun showProgress() {
    }

    open fun hideProgress() {
    }

    fun replaceFragment(direction: NavDirections) {
        getMainActivity()?.replaceFragment(direction)
    }
}

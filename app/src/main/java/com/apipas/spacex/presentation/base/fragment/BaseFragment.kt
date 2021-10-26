package com.apipas.spacex.presentation.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.apipas.spacex.presentation.base.viewmodel.BaseViewModel
import com.apipas.spacex.presentation.base.viewmodel.MvvmFragment
import com.google.android.material.snackbar.Snackbar
import kotlin.reflect.KClass

abstract class BaseFragment<B : ViewDataBinding, VM : BaseViewModel>(
    layoutId: Int,
    viewModelClass: KClass<VM>
) :
    MvvmFragment<B, VM>(layoutId, viewModelClass) {

    private var rootLayout: View? = null

    open val requiresAuthentication = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        rootLayout = view?.rootView
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
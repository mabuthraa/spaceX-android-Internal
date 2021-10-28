package com.epam.spacex.presentation.base.activity

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.epam.spacex.presentation.base.viewmodel.BaseViewModel
import kotlin.reflect.KClass

abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes layoutId: Int, viewModelClass: KClass<VM>
) : MvvmActivity<B, VM>(layoutId, viewModelClass)
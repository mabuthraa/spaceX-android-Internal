package com.epam.spacex.presentation.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.epam.spacex.BR
import com.epam.spacex.presentation.base.event.base.LiveEvent
import com.epam.spacex.presentation.base.viewmodel.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass

abstract class MvvmActivity<B : ViewDataBinding, out VM : BaseViewModel>(
    @LayoutRes var layoutId: Int,
    viewModelClass: KClass<VM>
) : AppCompatActivity() {

    protected val viewModel: VM by lazy { getViewModel(clazz = viewModelClass) }
    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(viewModel)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
//        binding.setVariable(BR.lifecycle, this)
        binding.setVariable(BR.vm, viewModel)
    }

    protected fun <T : LiveEvent> subscribe(eventClass: KClass<T>, eventObserver: Observer<T>) {
        viewModel.subscribe(this, eventClass, eventObserver)
    }

    override fun onDestroy() {
        lifecycle.removeObserver(viewModel)
        super.onDestroy()
    }
}
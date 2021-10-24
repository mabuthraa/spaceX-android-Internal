package com.apipas.spacex.presentation.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.apipas.spacex.BR
import com.apipas.spacex.presentation.base.BaseViewModel
import com.apipas.spacex.presentation.base.event.common.LiveEvent
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass

abstract class MvvmActivity<B : ViewDataBinding, out VM : BaseViewModel>(@LayoutRes var layoutId : Int, viewModelClass: KClass<VM>) : AppCompatActivity() {

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
package com.epam.spacex.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.epam.spacex.R
import com.epam.spacex.databinding.FragmentHomeBinding
import com.epam.spacex.databinding.FragmentNoteListBinding
import com.epam.spacex.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeVM>(
    R.layout.fragment_home,
    HomeVM::class
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        subscribe(NavToNoteDetailEvent::class, Observer<NavToNoteDetailEvent> {
//            findNavController().navigate(
//                NoteListFragmentDirections.actionNoteListFragmentToNoteDetailFragment(
//                    it.idNote
//                )
//            )
//        })
    }
}
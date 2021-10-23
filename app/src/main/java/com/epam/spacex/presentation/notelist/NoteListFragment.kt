package com.epam.spacex.presentation.notelist

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.epam.spacex.R
import com.epam.spacex.databinding.FragmentNoteListBinding
import com.epam.spacex.presentation.base.BaseFragment

class NoteListFragment : BaseFragment<FragmentNoteListBinding, NoteListVM>(
    R.layout.fragment_note_list,
    NoteListVM::class
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribe(NavToNoteDetailEvent::class, Observer<NavToNoteDetailEvent> {
            findNavController().navigate(
                NoteListFragmentDirections.actionNoteListFragmentToNoteDetailFragment(
                    it.idNote
                )
            )
        })
    }
}
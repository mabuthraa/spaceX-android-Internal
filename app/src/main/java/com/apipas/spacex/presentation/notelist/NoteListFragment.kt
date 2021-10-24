package com.apipas.spacex.presentation.notelist

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.apipas.spacex.R
import com.apipas.spacex.databinding.FragmentNoteListBinding
import com.apipas.spacex.presentation.base.BaseFragment

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
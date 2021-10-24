package com.apipas.spacex.presentation.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.apipas.spacex.R
import com.apipas.spacex.databinding.FragmentHomeBinding
import com.apipas.spacex.presentation.base.BaseFragment
import com.apipas.spacex.presentation.home.viewmodel.HomeVM
import com.apipas.spacex.presentation.home.viewmodel.state.HomeCompanyInfoVS

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

    private fun observeViewModel() {
        viewModel.companyInfoVS.observe(this@HomeFragment, {
            when (it) {
                is HomeCompanyInfoVS.AddCompanyInfo -> {
//                    binding.textviewFirst.text = it.homeCompanyModel.companyName
//                    tvPostITitle.text = String.format(getString(R.string.post_text),it.postVM.title,it.postVM.body)
                }
                is HomeCompanyInfoVS.ShowLoader ->{
//                    binding.textviewFirst.text = "loading"
                }
                is HomeCompanyInfoVS.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

}
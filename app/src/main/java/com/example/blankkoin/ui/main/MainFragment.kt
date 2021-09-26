package com.example.blankkoin.ui.main

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.koin.getViewModelFromFactory
import com.example.blankkoin.R

import com.example.blankkoin.databinding.FragmentListBinding



import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class MainFragment : KoinComponent, RainbowCakeFragment<MainViewState, MainViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_list

    private lateinit var adapter: ArticleAdapter
    private lateinit var recyclerView : RecyclerView
    private var binding: FragmentListBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentListBinding.bind(view)
        recyclerView =binding!!.mainRecyclerView
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        viewModel.load()
    }


    private fun setupRecyclerView() {
        adapter= ArticleAdapter()
        recyclerView.adapter = adapter


    }

    override fun render(viewState: MainViewState) {
        adapter.submitList(viewState.articleData)


    }

}

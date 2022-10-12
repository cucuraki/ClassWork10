package com.example.classwork10.ui.chatsfragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.classwork10.common.responsestate.ResponseState
import com.example.classwork10.databinding.FragmentChatsBinding
import com.example.classwork10.ui.basefragments.BaseFragment
import com.example.classwork10.ui.chatsfragment.adapter.ChatAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ChatsFragment : BaseFragment<FragmentChatsBinding>(FragmentChatsBinding::inflate) {
    private val adapter: ChatAdapter by lazy {
        ChatAdapter()
    }
    private val viewModel: ChatsViewModel by viewModels()
    override fun init() {
        initRecycler()
        viewModel.getChats()
    }

    override fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.stateFlow.collect{
                    if(it is ResponseState.Success){
                        adapter.submitList(it.model)
                    }
                }
            }
        }
    }

    private fun initRecycler() {
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(context)
    }
}
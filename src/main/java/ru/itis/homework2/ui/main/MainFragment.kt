package ru.itis.homework2.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.itis.homework2.R
import ru.itis.homework2.databinding.FragmentMainBinding
import ru.itis.homework2.adapter.MainAdapter
import ru.itis.homework2.util.generateModels

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val list = generateModels((5..10).random()).toMutableList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentMainBinding.inflate(inflater,container,false).also{_binding = it}.root
    override fun onViewCreated(view:View,savedInstanceState:Bundle?){
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recycler.adapter = MainAdapter(list){ model ->
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ru.itis.homework2.ui.detail.DetailFragment.newInstance(model))
                .addToBackStack(null)
                .commit()
        }
    }
    override fun onDestroyView(){ _binding = null; super.onDestroyView() }
}

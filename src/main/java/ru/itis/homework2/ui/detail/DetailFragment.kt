package ru.itis.homework2.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.itis.homework2.data.ModelItem
import ru.itis.homework2.databinding.FragmentDetailBinding
import ru.itis.homework2.util.Constants

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var model: ModelItem
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        model = requireArguments().getSerializable(Constants.ARG_MODEL) as ModelItem
    }
    override fun onCreateView(inflater:LayoutInflater,container:ViewGroup?,savedInstanceState:Bundle?) =
        FragmentDetailBinding.inflate(inflater,container,false).also{
            _binding = it
        }.root

    override fun onViewCreated(view:View,savedInstanceState:Bundle?) {
        binding.imageDetail.setImageResource(model.imageRes)
        binding.titleDetail.text = model.title
        binding.descDetail.text = model.description
    }
    override fun onDestroyView(){
        _binding = null; super.onDestroyView()
    }

    companion object {
        fun newInstance(model: ModelItem) = DetailFragment().apply {
            arguments = Bundle().apply {
                putSerializable(Constants.ARG_MODEL, model)
            }
        }
    }
}

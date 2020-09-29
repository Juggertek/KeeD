package marcelfuchs.example.org.keed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import marcelfuchs.example.org.keed.R
import marcelfuchs.example.org.keed.databinding.FragmentNewItemBinding
import marcelfuchs.example.org.keed.model.Keed
import marcelfuchs.example.org.keed.viewmodel.ListViewModel

class NewItemFragment : Fragment() {

    private val viewModel: ListViewModel by activityViewModels()

    private var _binding: FragmentNewItemBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_item, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnEnterCancel.setOnClickListener { findNavController().navigate(R.id.action_enterItemsFragment_to_listFragment) }
        binding.btnEnterOk.setOnClickListener {
            getStrings()
            findNavController().navigate(R.id.action_enterItemsFragment_to_listFragment)
        }
        super.onViewCreated(view, savedInstanceState)
    }


    private fun getStrings() {
        val killString = binding.etEnterKills.text.toString()
        val deathsString = binding.etEnterDeaths.text.toString()
        if (killString != "" && deathsString != "") {
            // get Strings from the editText TextViews
            val kill = binding.etEnterKills.text.toString().toInt()
            val death = binding.etEnterDeaths.text.toString().toInt()
            val keed=Keed(kill, death)
            viewModel.addKeed(keed)
        }
    }

    //Fragments outlive their views. Make sure you clean up any references to the binding class instance in the fragment's onDestroyView() method.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
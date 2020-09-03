package marcelfuchs.example.org.keed

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_list.*
import marcelfuchs.example.org.keed.databinding.FragmentListBinding

lateinit var myAdapter: RecyclerAdapter
//private lateinit var viewModel: ListViewModel

class MainListFragment : Fragment() {

    private val viewModel: ListViewModel by activityViewModels()

    private var _binding: FragmentListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        myAdapter = RecyclerAdapter(viewModel.keedList)
        rv_killsDeaths.layoutManager = LinearLayoutManager(MainActivity())
        rv_killsDeaths.adapter = myAdapter

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_enterItemsFragment)
        }

        // close the softKeyboard as it keeps open when returning from NewItemFragment
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireView().getWindowToken(), 0)

        val itemTouchHelper = ItemTouchHelper(SwipeToDelete())
        itemTouchHelper.attachToRecyclerView(rv_killsDeaths)

        super.onViewCreated(view, savedInstanceState)
    }

    //Fragments outlive their views. Make sure you clean up any references to the binding class instance in the fragment's onDestroyView() method.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
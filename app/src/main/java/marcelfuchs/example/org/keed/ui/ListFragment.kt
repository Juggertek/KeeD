package marcelfuchs.example.org.keed.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import marcelfuchs.example.org.keed.R
import marcelfuchs.example.org.keed.RecyclerAdapter
import marcelfuchs.example.org.keed.databinding.FragmentListBinding
import marcelfuchs.example.org.keed.viewmodel.ListViewModel

class MainListFragment : Fragment() {

    private lateinit var myAdapter: RecyclerAdapter

    private lateinit var mListViewModel: ListViewModel

    private var mBinding: FragmentListBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = mBinding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //ListViewModel
        mListViewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        mListViewModel.keedList.observe(viewLifecycleOwner, Observer { keed ->
            myAdapter.setData(keed)
        })

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = mListViewModel

        //Recyclerview
        myAdapter = RecyclerAdapter()
        binding.rvKillsDeaths.layoutManager = LinearLayoutManager(MainActivity())
        binding.rvKillsDeaths.adapter = myAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_enterItemsFragment)
        }


        val swipeToDeleteCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder) = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position: Int = viewHolder.adapterPosition
                val item = mListViewModel.keedList.value!![position]
                mListViewModel.deleteUser(item)
                myAdapter.notifyItemRemoved(position)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(binding.rvKillsDeaths)

        // close the softKeyboard as it keeps open when returning from NewItemFragment
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireView().windowToken, 0)

        super.onViewCreated(view, savedInstanceState)
    }

    //Fragments outlive their views. Make sure you clean up any references to the binding class instance in the fragment's onDestroyView() method.
    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}
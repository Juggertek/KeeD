package marcelfuchs.example.org.keed

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*

var mKeedList: ArrayList<Keed> = ArrayList(
    listOf(
        Keed(2, 2),
        Keed(10, 3),
        Keed(2, 2),
        Keed(10, 3),
        Keed(2, 2),
        Keed(10, 3),
        Keed(2, 2),
        Keed(16, 3),
        Keed(2, 2),
        Keed(10, 3),
        Keed(2, 2),
        Keed(10, 3),
        Keed(2, 3),
        Keed(10, 3),
        Keed(2, 2),
        Keed(10, 3),
        Keed(23, 10)
    )
)

class MainListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        rv_killsDeaths.layoutManager = LinearLayoutManager(MainActivity())
        rv_killsDeaths.adapter = RecyclerAdapter(mKeedList)

        fab.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_enterItemsFragment)
        }

        // close the softKeyboard as it keeps open when returning from NewItemFragment
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireView().getWindowToken(), 0)

        val itemTouchHelper = ItemTouchHelper(SwipeToDelete(RecyclerAdapter(mKeedList)))
        itemTouchHelper.attachToRecyclerView(rv_killsDeaths)

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("MainListFragment", "onActivityCreated called")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("MainListFragment", "onStart called")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MainListFragment", "onResume called")
        super.onResume()
    }

    override fun onPause() {
        Log.d("MainListFragment", "onPause called")
        super.onPause()
    }

    override fun onDestroy() {
        Log.d("MainListFragment", "onDestroy called")
        super.onDestroy()
    }
}
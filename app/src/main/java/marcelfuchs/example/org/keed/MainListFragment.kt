package marcelfuchs.example.org.keed

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_list.*

var mKeedList: ArrayList<Keed> = ArrayList(
    listOf(
        Keed(2f, 2f),
        Keed(10f, 3f),
        Keed(23f, 10f)
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

        // close the softKeyboard as it keeps open when returning from NewItemFragment
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireView().getWindowToken(), 0)

        val itemTouchHelper = ItemTouchHelper(SwipeToDelete(RecyclerAdapter(mKeedList)))
        itemTouchHelper.attachToRecyclerView(rv_killsDeaths)

        super.onViewCreated(view, savedInstanceState)
    }
}
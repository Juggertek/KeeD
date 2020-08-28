package marcelfuchs.example.org.keed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_new_item.*

class NewItemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_new_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btn_enter_cancel.setOnClickListener { findNavController().navigate(R.id.action_enterItemsFragment_to_listFragment) }
        btn_enter_ok.setOnClickListener { addItem() }
        super.onViewCreated(view, savedInstanceState)
    }


    private fun addItem() {
        val killString = et_enter_kills.text.toString()
        val deathsString = et_enter_deaths.text.toString()
        var calcDeath=1F

        if (killString != "" && deathsString != "") {
            // get Strings from the editText TextViews
            val kill = et_enter_kills.text.toString().toFloat()
            val death = et_enter_deaths.text.toString().toFloat()
            if (death>=1){
                calcDeath=death
            }

            val newItem = Keed(kill, calcDeath)
            mKeedList.add(newItem)
            findNavController().navigate(R.id.action_enterItemsFragment_to_listFragment)
        }
    }
}
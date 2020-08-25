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


    fun addItem() {
        // get Strings from the editText TextViews
        val kill = et_enter_kills.text.toString().toFloat()
        val death = et_enter_deaths.text.toString().toFloat()

        val newItem = Keed(kill, death)
        mKeedList.add(newItem)

//        val actualDateTime: LocalDateTime = LocalDateTime.parse(LocalDateTime.now().toString())
//
//        val dateFormatter: DateTimeFormatter? = DateTimeFormatter.ofPattern("dd. MM. y")
//        val timeFormatter: DateTimeFormatter? = DateTimeFormatter.ofPattern("HH:mm")
//
//        val keedId=null
//        val creationDate = dateFormatter?.format(actualDateTime)
//        val creationTime = timeFormatter?.format(actualDateTime)
//
//        val kills = et_enter_kills.text.toString().toInt()
//        val deaths = et_enter_deaths.text.toString().toInt()
//        val ratio = (kills / deaths).toFloat()
//
//        val newEntry = Keed(
//            keedId,
//            creationDate,
//            creationTime,
//            kills,
//            deaths,
//            ratio
//        )
//        mKeeDList.add(newEntry)
//
//        val lastIndex = mKeeDList.lastIndex
        findNavController().navigate(R.id.action_enterItemsFragment_to_listFragment)
    }
}
package marcelfuchs.example.org.keed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.keed_item.view.*


class RecyclerAdapter(private val mKeedList: ArrayList<Keed>) :
    RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.keed_item, parent, false)
        )
    }

    override fun getItemCount() = mKeedList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.creationDate.text = mKeedList[position].keedId.toString()
        holder.creationTime.text = mKeedList[position].creationTime
        holder.kills.text = mKeedList[position].kill.toString()
        holder.deaths.text = mKeedList[position].death.toString()
        holder.ratio.text = mKeedList[position].ratio.toString()
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val creationDate: TextView = view.tv_creationDate
    val creationTime: TextView = view.tv_creationTime
    val kills: TextView = view.tv_kills
    val deaths: TextView = view.tv_deaths
    val ratio: TextView = view.tv_ratio
}

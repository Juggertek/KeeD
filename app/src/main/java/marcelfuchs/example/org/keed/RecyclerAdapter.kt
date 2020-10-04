package marcelfuchs.example.org.keed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.keed_item.view.*
import marcelfuchs.example.org.keed.model.Keed
import java.text.DateFormat
import java.text.SimpleDateFormat


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var keedList = emptyList<Keed>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val creationDate: TextView = view.tv_creationDate
        val creationTime: TextView = view.tv_creationTime
        val kills: TextView = view.tv_kills
        val deaths: TextView = view.tv_deaths
        val ratio: TextView = view.tv_ratio
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.keed_item, parent, false)
        )
    }

    override fun getItemCount() = keedList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val dateFormat=DateFormat.getDateInstance()
        val dateFormat = SimpleDateFormat("dd. MMM y")

        val date = dateFormat.format(keedList[position].creationDate)
        val time = keedList[position].creationTime

        holder.creationDate.text = date.toString()
        holder.creationTime.text = time.toString()
        holder.kills.text = keedList[position].kill.toString()
        holder.deaths.text = keedList[position].death.toString()
        holder.ratio.text = String.format("%.2f", keedList[position].ratio)
    }

    fun setData(keed: List<Keed>) {
        this.keedList = keed
        notifyDataSetChanged()
    }
}



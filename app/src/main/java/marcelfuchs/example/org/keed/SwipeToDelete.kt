package marcelfuchs.example.org.keed

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class SwipeToDelete(var adapter: RecyclerAdapter) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
    // since the feature is not used, simply return "false"
    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder) = false

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val position: Int = viewHolder.adapterPosition
        adapter.deleteItem(position)
    }
}
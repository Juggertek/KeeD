package marcelfuchs.example.org.keed.util

import android.util.Log
import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:hideIfZero")
fun hideIfZero(view: View, number: Int) {
    Log.d("BindingAdapter", "hideIfZero called with Int= $number")
    view.visibility = if (number == 0) View.VISIBLE else View.GONE
}

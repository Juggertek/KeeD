package marcelfuchs.example.org.keed

import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.ListFragment
import androidx.lifecycle.ViewModelProvider
import marcelfuchs.example.org.keed.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var aboutDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.about -> {
                showAboutDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showAboutDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_about, null, false)
        val builder = AlertDialog.Builder(this)

        val aboutVersion = dialogView.findViewById(R.id.about_version) as TextView
        aboutVersion.text = BuildConfig.VERSION_NAME

        builder.setPositiveButton(R.string.about_dialog_btn) { _, _ ->
            aboutDialog?.dismiss()
        }

        // Set the screen content from a layout resource.
        // The resource will be inflated, adding all top-level views to the screen.
        builder.setTitle(R.string.app_name)
        builder.setIcon(R.mipmap.ic_killdeath)
        aboutDialog = builder.setView(dialogView).create()

        // Start the dialog and display it on screen.
        aboutDialog?.show()


        // Needs to be called after the .show(),
        // otherwise the button doesn't exist yet, and can't be colored.
        val button: Button = aboutDialog!!.getButton(DialogInterface.BUTTON_POSITIVE)
        button.setTextColor(ContextCompat.getColor(this, R.color.secondaryTextColor))
    }
}
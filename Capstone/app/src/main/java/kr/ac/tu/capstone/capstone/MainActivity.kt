package kr.ac.tu.capstone.capstone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseMessaging.getInstance().subscribeToTopic("capstone")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.actionbar_actions, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_search -> consume { navigateToSearch() }
        else -> super.onOptionsItemSelected(item)
    }

    inline fun consume(f: () -> Unit): Boolean {
        f()
        return true
    }

    private fun navigateToSearch() {
        var t = Toast.makeText(this, "asdasd", Toast.LENGTH_SHORT)
        t.show()
    }
}

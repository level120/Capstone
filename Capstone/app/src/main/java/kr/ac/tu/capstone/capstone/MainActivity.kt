package kr.ac.tu.capstone.capstone

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.security.Permission

class MainActivity : AppCompatActivity() {

    private val videoView by lazy { findViewById<VideoView>(R.id.videoView) }
    private val btnCall1 by lazy { findViewById<Button>(R.id.button) }
    private val btnCall2 by lazy { findViewById<Button>(R.id.button2) }
    private val btnSerch by lazy { findViewById<Button>(R.id.button3)}
    private val editText by lazy { findViewById<EditText>(R.id.editText)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseMessaging.getInstance().subscribeToTopic("capstone")

        btnCall1.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-5232-9573"))
            startActivity(intent)
        }

        btnCall2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"))
            startActivity(intent)
        }
        btnSerch.setOnClickListener{

            /* RTSP, 시연장에서 다시 빌드하지 않도록 텍스트 박스 값 요망 */
            val mc = MediaController(this)
            val uri = Uri.parse(editText.text.toString())

            /*var uri = Uri.parse("rtsp://guest:1234@210.119.85.78:554/video1")*/

            videoView.setMediaController(mc)
            videoView.setVideoURI(uri)
            videoView.start()
        }
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
        var t = Toast.makeText(this, "우헿", Toast.LENGTH_SHORT)
        t.show()
    }

}

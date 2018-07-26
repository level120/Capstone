package kr.ac.tu.capstone.capstone

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseMessaging.getInstance().subscribeToTopic("capstone")

        //RTSP
        var videoView = findViewById(R.id.videoView) as VideoView
        var mc = MediaController(this)
        var uri = Uri.parse("rtsp://210.119.85.78:554/video1")
        /*var uri = Uri.parse("rtsp://guest:1234@210.119.85.78:554/video1")*/

        videoView.setMediaController(mc)
        videoView.setVideoURI(uri)
        videoView.start()

        //버튼
        var btn1 = findViewById(R.id.button) as Button
        var btn2 = findViewById(R.id.button2) as Button

        btn1.setOnClickListener {
            val intent = intent
            intent.setAction(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:051-112"))
            startActivity(intent)
        }
        btn2.setOnClickListener {
            var intent = intent
            intent.setAction(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:010-2482-3056"))
            startActivity(intent)
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
        var t = Toast.makeText(this, "asdasd", Toast.LENGTH_SHORT)
        t.show()
    }

}

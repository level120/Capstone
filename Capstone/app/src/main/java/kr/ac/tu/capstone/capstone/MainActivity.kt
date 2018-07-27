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

    private val videoView by lazy { findViewById<VideoView>(R.id.videoView) }

    private val btnCall1 by lazy { findViewById<Button>(R.id.button) }
    private val btnCall2 by lazy { findViewById<Button>(R.id.button2) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseMessaging.getInstance().subscribeToTopic("capstone")

        /* RTSP, 시연장에서 다시 빌드하지 않도록 텍스트 박스 값 요망 */
        val mc = MediaController(this)
        val uri = Uri.parse("rtsp://210.119.85.78:554/video1")
        /*var uri = Uri.parse("rtsp://guest:1234@210.119.85.78:554/video1")*/

        videoView.setMediaController(mc)
        videoView.setVideoURI(uri)
        videoView.start()

        /* 버튼, 1, 2 연락처 또한 사용자가 등록할 수 있도록 부탁(ex, 연락처 등록?) */
        btnCall1.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-5232-9573"))
            startActivity(intent)
        }
        btnCall2.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-2482-3056"))
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

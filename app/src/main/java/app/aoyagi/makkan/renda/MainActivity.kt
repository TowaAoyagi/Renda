package app.aoyagi.makkan.renda

import android.content.IntentSender
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var tapCount = 0
    var second = 10
    val timer: CountDownTimer = object : CountDownTimer(10000, 1000){

        override fun onFinish() {
            startButton.visibility = View.VISIBLE
            tapButton.setBackgroundResource(R.drawable.background_rounded_circle_glay)
            second = 10
            tapCount = 0
        }

        override fun onTick(millusUntilFinished: Long) {
            tapButton.setBackgroundResource(R.drawable.background_rounded_circle)
            second = second - 1
            secondText.text = second.toString()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tapButton.setOnClickListener {

            startButton.setOnClickListener {
                countText.text = tapCount.toString()
                startButton.visibility = View.INVISIBLE
                timer.start()

            }

            if (second < 10){
                tapCount += 1
                countText.text = tapCount.toString()
            }

        }
    }
}

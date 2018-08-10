package com.example.udaykanthd.tapme

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    internal lateinit var touchMeButton: Button
    internal lateinit var numberOfStars: TextView
    internal lateinit var numberOfBrightStars: TextView
    internal var score: Int = 0
    internal var gameStarted : Boolean = false
    internal lateinit var countDownTimer: CountDownTimer
    internal  var initialCountDownTimer: Long = 60000
    internal  var countDownInterval: Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        touchMeButton = findViewById<Button>(R.id.touch_me_button)
        numberOfStars = findViewById<TextView>(R.id.numberOfStars)
        numberOfBrightStars = findViewById<TextView>(R.id.numberOfBrightStars)
        resetGame()

        touchMeButton.setOnClickListener{ View ->
            incrementScore()
        }
    }

    private fun initialDefaultScore() {
        var  defaultScore = getString(R.string.hello_Star, score.toString())
        numberOfStars.text = defaultScore
        var  defaultScore2 = getString(R.string.hello_Star, score.toString())
        numberOfBrightStars.text = defaultScore2
    }

    private fun incrementScore() {
        if (!gameStarted) {
            startGame()
        }
        score = score + 1
        var  newScore = getString(R.string.hello_Star, score.toString())
        numberOfStars.text = newScore
    }
    private fun resetGame(){
        score = 0
        initialDefaultScore()
        val initialTimeLeft = initialCountDownTimer / 1000
        numberOfBrightStars.text = getString(R.string.hello_Star , initialTimeLeft.toString())
        countDownTimer = object : CountDownTimer(initialCountDownTimer , countDownInterval) {
            override fun onTick(milliSecUntilFinished: Long) {
                val timeleft = milliSecUntilFinished / 1000
                numberOfBrightStars.text = getString(R.string.hello_Star , timeleft.toString())
            }

            override fun onFinish() {
                endGame()
            }
        }
        gameStarted = false

    }
    private fun startGame() {
        countDownTimer.start()
        gameStarted = true
    }
    private fun endGame() {
        Toast.makeText(this, getString(R.string.game_Over_Message , score.toString()),Toast.LENGTH_LONG).show()
        resetGame()
    }
}

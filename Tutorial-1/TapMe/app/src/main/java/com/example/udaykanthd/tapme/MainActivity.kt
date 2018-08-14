package com.example.udaykanthd.tapme

import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
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
    internal val TAG = MainActivity::class.java.simpleName
    internal  var timeLeftOnTimer: Long = 60000

    companion object {
        private val SCORE_KEY = "SCORE_KEY"
        private val TIME_LEFT_KEY ="TIME_LEFT_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate function invoked, score is: $score")
        touchMeButton = findViewById<Button>(R.id.touch_me_button)
        numberOfStars = findViewById<TextView>(R.id.numberOfStars)
        numberOfBrightStars = findViewById<TextView>(R.id.numberOfBrightStars)

        if (savedInstanceState != null) {
        score = savedInstanceState.getInt(SCORE_KEY)
            timeLeftOnTimer = savedInstanceState.getLong(TIME_LEFT_KEY)
            restoreGame()
        }
        else {
            resetGame()
        }

        touchMeButton.setOnClickListener{ View ->
            val bounceAnimation = AnimationUtils.loadAnimation(this,R.anim.bounceanimation)
            View.startAnimation(bounceAnimation)
            incrementScore()
        }
    }
    private fun restoreGame() {
        Log.d(TAG,"restored Game")
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
        val blinkAnimation = AnimationUtils.loadAnimation(this,R.anim.blink)
        numberOfStars.startAnimation(blinkAnimation)
    }
    private fun resetGame(){
        score = 0
        initialDefaultScore()
        val initialTimeLeft = initialCountDownTimer / 1000
        numberOfBrightStars.text = getString(R.string.hello_Star , initialTimeLeft.toString())
        countDownTimer = object : CountDownTimer(initialCountDownTimer , countDownInterval) {
            override fun onTick(milliSecUntilFinished: Long) {
                timeLeftOnTimer = milliSecUntilFinished
                val timeleft = milliSecUntilFinished / 1000
                numberOfBrightStars.text = getString(R.string.hello_Star , timeleft.toString())
            }

            override fun onFinish() {
                endGame()
            }
        }
        gameStarted = false

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if (outState != null) {
            outState.putInt(SCORE_KEY,score)
        }
        outState?.putLong(TIME_LEFT_KEY,timeLeftOnTimer)
        countDownTimer.cancel()
        Log.d(TAG," score $score, timeleft :$timeLeftOnTimer")
    }

    override  fun onDestroy() {
            super.onDestroy()
        Log.d(TAG,"on destroy method invoked..!")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu,menu)
        return true

    }

     override fun onOptionsItemSelected(item: MenuItem?): Boolean {
         if (item!!.itemId == R.id.action_about) {
             showInfo()
         }
        return true
    }
    private  fun showInfo() {
        val dialogMessage =getString(R.string.about_message)
                val dialogTitle = getString(R.string.about_title, BuildConfig.VERSION_NAME)
        val builder = AlertDialog.Builder(this)
        builder.setTitle(dialogTitle)
        builder.setMessage(dialogMessage)
        builder.create().show()

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

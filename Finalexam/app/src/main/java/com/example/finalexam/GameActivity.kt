package com.example.finalexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class GameActivity : AppCompatActivity() {

    var computer_score=0
    var player_score=0
    val choices = listOf<String>("rock","paper","scissor")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val playerName = intent.getStringExtra("playerName")

        val playerNameTextView = findViewById<TextView>(R.id.playerNameHolder).apply {
            text = "Welcome " + playerName + "!"
        }

        val playerScoreNameTextBox = findViewById<TextView>(R.id.playerScoreNameTextbox).apply {
            text = playerName
        }


        val computerScoreTextView = findViewById<TextView>(R.id.computerScoreTextBox).apply {
            text = "" + computer_score
        }
        val playerScoreTextView = findViewById<TextView>(R.id.playerScoreTextBox).apply {
            text = "" + player_score
        }

    }

    fun gameLogicButtonPress(view: View)
    {
        when (view.id)
        {
            R.id.button_rock -> gameLogic("rock")
            R.id.button_paper -> gameLogic("paper")
            R.id.button_scissor -> gameLogic("scissor")
        }
    }

    fun gameLogic (playerOption: String)
    {
        //Toast.makeText(applicationContext,playerOption,Toast.LENGTH_SHORT).show()

        val randomComputerChoice = choices.random()

        if(randomComputerChoice != playerOption)
        {
            when (randomComputerChoice){

                "rock" ->{

                    if(playerOption == "paper") {
                        player_score++
                    }else if(playerOption == "scissor"){
                        computer_score++
                    }
                }

                "paper" -> {

                    if(playerOption == "rock"){
                        computer_score++
                    }else if(playerOption == "scissor"){
                        player_score++
                    }

                }

                "scissor" -> {

                    if(playerOption == "rock"){
                        player_score++
                    }else if(playerOption == "paper"){
                        computer_score++
                    }

                }
            }
        }

        updateScores(randomComputerChoice)

    }

    fun updateScores(computerChoice: String)
    {
        val computerScoreTextView = findViewById<TextView>(R.id.computerScoreTextBox).apply {
            text = "" + computer_score
        }

        val playerScoreTextView = findViewById<TextView>(R.id.playerScoreTextBox).apply {
            text = "" + player_score
        }

        val computerOptionTextView = findViewById<TextView>(R.id.currentComputerChoice).apply {
            text = "" + computerChoice
        }


    }


    fun finishGameFunction(view: View)
    {
        val computerScoreTextView = findViewById<TextView>(R.id.computerScoreTextBox)
        val playerScoreTextView = findViewById<TextView>(R.id.playerScoreTextBox)

        val computerScore = computerScoreTextView.text.toString()
        val playerScore = playerScoreTextView.text.toString()

        val intent = Intent(this, ScoreActivity::class.java).apply{
            putExtra("computerFinalScore",computerScore);
            putExtra("playerFinalScore", playerScore);
            putExtra("playerNameScore",intent.getStringExtra("playerName"))
        }

        startActivity(intent)

    }

}

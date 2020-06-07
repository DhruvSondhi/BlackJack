package com.dhruvsondhi.myproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PlayActivity : AppCompatActivity() {
    private val cards = Cards()
    private val user = Player(cards)
    private val comp = Opponent(cards)

    var currentValue = 0
    var currentValueO = 0

    var playing = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        var noOfTaps = 0
        var noOfTapsStand = 0

        var hiddenCard = findViewById<TextView>(R.id.hiddenCard)
        var shownCard = findViewById<TextView>(R.id.shownCard)
        var hiddenCard1 = findViewById<TextView>(R.id.hiddenCard1)
        var hiddenCard2 = findViewById<TextView>(R.id.hiddenCard2)
        var numberOfCardsComp = findViewById<TextView>(R.id.noOfCards)

        var card1 = findViewById<TextView>(R.id.card1)
        var card2 = findViewById<TextView>(R.id.card2)
        var card3 = findViewById<TextView>(R.id.card3)
        var card4 = findViewById<TextView>(R.id.card4)
        var scoreOfPlayer = findViewById<TextView>(R.id.scoreOfPlayer)
        var compScore = findViewById<TextView>(R.id.compScore)
        var hitButton = findViewById<Button>(R.id.hitButton)
        var standButton = findViewById<Button>(R.id.standButton)
        var checkForWinner = findViewById<Button>(R.id.winnerCheck)

        var restartButton = findViewById<Button>(R.id.restartButton)

//        hiddenCard.text = comp.opponentCards[0]
        shownCard.text = comp.opponentCards[1]
        hiddenCard.text = "HIDDEN\nCARD "

        card1.text = user.playerCards[0]
        card2.text = user.playerCards[1]
        card3.text = ""
        card4.text = ""

        user.playerCurrentScore()
        scoreOfPlayer.text = user.playerScore.toString()

        comp.opponentCurrentScore()
        compScore.text = comp.opponentScore.toString()
        compScore.visibility = View.INVISIBLE

        numberOfCardsComp.text = comp.numberOfCardsOpponent.toString()

//        gameComp(user.playerScore, comp.opponentScore)

        hitButton.setOnClickListener {
            Toast.makeText(this, "Hit Button Clicked!", Toast.LENGTH_SHORT).show()
            if (noOfTaps < 2) {
                var card = user.generateCard(cards)
                user.playerCards.add(card)
                when (noOfTaps) {
                    0 -> whenToDo(card3, 2)
                    1 -> whenToDo(card4, 3)
                }
                noOfTaps++
            } else {
                Toast.makeText(this, "Max Limit Reached", Toast.LENGTH_LONG).show()
                noOfTaps++
                currentValue = 0
            }
            user.playerScore += currentValue
            if (user.playerScore < 21) {
                scoreOfPlayer.text = user.playerScore.toString()
            } else {
                scoreOfPlayer.text = "BUSTED!!"
                Toast.makeText(this, "Dealer Wins !!", Toast.LENGTH_SHORT).show()
                checkForWinner.isEnabled = false
                restartButton.visibility = View.VISIBLE
                hitButton.visibility = View.INVISIBLE
                standButton.visibility = View.INVISIBLE
            }

        }

        standButton.setOnClickListener {
            Toast.makeText(this, "Stand button Clicked!", Toast.LENGTH_SHORT).show()
            // comp to hit until 17
            if (noOfTapsStand != 2) {
                if (comp.opponentScore < 17) {
                    var card = comp.generateCard(cards)
                    comp.opponentCards.add(card)
                    currentValueO = comp.currentCardValue(card)
                } else {
                    Toast.makeText(this, "Dealer BUSTED\nYou Win !!", Toast.LENGTH_LONG).show()
                    currentValueO = 0
                    hitButton.visibility = View.INVISIBLE
                    standButton.visibility = View.INVISIBLE
                    restartButton.visibility = View.VISIBLE
                }
                noOfTapsStand++
//                standButton.isEnabled = false
                comp.numberOfCardsOpponent += 1
                numberOfCardsComp.text = comp.numberOfCardsOpponent.toString()
                if (noOfTaps == 0) {
                    hiddenCard1.text = "HIDDEN\nCARD "
                    hiddenCard1.visibility = View.VISIBLE
                } else if (noOfTaps == 1) {
                    hiddenCard2.text = "HIDDEN\nCARD "
                    hiddenCard2.visibility = View.VISIBLE
                    standButton.isEnabled = false
                }
            }
            comp.opponentScore += currentValueO
            compScore.text = comp.opponentScore.toString()
//            gameComp(user.playerScore, comp.opponentScore)
        }


        checkForWinner.setOnClickListener {
            gameComp(user.playerScore, comp.opponentScore)
            hitButton.visibility = View.INVISIBLE
            standButton.visibility = View.INVISIBLE
            restartButton.visibility = View.VISIBLE
//            if (!playing) {
//                Toast.makeText(this,"Press Back Button!",Toast.LENGTH_LONG).show()
//            }
        }

        restartButton.setOnClickListener {
            val intent = Intent(this, PlayActivity::class.java)
            finish()
            overridePendingTransition( 0, 0);
            startActivity(intent)
            restartButton.visibility = View.INVISIBLE
            hitButton.visibility = View.VISIBLE
            standButton.visibility = View.VISIBLE
            overridePendingTransition( 0, 0);
        }
    }

    private fun whenToDo(textView: TextView, number: Int) {
        textView.text = user.playerCards[number]
        currentValue = user.currentCardValue(user.playerCards[number])
    }

    private fun gameComp(i: Int, j: Int) {
        val userDis = 21 - i
        val compDis = 21 - j
        when {
            userDis < compDis -> {
                Toast.makeText(this, "You Win !!", Toast.LENGTH_LONG).show()
                playing = false
//                Toast.makeText(this, "Please Press BackButton for Main Menu",Toast.LENGTH_LONG).show()
            }
            userDis > compDis -> {
                Toast.makeText(this, "Dealer Wins !!", Toast.LENGTH_LONG).show()
                playing = false
//                Toast.makeText(this, "Please Press BackButton for Main Menu",Toast.LENGTH_LONG).show()
            }
            else -> {
                Toast.makeText(this, "TIE !!", Toast.LENGTH_LONG).show()
                playing = false
//                Toast.makeText(this, "Please Press BackButton for Main Menu",Toast.LENGTH_LONG).show()
            }
        }
//        if(playing==false){
//            Toast.makeText(this,"Press Back Button!",Toast.LENGTH_LONG).show()
//        }
    }
}
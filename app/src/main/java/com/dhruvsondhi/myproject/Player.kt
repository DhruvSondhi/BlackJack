package com.dhruvsondhi.myproject

class Player(cards: Cards) : Cards() {
    //Player Card List
    var playerCards = mutableListOf<String>()
    var numberOfCardsPlayer = 0
    var playerScore = 0

    init {
        for (num in 0..1) {
            playerCards.add(generateCard(cards))
            numberOfCardsPlayer++
        }
    }

    fun playerCurrentScore() {
        for (card in playerCards) {
            for (rank in ranks) {
                if (card.contains(rank)) {
                    playerScore+= values[rank]!!
                }
            }
        }
    }

    fun currentCardValue(string: String): Int {
        for(rank in ranks){
            if(string.contains(rank)){
                return values[rank]!!
            }
        }
        return 0
    }


}
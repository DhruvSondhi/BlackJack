package com.dhruvsondhi.myproject

class Opponent(cards: Cards) : Cards() {
    //Opponent Card List
    var opponentCards = mutableListOf<String>()
    var numberOfCardsOpponent = 0
    var opponentScore=0

    init {
        for (num in 0..1) {
            opponentCards.add(generateCard(cards))
            numberOfCardsOpponent++
        }
    }

    fun opponentCurrentScore(){
        for(card in opponentCards){
            for(rank in ranks){
                if(card.contains(rank)){
                    opponentScore+= values[rank]!!
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
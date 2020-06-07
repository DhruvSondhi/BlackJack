package com.dhruvsondhi.myproject

open class Cards() {
    val suits = listOf<String>("Diamonds", "Clubs", "Spades", "Hearts")

    val ranks = listOf<String>(
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "Jack",
        "Queen",
        "King",
        "Ace"
    )

    val values: Map<String, Int> = mapOf<String, Int>(
        "2" to 2,
        "3" to 3,
        "4" to 4,
        "5" to 5,
        "6" to 6,
        "7" to 7,
        "8" to 8,
        "9" to 9,
        "10" to 10,
        "Jack" to 11,
        "Queen" to 12,
        "King" to 13,
        "Ace" to 1
    )

    var allPossibleCards = mutableListOf<String>()
    var numberOfCards = 0

    init {
        this.allCards()
    }

    private fun allCards() {
        for (suit in suits) {
            for (rank in ranks) {
                allPossibleCards.add("$suit\n$rank")
                numberOfCards++
            }
        }
    }

    fun generateCard(cards: Cards): String {
        var newCard = cards.allPossibleCards.random()
        for (card in cards.allPossibleCards) {
            if (newCard == card) {
                cards.allPossibleCards.removeAt(cards.allPossibleCards.indexOf(newCard))
                cards.numberOfCards -= 1
                return newCard
            }
        }
        return "no card"
    }

}
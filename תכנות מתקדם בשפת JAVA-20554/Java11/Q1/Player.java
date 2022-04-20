/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Batsheva Rich
 */
// base class for player
public class Player {

    private final String name;
    private Deck pDeck;
    private Boolean isWinner;

    public Player(String pName, Deck pDeck) {
        this.name = pName;
        this.pDeck = pDeck;
        this.isWinner = Boolean.FALSE;
    }

    // get player name
    public String getName() {
        return name;
    }

    // get if player is the winner
    public Boolean getIsWinner() {
        return isWinner;
    }

    // set if player is winner
    public void setIsWinner(Boolean isWinner) {
        this.isWinner = isWinner;
    }

    // return players deck
    public Deck getPlayerDeck() {
        return pDeck;
    }

    // return size of deck
    public int getDeckSize() {
        return pDeck.getDeckSize();
    }

    // get index of top card in players deck
    public int getCurrentCard() {
        return pDeck.getCurrentCard();
    }

    // deal the current players card
    public Card dealPlayerCard() {
        return pDeck.dealCard();
    }

    // player lost the card, remove from deck
    public void removePlayerCard(Card c) {
        pDeck.removeCardFromDeck(c);
    }

    // player won card, add to deck
    public void AddPlayerCard(Card c) {
        pDeck.addCardToDeck(c);
    }

}

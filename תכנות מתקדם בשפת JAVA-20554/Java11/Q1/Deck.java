/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.security.SecureRandom;
import java.util.ArrayList;

/**
 *
 * @author Batsheva Rich
 */
// base class for deck
public final class Deck {

    // static variables shared for all decks
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final int NUMBER_OF_CARDS = 52;
    private static final FacesEnum[] faces = {FacesEnum.Ace, FacesEnum.Deuce, FacesEnum.Three, FacesEnum.Four, FacesEnum.Five,
        FacesEnum.Six, FacesEnum.Seven, FacesEnum.Eight, FacesEnum.Nine, FacesEnum.Ten, FacesEnum.Jack, FacesEnum.Queen, FacesEnum.King};
    private static final SuitsEnum[] suits = {SuitsEnum.Hearts, SuitsEnum.Diamonds, SuitsEnum.Clubs, SuitsEnum.Spades};

    // full deck of cards
    private ArrayList<Card> deck = new ArrayList<>(NUMBER_OF_CARDS);

    // param for index of current card in deck
    private int currentCard = 0;

    // constructor to init empty deck
    public Deck() {
        emptyDeck();
    }

    // init deck with cards
    public void initDeck() {
        for (int count = 0; count < NUMBER_OF_CARDS; count++) {
            deck.add(new Card(faces[count % 13], suits[count / 13]));
        }
    }

    // empty current deck
    public void emptyDeck() {
        deck = new ArrayList<>(NUMBER_OF_CARDS);
    }

    // get index of current card in deck
    public int getCurrentCard() {
        return currentCard;
    }

    // get all cards in deck
    public ArrayList<Card> getCardsInDeck() {
        return deck;
    }

    // get deck size
    public int getDeckSize() {
        return deck.size();
    }

    // remove a specific card from the deck
    public void removeCardFromDeck(Card c) {
        deck.remove(c);
    }

    // add a specific card to the deck
    public void addCardToDeck(Card c) {
        deck.add(c);
    }

    // overload function, add list of cards to deck
    public void addCardToDeck(ArrayList<Card> cards) {
        for (Card c : cards) {
            addCardToDeck(c);
        }
    }

    // shuffle all cards in the deck
    public void shuffle() {
        currentCard = 0;
        for (int first = 0; first < NUMBER_OF_CARDS; first++) {
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
            Card temp = deck.get(first);
            deck.set(first, deck.get(second));
            deck.set(second, temp);
        }
    }

    // deal a card from deck by index of current card
    // imagine a player holding the deck, the card dealt is the 'top' in his hands
    public Card dealCard() {
        if (currentCard < deck.size()) {
            return deck.get(currentCard++);
        } else if (currentCard >= deck.size()) {
            // for case of player giving reaching end of deck and has to give 1/2/3 of his cards
            currentCard = 0;
            return deck.get(currentCard++);
        }
        return null;
    }

}

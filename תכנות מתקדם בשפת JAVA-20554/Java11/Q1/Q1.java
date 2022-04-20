/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Batsheva Rich <batsheva7424@gmail.com>
 */
@SuppressWarnings("unchecked")
public class Q1 {

    private static Deck playing_deck; // the main game deck
    private static Deck p1_deck; // first players deck
    private static Deck p2_deck; // second players deck
    private static Player P1; // first player
    private static Player P2; // second player
    private static final int DECK_SIZE = 52;
    private static final int WAR_SIZE = 3;
    
    private static final String package_name = Q1.class.getPackage().getName();;


    public static void initGame() {
        JOptionPane.showMessageDialog(null, "Welcome to the Game!", package_name, JOptionPane.INFORMATION_MESSAGE);
        String player1 = JOptionPane.showInputDialog("Enter first player name");
        if ("".equals(player1)) {
            player1 = "Player 1";
        }
        String player2 = JOptionPane.showInputDialog("Enter second player name");
        if ("".equals(player2)) {
            player2 = "Player 2";
        }

        // init main playing deck with cards and shuffle
        playing_deck = new Deck();
        playing_deck.initDeck();
        playing_deck.shuffle();

        // init first players deck with half of deck
        p1_deck = new Deck();
        ArrayList<Card> temp = new ArrayList(playing_deck.getCardsInDeck().subList(0, DECK_SIZE / 2));
        p1_deck.addCardToDeck(temp);

        // init second players deck with second half of deck
        p2_deck = new Deck();
        temp = new ArrayList(playing_deck.getCardsInDeck().subList(DECK_SIZE / 2, DECK_SIZE));
        p2_deck.addCardToDeck(temp);

        // set players with corresponding decks
        P1 = new Player(player1, p1_deck);
        P2 = new Player(player2, p2_deck);
    }

    // compare players card, and return if greater, smaller or equal
    public static PlayerState compareCard(Card c1, Card c2) {
        try {
            if (c1 == null || c2 == null) { // one of the players has reached the end of the deck
                return null;
            }
            if (c1.getValue() > c2.getValue()) { // if first player card is bigger
                return PlayerState.First;
            } else if (c1.getValue() < c2.getValue()) { // if second player card is bigger
                return PlayerState.Second;
            } else { // cards are equal
                return PlayerState.Equal;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // create list of cards for war level (helper function)
    public static void warState(Card c1, Card c2) {
        warState(new ArrayList<Card>() {
            {
                add(c1);
            }
        }, new ArrayList<Card>() {
            {
                add(c2);
            }
        });
    }

    // war state!! compare last card shown for each player
    public static void warState(ArrayList<Card> c1, ArrayList<Card> c2) {
        ArrayList<Card> p1_cards = new ArrayList<Card>() { // deal cards for first player
            {
                for (int i = 0; i < WAR_SIZE; i++) {
                    add(P1.dealPlayerCard());
                }
            }
        };
        ArrayList<Card> p2_cards = new ArrayList<Card>() { // deal cards for second player
            {
                for (int i = 0; i < WAR_SIZE; i++) {
                    add(P2.dealPlayerCard());
                }
            }
        };
        JOptionPane.showMessageDialog(null, "War!! \n" + P1.getName() + " card is: " + p1_cards.get(2) + "\n" + P2.getName()
                + " card is: " + p2_cards.get(2) + "\n", package_name, JOptionPane.INFORMATION_MESSAGE);

        PlayerState state = compareCard(p1_cards.get(2), p2_cards.get(2));
        //  multiple times in a row got war state, add previous cards at start of list
        if (!c1.isEmpty() && !c2.isEmpty()) {
            p1_cards.addAll(0, c1);
            p2_cards.addAll(0, c2);
        }

        // pass list of cards from loser to winner, pass list size (lists are equal in size therefore passing only one size)
        passCardsBetweenPlayers(p1_cards, p2_cards, state, p1_cards.size());

    }

    // pass single card between players, from loser to winner
    public static void passCardsBetweenPlayers(Card c1, Card c2, PlayerState state) {
        switch (state) {
            case First:
                P2.removePlayerCard(c2);
                P1.AddPlayerCard(c2);
                JOptionPane.showMessageDialog(null,"Passed a card from " + P2.getName() + " to " + P1.getName(), package_name, JOptionPane.INFORMATION_MESSAGE);
                break;
            case Second:
                P1.removePlayerCard(c1);
                P2.AddPlayerCard(c1);
                JOptionPane.showMessageDialog(null,"Passed a card from " + P1.getName() + " to " + P2.getName(), package_name, JOptionPane.INFORMATION_MESSAGE);     
                break;
            case Equal: // if entering war state, need to pass in array list
                warState(new ArrayList<Card>() {
                    {
                        add(c1);
                    }
                }, new ArrayList<Card>() {
                    {
                        add(c2);
                    }
                });
        }
    }

    // pass list of cards between players, from loser to winner
    public static void passCardsBetweenPlayers(ArrayList<Card> c1, ArrayList<Card> c2, PlayerState state, int size) {
        switch (state) {
            case First:
                for (int i = 0; i < size; i++) {
                    P2.removePlayerCard(c2.get(i));
                    P1.AddPlayerCard(c2.get(i));
                }
                JOptionPane.showMessageDialog(null,"Passed " + size + " cards from " + P2.getName() + " to " + P1.getName(), package_name, JOptionPane.INFORMATION_MESSAGE);
                break;
            case Second:
                for (int i = 0; i < size; i++) {
                    P1.removePlayerCard(c1.get(i));
                    P2.AddPlayerCard(c1.get(i));
                }
                JOptionPane.showMessageDialog(null,"Passed " + size + " cards from " + P1.getName() + " to " + P2.getName(), package_name, JOptionPane.INFORMATION_MESSAGE);
                break;
            case Equal:
                warState(c1, c2);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        initGame();

        // count number of moves until win
        int number_of_moves = 0;

        // keep playing the game until there is a winner
        while (!P1.getIsWinner() && !P2.getIsWinner()) {
            number_of_moves++;

            // deal a card for each of the players
            Card p1_card = P1.dealPlayerCard();
            Card p2_card = P2.dealPlayerCard();

            JOptionPane.showMessageDialog(null, P1.getName() + " card is: " + p1_card + "\n" + P2.getName() + " card is: " + p2_card + "\n" + P1.getName() + " deck size is: " + P1.getDeckSize() + "\n" + P2.getName() + " deck size is: " + P2.getDeckSize(), package_name, JOptionPane.INFORMATION_MESSAGE);

            // get state of card comparison, and pass the cards between the players
            PlayerState state = compareCard(p1_card, p2_card);
            switch (state) {
                case First:
                    passCardsBetweenPlayers(p1_card, p2_card, PlayerState.First);
                    break;
                case Second:
                    passCardsBetweenPlayers(p1_card, p2_card, PlayerState.Second);
                    break;
                case Equal:
                    warState(p1_card, p2_card);
            }
            if (P2.getDeckSize() == 0) { // if player 2 deck is empty, player 1 is the winner
                P1.setIsWinner(Boolean.TRUE);
                JOptionPane.showMessageDialog(null, P1.getName() + " is the winner!!\n In " + number_of_moves + " moves.", package_name, JOptionPane.INFORMATION_MESSAGE);
            } else if (P1.getDeckSize() == 0) { // if player 1 deck is empty, player 2 is the winner
                P2.setIsWinner(Boolean.TRUE);
                JOptionPane.showMessageDialog(null, P2.getName() + " is the winner!!\n In " + number_of_moves + " moves.", package_name, JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

}

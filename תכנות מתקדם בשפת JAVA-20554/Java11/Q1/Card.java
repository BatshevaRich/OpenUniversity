/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Batsheva Rich
 */

// base class for Cards
public class Card {
    private final  FacesEnum face;
    private final SuitsEnum suit;
    
    public Card(FacesEnum cardFace, SuitsEnum cardSuit){
        this.face = cardFace;
        this.suit = cardSuit;
    }
    
    public FacesEnum getFace(){
        return this.face;
    }
    
    public SuitsEnum getSuit(){
        return this.suit;
    }
    
    public int getValue(){
        return (int)this.face.ordinal() + 1;
    }
    
    @Override
    public String toString(){
        return face + " of " + suit;
    }
}

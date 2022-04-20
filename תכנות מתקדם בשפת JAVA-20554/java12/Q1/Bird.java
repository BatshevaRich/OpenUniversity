/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Batsheva Rich <batsheva7424@gmail.com>
 */

// basic bird class, all winged inherit from it
public abstract class Bird extends Animal implements Flight{
    protected double Wingspan;

    public Bird(double Wingspan, String Name, double Age, ColorEnum Color) {
        super(Name, Age, Color);
        this.Wingspan = Wingspan;
    }

    public double getWingspan() {
        return Wingspan;
    }

    public void setWingspan(double Wingspan) {
        this.Wingspan = Wingspan;
    }

    @Override
    public String toString() {
        return super.toString() + ". My wingspan is " + Wingspan;
    }

    @Override
    public boolean equals(Object obj) {
        final Bird other = (Bird) obj;
        if(!super.equals(obj)){
            return false;
        }
        return this.Wingspan == other.getWingspan();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Bird cloned = (Bird) super.clone();     
        return cloned;
    }
    
    
    
    
}

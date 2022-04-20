/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Batsheva Rich <batsheva7424@gmail.com>
 */
public class PolarBear extends Mammal implements Tricks {

    private double height;

    public double getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public PolarBear(double height, boolean Horns, Continent Continent, String Name, double Age, ColorEnum Color) {
        super(Horns, Continent, Name, Age, Color);
        this.height = height;
    }

    @Override
    public String toString() {
        return super.toString() + ". I am a polar bear and my height is " + this.height;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PolarBear other = (PolarBear) obj;
        return this.height == other.height;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        PolarBear cloned = (PolarBear) super.clone();
        return cloned;
    }

    @Override
    public String eat() {
        return "Fish and penguins!! Yum Yum";
    }

    @Override
    public String sleep() {
        return "ZZZ On the fjords";
    }

    @Override
    public String Trick() {
        return "I can balance a ball on my nose";
    }

    @Override
    public String Sound() {
        return "Roar!!!";
    }

}

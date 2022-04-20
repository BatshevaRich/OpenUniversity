/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Batsheva Rich <batsheva7424@gmail.com>
 */
public abstract class Fish extends Animal {

    private boolean Scales, Fins;

    public Fish(boolean Scales, boolean Fins, String Name, double Age, ColorEnum Color) {
        super(Name, Age, Color);
        this.Scales = Scales;
        this.Fins = Fins;
    }
    
    public abstract String WaterPreferance();

    @Override
    public String toString() {
        return super.toString() + ". I " + ((this.Scales)? "have": "don't have" )  + " scales and I " + ((this.Fins)? "have": "don't have" ) + " fins";
    }

    public boolean isScales() {
        return Scales;
    }

    public void setScales(boolean Scales) {
        this.Scales = Scales;
    }

    public boolean isFins() {
        return Fins;
    }

    public void setFins(boolean Fins) {
        this.Fins = Fins;
    }

    @Override
    public boolean equals(Object obj) {
        final Fish other = (Fish) obj;
        if (!super.equals(obj)) {
            return false;
        }
        return this.Fins == other.isFins() && this.Scales == other.isScales();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Fish cloned = (Fish) super.clone();
        return cloned;
    }
}

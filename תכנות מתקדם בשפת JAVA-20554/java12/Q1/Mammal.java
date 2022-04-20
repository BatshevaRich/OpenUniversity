
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Batsheva Rich <batsheva7424@gmail.com>
 */
public abstract class Mammal extends Animal{
    private boolean Horns;
    private Continent Continent;

    public Mammal(boolean Horns, Continent Continent, String Name, double Age, ColorEnum Color) {
        super(Name, Age, Color);
        this.Horns = Horns;
        this.Continent = Continent;
    }

    @Override
    public String toString() {
        return super.toString() + " and I am a mammal. I live in " + Continent + " and I " + ((this.Horns)? "have": "don't have" ) + " horns.";
    }

    public abstract String Sound();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Mammal cloned = (Mammal) super.clone();   
        return cloned;
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
        final Mammal other = (Mammal) obj;
        if (this.Horns != other.Horns) {
            return false;
        }
        return this.Continent.equals(other.Continent);
    }

    public boolean isHorns() {
        return Horns;
    }

    public void setHorns(boolean Horns) {
        this.Horns = Horns;
    }

    public Continent getContinent() {
        return Continent;
    }

    public void setCountry(Continent Continent) {
        this.Continent = Continent;
    }
}

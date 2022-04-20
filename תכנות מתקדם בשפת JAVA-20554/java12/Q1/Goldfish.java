
import java.util.Objects;


/**
 *
 * @author Batsheva Rich <batsheva7424@gmail.com>
 */
public class Goldfish extends Fish {

    private float bowlSize;
    private Owner owner;

    public Goldfish(Owner owner, float bowlSize, boolean Scales, boolean Fins, String Name, double Age, ColorEnum Color) {
        super(Scales, Fins, Name, Age, Color);
        this.bowlSize = bowlSize;
        this.owner = owner;
    }

    public float getBowlSize() {
        return bowlSize;
    }

    public void setBowlSize(float bowlSize) {
        this.bowlSize = bowlSize;
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
        final Goldfish other = (Goldfish) obj;
        if (this.bowlSize != other.bowlSize) {
            return false;
        }
        return Objects.equals(this.owner, other.owner);
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String eat() {
        return "Crumbs!! Yum Yum";
    }

    @Override
    public String sleep() {
        return "Sleeping with my eyes wide open";
    }

    @Override
    public String toString() {
        return super.toString() + ". I am a goldfish, my owner is " + this.owner + " and my bowl size is " + this.bowlSize;
    }

    @Override
    public String WaterPreferance() {
        return "I prefer sweet water";
    }

}

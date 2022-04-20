
/**
 *
 * @author Batsheva Rich <batsheva7424@gmail.com>
 */
public class Dog extends Mammal implements Tricks {

    private Owner owner;
    private boolean trained;

    @Override
    public String toString() {
        return super.toString() + " I am a dog. My owner is " + owner + " and I am " + ((this.trained) ? "" : "not") + " trained.";
    }

    public Dog(Owner owner, boolean trained, boolean Horns, Continent Continent, String Name, double Age, ColorEnum Color) {
        super(Horns, Continent, Name, Age, Color);
        this.owner = owner;
        this.trained = trained;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean isTrained() {
        return trained;
    }

    public void setTrained(boolean trained) {
        this.trained = trained;
    }

    @Override
    public String eat() {
        return "Meat and bones!! Yum Yum";
    }

    @Override
    public String sleep() {
        return "At the foot of my masters bed";
    }

    @Override
    public String Trick() {
        return "I can shake your hand";
    }

    @Override
    public String Sound() {
        return "Woof Woof";
    }

}

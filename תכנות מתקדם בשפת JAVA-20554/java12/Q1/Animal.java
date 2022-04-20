
/**
 *
 * @author Batsheva Rich <batsheva7424@gmail.com>
 */

// basic class,  all animals inherit from it
public abstract class Animal implements Cloneable {

    protected String Name;
    protected double Age;
    protected ColorEnum Color;

    @Override
    public String toString() {
        return "My name is: " + this.Name + ", I am " + this.Age + " years old and my color is " + this.Color;
    }

    @Override
    public boolean equals(Object obj) {
        final Animal other = (Animal) obj;
        if (other.getAge() != this.Age) {
            return false;
        }
        if (this.Name.equals(other.getName())) {
            return false;
        }
        return this.Color == other.getColor();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Animal cloned = (Animal) super.clone();
        return cloned;
    }

    public Animal(String Name, double Age, ColorEnum Color) {
        this.Name = Name;
        this.Age = Age;
        this.Color = Color;
    }

    public abstract String eat();

    public abstract String sleep();

    // setters and getters for basic properties
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getAge() {
        return Age;
    }

    public void setAge(double Age) {
        this.Age = Age;
    }

    public ColorEnum getColor() {
        return Color;
    }

    public void setColor(ColorEnum Color) {
        this.Color = Color;
    }

}

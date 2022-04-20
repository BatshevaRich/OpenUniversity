
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Batsheva Rich <batsheva7424@gmail.com>
 */
public class Eagle extends Bird {

    private Owner owner;

    public Eagle(Owner owner, double Wingspan, String Name, double Age, ColorEnum Color) {
        super(Wingspan, Name, Age, Color);
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String eat() {
        return "Seeds!! Yum Yum";
    }

    @Override
    public String sleep() {
        return "ZZZ... On the top of cliffs";
    }

    @Override
    public String toString() {
        return String.format("%s and my owner is %s", super.toString(), owner.toString());
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
        final Eagle other = (Eagle) obj;
        if (!super.equals(obj)) {
            return false;
        }
        return Objects.equals(this.owner, other.getOwner());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Eagle cloned = (Eagle) super.clone();
        return cloned;
    }

    @Override
    public String Fly() {
        return "I can fly";
    }

}

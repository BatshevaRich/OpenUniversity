
/**
 *
 * @author Batsheva Rich <batsheva7424@gmail.com>
 */
public class Penguin extends Bird implements Tricks {

    private boolean trained;

    public Penguin(boolean trained, double Wingspan, String Name, double Age, ColorEnum Color) {
        super(Wingspan, Name, Age, Color);
        this.trained = trained;
    }

    public boolean isTrained() {
        return trained;
    }

    public void setTrained(boolean trained) {
        this.trained = trained;
    }

    @Override
    public String eat() {
        return "Fish!! Yum Yum";
    }

    @Override
    public String sleep() {
        return "ZZZ... On the glaciers";
    }

    @Override
    public String toString() {
        return super.toString() + " and I " + ((this.trained) ? "Can" : "Can't") + " do tricks";
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
        final Penguin other = (Penguin) obj;
        if (!super.equals(obj)) {
            return false;
        }
        return this.trained == other.isTrained();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Eagle cloned = (Eagle) super.clone();
        return cloned;
    }

    @Override
    public String Fly() {
        return "I can't fly";
    }

    @Override
    public String Trick() {
        return "I can hug my trainer";
    }
}

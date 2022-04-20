
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Batsheva Rich <batsheva7424@gmail.com>
 */
public class Mmn12Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // default owners
        Owner firstOwner = new Owner("Batsheva", "9999999");
        Owner secondOwner = new Owner("Rochie", "11111111");

        
        Dog dog = new Dog(firstOwner, true, false, Continent.EUROPE, "Dog King", 2, ColorEnum.BROWN);
        PolarBear polarBear = new PolarBear(2.3, false, Continent.ANTARCTICA, "Polar Bear King", 4, ColorEnum.WHITE);
        Eagle eagle = new Eagle(new Owner("XXXXXXX", "33333333"), 9, "KingEagle", 11, ColorEnum.WHITE);
        Goldfish goldfish = new Goldfish(secondOwner, 50, true, true, "Goldfish King", 2.5, ColorEnum.GOLD);
        Penguin penguin = new Penguin(true, 4.2, "Penguin King", 0.9, ColorEnum.BLACK);
        
        ArrayList<Animal> animalPension = new ArrayList<>();
        animalPension.addAll(Arrays.asList(dog, polarBear, eagle, goldfish, penguin));
        
        for (Animal animal : animalPension) {
            System.out.println(animal.getClass().getSimpleName() + ":");
            // System.out.println(animal);
            System.out.println("What I eat: " + animal.eat());
            System.out.println("How I sleep: " + animal.sleep());
            
            if(animal instanceof Bird){
                System.out.println(((Bird) animal).Fly());
            }
            else if(animal instanceof Mammal){
                System.out.println("The sound I make is: " + ((Mammal)animal).Sound());
            }
            else if(animal instanceof Fish){
                System.out.println("My water preferance is: " + ((Fish)animal).WaterPreferance());
            }
        }
        
        System.out.println(eagle);
        try {
            Eagle newE = (Eagle) eagle.clone();
            newE.setName("QueenE");
            eagle.setOwner(new Owner("Rachel", "222222222"));
            System.out.println(eagle);
            System.out.println(newE);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}

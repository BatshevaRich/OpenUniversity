
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Batsheva Rich <batsheva7424@gmail.com>
 */
public class Mmn12Q2 {

    private static Scanner scan = new Scanner(System.in);// scanner for Tester class

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numerator1 = 0, denominator1 = 0, numerator2 = 0, denominator2 = 0;
        Rational r1 = Rational.getZero(), r2 = Rational.getZero();
        boolean repeat = false;
        do {
            try {
                System.out.println("Enter first numerator");
                numerator1 = ((numerator1 == 0) ? Integer.parseInt(scan.next()) : numerator1);
                System.out.println("Enter first numerator");
                denominator1 = ((denominator1 == 0) ? Integer.parseInt(scan.next()) : denominator1);
                System.out.println("Enter second numerator");
                numerator2 = ((numerator2 == 0) ? Integer.parseInt(scan.next()) : numerator2);
                System.out.println("Enter second denominator");
                denominator2 = ((denominator2 == 0) ? Integer.parseInt(scan.next()) : denominator2);
//                numerator1 = ((numerator1 == 0) ? Integer.parseInt(JOptionPane.showInputDialog("Enter first numerator")) : numerator1);
//                denominator1 = ((denominator1 == 0) ? Integer.parseInt(JOptionPane.showInputDialog("Enter first denominator")) : denominator1);
//                numerator2 = ((numerator2 == 0) ? Integer.parseInt(JOptionPane.showInputDialog("Enter second numerator")) : numerator2);
//                denominator2 = ((denominator2 == 0) ? Integer.parseInt(JOptionPane.showInputDialog("Enter second denominator")) : denominator2);
                repeat = false;
                r1 = new Rational(numerator1, denominator1);
                r2 = new Rational(numerator2, denominator2);
            } catch (NumberFormatException | ArithmeticException e) {
                repeat = true;
                System.out.println(e);
            }

        } while (repeat);

        // ctor        
        System.out.println("First Rational: " + r1);
        System.out.println("Second Rational: " + r2);

        // greater than
        System.out.println(r1 + " > " + r2 + "? " + r1.greaterThan(r2));

        // equals
        System.out.println(r1 + " = " + r2 + "? " + r1.equals(r2));

        // plus
        System.out.println(r1 + " + " + r2 + " = " + r1.plus(r2));

        // minus
        System.out.println(r1 + " - " + r2 + " = " + r1.minus(r2));

        // mult
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));

        // div
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));

    }

}

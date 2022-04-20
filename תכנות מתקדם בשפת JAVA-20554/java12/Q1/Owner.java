/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Batsheva Rich <batsheva7424@gmail.com>
 */
public class Owner {
    private String Name;
    private String Phone;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return "{" + "Name=" + Name + ", Phone=" + Phone + '}';
    }

    public Owner(String Name, String Phone) {
        this.Name = Name;
        this.Phone = Phone;
    }
}

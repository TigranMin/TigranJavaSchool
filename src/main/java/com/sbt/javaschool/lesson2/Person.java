package com.sbt.javaschool.lesson2;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    @Override
    public String toString() {
        if(this.spouse == null){
            return "Person{" + "man= " + man + ", name= '" + name + '\'' + '}';
        }
        else
            return "Person{" + "man= " + man + ", name= '" + name + '\'' + ", spouse= '" + spouse.name + '\'' + '}';
    }

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public Person getSpouse() {
        return spouse;
    }

    public boolean divorce() {
        if(this.spouse != null){
            spouse.spouse = null;   //divorce
            this.spouse = null;
        }
        return true;
    }

    public boolean marry (Person person) {
        if(this.man != person.man && this.spouse != person){ //method checks gender of persons and if they are not husband and wife
            if(this.spouse != null) {
                this.divorce();                            // If one of them has another spouse - execute divorce
            }
            if(person.spouse != null) {
                person.divorce();                          // If one of them has another spouse - execute divorce
            }

            this.setSpouse(person);  // marry
            person.setSpouse(this);  // marry

            return true;
        }
        else
            return false;
    }

    public static void main(String[] args) {
        Person andrew = new Person(true, "Andrew");
        Person ann = new Person(false, "Ann");
        andrew.marry(ann);
        //andrew.divorce();
        System.out.println(ann);// Ann's spouse is Andrew
        System.out.println(andrew);
    }

}

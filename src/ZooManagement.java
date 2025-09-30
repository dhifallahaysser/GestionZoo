package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;



public class ZooManagement {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo("belvedere", "Tunis");


        myZoo.addAnimal(new Animal("Sauvages", "Simba", 5, true));
        myZoo.addAnimal(new Animal("Domestiques", "Max", 3, true));
        myZoo.addAnimal(new Animal("les aigles", "moknin", 4, false));

        myZoo.displayZoo();
        myZoo.displayAnimals();


        Animal search = new Animal("X", "Simba", 0, false);
        System.out.println("Index Simba: " + myZoo.searchAnimal(search));


        myZoo.removeAnimal(search);
        myZoo.displayAnimals();


        Zoo z2 = new Zoo("aajab", "hawarya");
        z2.addAnimal(new Animal("F", "Zoro", 2, false));
        Zoo bigger = Zoo.comparerZoo(myZoo, z2);
        System.out.println("Zoo avec le plus d'animaux: " + bigger.getName());
    }
}


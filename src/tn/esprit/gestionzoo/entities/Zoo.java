package tn.esprit.gestionzoo.entities;
public class Zoo {
    public static final int NBR_CAGES = 25;
    private Animal[] animals;
    private String name;
    private String city;
    private int animalCount;

    public Zoo(String name, String city) {
        setName(name); // validation
        this.city = city;
        this.animals = new Animal[NBR_CAGES];
        this.animalCount = 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "Nom de zoo";
        } else {
            this.name = name;
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    // ====== Méthodes de gestion des animaux ======
    public boolean addAnimal(Animal animal) {
        if (animal == null) return false;
        if (isZooFull()) return false;
        if (searchAnimalByName(animal.getName()) != -1) return false; // utilise getter
        animals[animalCount++] = animal;
        return true;
    }

    public int searchAnimal(Animal animal) {
        if (animal == null) return -1;
        return searchAnimalByName(animal.getName()); // utilise getter
    }

    public int searchAnimalByName(String name) {
        if (name == null) return -1;
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int idx = searchAnimal(animal);
        if (idx == -1) return false;
        for (int i = idx; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animalCount - 1] = null;
        animalCount--;
        return true;
    }

    public void displayAnimals() {
        System.out.println("Animals in " + name + " (" + animalCount + "/" + NBR_CAGES + "):");
        for (int i = 0; i < animalCount; i++) {
            System.out.println("  " + i + ": " + animals[i]);
        }
    }

    public void displayZoo() {
        System.out.println("Zoo{name='" + name + "', city='" + city + "', nbrCages=" + NBR_CAGES + "}");
    }

    @Override
    public String toString() {
        return "Zoo{name='" + name + "', city='" + city + "', nbrCages=" + NBR_CAGES + "}";
    }

    public boolean isZooFull() {
        return animalCount >= NBR_CAGES;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1 == null) return z2;
        if (z2 == null) return z1;
        return (z1.animalCount >= z2.animalCount) ? z1 : z2;
    }
}

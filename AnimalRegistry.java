import java.util.ArrayList;

public class AnimalRegistry {
    //Написать метод поиска животного по имени
    private ArrayList<Animal> animals = new ArrayList<>();


    public Animal search(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }
    public void printAllAnimals() {
        for (Animal animal : animals) {
            System.out.println("Animal Name: " + animal.getName());
            System.out.println("Animal Type: " + animal.getType());
            animal.listCommands();
            System.out.println();
        }
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
    public Animal[] getAnimals() {
        return animals.toArray(new Animal[0]);
    }

}

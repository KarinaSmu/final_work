import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnimalRegistry animalRegistry = new AnimalRegistry();
        Counter counter = new Counter();

        System.out.println("Добро пожаловать в реестр домашних животных!");

        while (true) {
            int choice = Menu.displayMenu(scanner);

            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите имя животного: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите тип животного (DOMESTIC или PACK): ");
                    AnimalType type = AnimalType.valueOf(scanner.nextLine().toUpperCase());
                    Animal animal = new Animal(name, type);
                    System.out.print("Введите команды, которым обучено животное (через пробел): ");
                    animal.addCommand(scanner.nextLine());
                    animalRegistry.addAnimal(animal);
                    counter.add();
                    System.out.println("Животное под номером " + counter.getCount() + " успешно добавлено!");
                    break;


                case 2:
                    System.out.print("Введите имя животного: ");
                    String animalName = scanner.nextLine();
                    for (Animal a : animalRegistry.getAnimals()) {
                        if (a.getName().equals(animalName)) {
                            a.listCommands();
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Введите имя животного: ");
                    String searchName = scanner.nextLine();
                    Animal foundAnimal = animalRegistry.search(searchName);
                    if (foundAnimal != null) {
                        System.out.print("Введите команды, которым обучено животное (через пробел): ");
                        foundAnimal.addCommand(scanner.nextLine());
                    } else {
                        System.out.println("Животное не найдено.");
                    }
                    break;

                case 4:
                    animalRegistry.printAllAnimals();
                    break;

                case 5:
                    return;
            }
        }
    }
}

import java.util.Scanner;

public class Menu {
    public static int displayMenu(Scanner scanner) {
        System.out.println("Меню:");
        System.out.println("1. Завести новое животное");
        System.out.println("2. Увидеть список команд животного");
        System.out.println("3. Обучить животное новым командам");
        System.out.println("4. Вывести список всех животных");
        System.out.println("5. Выход");

        return scanner.nextInt();
    }
}


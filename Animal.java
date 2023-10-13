import java.util.ArrayList;

public class Animal {
    private String name;
    private AnimalType type;
    private ArrayList<String> commands = new ArrayList<>();


    public Animal(String name, AnimalType type) {
        this.name = name;
        this.type = type;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public void listCommands() {
        System.out.println("Commands: ");
        for (String command : commands) {
            System.out.println(command);
        }
    }

    public String getName() {
        return name;
    }

    public AnimalType getType() {
        return type;
    }
}

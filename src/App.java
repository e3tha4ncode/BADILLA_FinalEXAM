import java.util.Stack;

public class App {
    public static void main(String[] args) {
        // Define the creatures and their power levels
        Stack<Creature> creatureStack = new Stack<>();
        creatureStack.push(new Creature("Dragon ", 95));
        creatureStack.push(new Creature("Griffin", 88));
        creatureStack.push(new Creature("Unicorn", 78));
        creatureStack.push(new Creature("Phoenix", 92));
        creatureStack.push(new Creature("Centaur", 85));

        // Sort creatures by power level in descending order
        bubbleSortStack(creatureStack);
        selectionSortStack(creatureStack);

        // Display sorted creatures
        System.out.println("*** Bubble Sort: Descending Order by Power Level ***");
        for (Creature creature : creatureStack) {
            System.out.println(creature.getName() + " - " + creature.getPowerLevel());
        }
        System.out.println();
        System.out.println("*** Selection Sort: Ascending Order by Power Level ***");
        for (Creature creature : creatureStack) {
            System.out.println(creature.getName() + " - " + creature.getPowerLevel());
        }
        System.out.println();
        System.out.println("*** Stack Implementation: Popping Creatures ***");
        while (!creatureStack.isEmpty()) {
            Creature creature = creatureStack.pop();
            System.out.println("Popped: " + creature.getName() + " - " + creature.getPowerLevel());
        }
    }

    // Bubble Sort
    private static void bubbleSortStack(Stack<Creature> stack) {
        int size = stack.size();
        for (int a = 0; a < size - 1; a++) {
            for (int b = 0; b < size - a - 1; b++) {
                if (stack.get(b).getPowerLevel() < stack.get(b + 1).getPowerLevel()) {
                    Creature temp = stack.get(b);
                    stack.set(b, stack.get(b + 1));
                    stack.set(b + 1, temp);
                }
            }
        }
    }

    // Selection Sort
    private static void selectionSortStack(Stack<Creature> stack) {
        int size = stack.size();
        for (int a = 0; a < size - 1; a++) {
            int minIndex = a;
            for (int b = a + 1; b < size; b++) {
                if (stack.get(b).getPowerLevel() < stack.get(minIndex).getPowerLevel()) {
                    minIndex = b;
                }
            }
            if (minIndex != a) {
                Creature temp = stack.get(a);
                stack.set(a, stack.get(minIndex));
                stack.set(minIndex, temp);
            }
        }
    }
}

class Creature {
    private String creatureName;
    private int powerLevel;

    public Creature(String creatureName, int powerLevel) {
        this.creatureName = creatureName;
        this.powerLevel = powerLevel;
    }

    public String getName() {
        return creatureName;
    }

    public int getPowerLevel() {
        return powerLevel;
    }
}

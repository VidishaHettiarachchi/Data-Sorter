import java.util.*;

public class DataSorter {
    private static int[] dataset = new int[0];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = getIntInput();

            switch (choice) {
                case 1 -> enterNumbers();
                case 2 -> generateRandomNumbers();
                case 3 -> performBubbleSort();
                case 4 -> performMergeSort();
                case 5 -> performQuickSort();
                case 6 -> compareAll();
                case 7 -> System.out.println("Exiting program. Goodbye!");
                default -> System.out.println("Invalid choice. Try again!");
            }
        } while (choice != 7);
    }

    private static void enterNumbers() {
        System.out.print("Enter numbers separated by spaces: ");
        String[] parts = scanner.nextLine().split(" ");
        dataset = new int[parts.length];
        for (int i = 0; i < parts.length; i++) dataset[i] = Integer.parseInt(parts[i]);
        System.out.println("Dataset saved.");
    }

    private static void generateRandomNumbers() {
        System.out.print("Enter dataset size: ");
        int size = getIntInput();
        Random rand = new Random();
        dataset = new int[size];
        for (int i = 0; i < size; i++) dataset[i] = rand.nextInt(1000);
        System.out.println("Random dataset generated.");
    }

    private static void performBubbleSort() {
        BubbleSort.Result result = BubbleSort.sort(dataset);
        System.out.println("Sorted Array: " + Arrays.toString(result.sortedArray));
        System.out.println("Time: " + result.timeTaken + " ns | Steps: " + result.steps);
    }

    private static void performMergeSort() {
        MergeSort.Result result = MergeSort.sort(dataset);
        System.out.println("Sorted Array: " + Arrays.toString(result.sortedArray));
        System.out.println("Time: " + result.timeTaken + " ns | Steps: " + result.steps);
    }

    private static void performQuickSort() {
        QuickSort.Result result = QuickSort.sort(dataset);
        System.out.println("Sorted Array: " + Arrays.toString(result.sortedArray));
        System.out.println("Time: " + result.timeTaken + " ns | Steps: " + result.steps);
    }

    private static void compareAll() {
        System.out.println("\n--- Algorithm Performance Comparison ---");
        BubbleSort.Result b = BubbleSort.sort(dataset);
        MergeSort.Result m = MergeSort.sort(dataset);
        QuickSort.Result q = QuickSort.sort(dataset);

        System.out.printf("%-15s %-20s %-15s%n", "Algorithm", "Time (ns)", "Steps");
        System.out.println("-----------------------------------------------");
        System.out.printf("%-15s %-20d %-15d%n", "Bubble Sort", b.timeTaken, b.steps);
        System.out.printf("%-15s %-20d %-15d%n", "Merge Sort", m.timeTaken, m.steps);
        System.out.printf("%-15s %-20d %-15d%n", "Quick Sort", q.timeTaken, q.steps);
    }

    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}

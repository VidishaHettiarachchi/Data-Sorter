public class QuickSort {
    public static class Result {
        public int[] sortedArray;
        public long timeTaken;
        public int steps;
    }

    private static int steps;

    public static Result sort(int[] array) {
        int[] arr = array.clone();
        steps = 0;
        long start = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        long end = System.nanoTime();

        Result result = new Result();
        result.sortedArray = arr;
        result.timeTaken = (end - start);
        result.steps = steps;
        return result;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            steps++;
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            steps++;
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}

public class BubbleSort {
    public static class Result {
        public int[] sortedArray;
        public long timeTaken;
        public int steps;
    }

    public static Result sort(int[] array) {
        int[] arr = array.clone();
        Result result = new Result();
        int n = arr.length;
        int steps = 0;
        long start = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                steps++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    steps++;
                }
            }
        }

        long end = System.nanoTime();
        result.sortedArray = arr;
        result.timeTaken = (end - start);
        result.steps = steps;
        return result;
    }
}

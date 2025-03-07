import java.util.Comparator;
import java.util.Random;

public class Quick <T> implements Sorter<T> {

    /** Establishes ordering of type T */
    private Comparator<T> orderBy;

    /** Constructor for Merge Sort to set comparator
    *
    * @param order Comparator to establish ordering of array elements.
    */
    public Quick(Comparator<T> order) {
        orderBy = order;
    }

    /**
     * Counter of compare operations and loop iterations
     */
    long count = 0;

    @Override
    public void sort(T[] array) {
        // Reset count back to 0
        count = 0;
        // Call quickSort method
        quickSort(array, 0, array.length - 1);
    }

    /**
     * Quick Sort recursive method
     *
     * @param array Array to be sorted.
     * @param low   Low index
     * @param high  High index
     */
    private void quickSort(T[] array, int low, int high) {
        if (low < high) {
            // Partition the array
            int q = partion(array, low, high);
            // Recursively sort elements before partition and after partition
            quickSort(array, low, q - 1);
            quickSort(array, q + 1, high);
        }
    }

    /**
     * Partition method
     *
     * @param array Array to be sorted
     * @param low Starting index
     * @param high Ending index
     * @return Index of pivot
     */
    private int partion(T[] array, int low, int high) {
        // Randomize the pivot
        Random rand = new Random();
        int randomIndex = rand.nextInt(high - low) + low;
        swap(array, randomIndex, high);

        T x = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orderBy.compare(array[j], x) <= 0) {
                i++;
                swap(array, i, j);
            }
            count++;
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    /** Method to swap elements in array
     *
     * @param array Array to be swapped
     * @param i Index of first element
     * @param j Index of second element
     */
    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        count++;
    }

    @Override
    public void setComparator(Comparator<T> order) {
        orderBy = order;
    }

    @Override
    public long getCount() {
        return count;
    }
}

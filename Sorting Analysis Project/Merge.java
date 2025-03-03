import java.util.Comparator;

/** Merge Sort divide-and-conquer recursive algorithm */
public class Merge<T> implements Sorter<T> {

    /** Establishes ordering of type T */
    private Comparator<T> orderBy;

    /** Counter of compare operations and loop iterations */
    long count = 0;


    /** Constructor for Merge Sort to set comparator
    *
    * @param order Comparator to establish ordering of array elements.
    */
    public Merge(Comparator<T> order) {
        orderBy = order;
    }

    /** Sorts specified array using Merge Sort
    *
    * @param array Array to be sorted.
    */
    @Override
    public void sort(T[] array) {

        // Reset count back to 0
        count = 0;

        // _________________________________________________________________
        // TODO ___________ COMPLETE MERGE SORT BELOW __________________
        // ________________   IMPORTANT TO COMMENT YOUR CODE _______________

        // Call mergeSort method
        mergeSort(array, 0, array.length - 1);


        // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    } // end sort(T[])


    /** Function to merge the two halves
     *
     * @param array Array to be sorted
     * @param left Left index
     * @param middle Middle index
     * @param right Right index
     */
    private void merge (T[] array, int left, int middle, int right) {
        // Gets sizes of the two subarrays
        int n1 = middle - left + 1;
        int n2 = right - middle;

        @SuppressWarnings("unchecked")
        // Create temp arrays
        T[] L = (T[]) new Object[n1];
        @SuppressWarnings("unchecked")
        T[] R = (T[]) new Object[n2];

        // Copy data to temp arrays
        // Left half
        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
            count++;
        }
        // Right half
        for (int j = 0; j < n2; j++) {
            R[j] = array[middle + 1 + j];
            count++;
        }

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray
        int k = left;

        // Merge the temp arrays back into the original array
        while (i < n1 && j < n2) {
            if (orderBy.compare(L[i], R[j]) <= 0) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
            count++;
        }

        // Copy the remaining elements of L[], if any
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
            count++;
        }

        // Copy the remaining elements of R[], if any
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
            count++;
        }
    }
    /** Merge Sort recursive method
     *
     * @param array Array to be sorted
     * @param left Left index
     * @param right Right index
     */
    private void mergeSort(T[] array, int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = (left + right) / 2;
            // Sort first and second halves
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }


    @Override
    public void setComparator(Comparator<T> order) {
        orderBy = order;
    }

    @Override
    public long getCount() {
        return count;
    }
} // end class Merge

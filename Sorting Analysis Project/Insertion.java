import java.util.Comparator;

/** Insertion sort - an in-place sorting algorithm */
public class Insertion<T> implements Sorter<T> {

    /** Establishes ordering of type T */
    private Comparator<T> orderBy;

    /** Counter of compare operations */
    long count = 0;


    /** Constructor for Insertion Sort to set comparator
    *
    * @param order Comparator to establish ordering of array elements.
    */
    public Insertion(Comparator<T> order) {
        orderBy = order;
    }

    /** Sorts specified array using Insertion Sort. Inplace sorter.
    *
    * @param array Array to be sorted.
    */
    public void sort(T[] array) {

        // Reset count back to 0
        count = 0;

        // _________________________________________________________________
        // TODO ___________ COMPLETE INSERTION SORT BELOW __________________
        // ________________   IMPORTANT TO COMMENT YOUR CODE _______________

        // Iterate through the array
        for (int j = 1; j < array.length; j++) {
            // Set key to current element
            T key = array[j];
            // Insert array[j] into the sorted sequence array[1..j-1]
            int i = j - 1;
            while (i >= 0 && orderBy.compare(array[i], key) > 0) {
                array[i + 1] = array[i];
                i = i - 1;
                count++;
            }
            count++;
            array[i + 1] = key;
        }



        // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    } // end sort(T[])

    @Override
    public void setComparator(Comparator<T> order) {
        orderBy = order;
    }

    @Override
    public long getCount() {
        return count;
    }
} // end class Insertion

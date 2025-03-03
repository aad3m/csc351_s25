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
} // end class Merge

import java.util.function.Function;
import java.util.*;

/** Counting Sort assumes key of type Integer */
public class Counting<T> implements Sorter<T> {

    /** Extracts the key from an object in the array */
    Function<T,Integer> keyGetter = null;

    /** Max Value in the array to be sorted */
    Integer maxValue = null;

    /** Counter of loop iterations */
    long count = 0;

    /** Default empty constructor. */
    public Counting() {}

        /** Constructor for Counting
        *
        * @param order Comparator to establish ordering of array elements.
        */
        public Counting(Function<T,Integer> getter) {
            keyGetter = getter;
        }

        /** Constructor for Counting with known max value
        *
        * @param order Comparator to establish ordering of array elements.
        */
        public Counting(Function<T,Integer> getter, Integer maximum) {
            keyGetter = getter;
            this.maxValue = maximum;
        }

        /** Sorts specified array using Counting Sort. Inplace version of the sorter.
        *
        * @param array Array to be sorted.
        */
        @Override
        public void sort(T[] array) {
        
            // Reset count back to 0
        	count = 0;

            /*
            Counting sort is not an in-place sorting algorithm.
            To work around this, first the contents of array are copied
            into another array called "unsorted", which is the "A" array.
            */
            @SuppressWarnings("unchecked")
            T[] unsorted = (T[]) new Object[array.length];
            for (int i=0; i<array.length; i++) {
                unsorted[i] = array[i];
            }

            // TODO ... COMPLETE THE COUNTING SORT ALGORITHM.
            // When it is time to place the contents into the "B" array,
            // copy them from unsorted[] (i.e. "A") array into array[].

        } // end sort(T[])


        /* If max (i.e. k) is unknown, must find it within the array */
        private Integer findMax(T[] array) {
            Integer max = keyGetter.apply(array[0]);
            for (T element : array) {
                Integer valueOf = keyGetter.apply(element);
                if (valueOf > max) {
                    max = valueOf;
                }
            }
            return max;
        } // end findMax()

        public void setKeyGetter(Function<T,Integer> getter) {
            keyGetter = getter;
        }

        @Override
        public long getCount() {
            return count;
        }

        @Override
        public void setComparator(Comparator<T> c) {
            // not relevant for counting sort
        }
    } // end class Countin

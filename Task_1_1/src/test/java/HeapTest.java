import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Testing heap.
 */
public class HeapTest
{
    /**Array to sort.*/
    int[] array_to_sort;
    /**Right answer.*/
    int[] array_for_check;

    /**
     * Testing with the empty array.
     */
    @Test
    void testEmpty() {
        this.array_to_sort = new int[0];
        HeapSort.sortArr(this.array_to_sort);
        assert(this.array_to_sort.length == 0);
    }

    /**
     * Testing the worst case.
     */
    @Test
    void worstCase() {
        this.array_to_sort = new int[] {100, 70, 55, 10, 5, 4, 3, 2, 1, 0, -1, -5, -6, -7, -10};
        this.array_for_check = new int[] {-10, -7, -6, -5, -1, 0, 1, 2, 3, 4, 5, 10, 55, 70, 100};
        HeapSort.sortArr(this.array_to_sort);
        assert(Arrays.equals(this.array_to_sort, this.array_for_check));
    }

    /**
     * Testing one-element array.
     */
    @Test
    void oneNumber() {
        this.array_to_sort = new int[] {1};
        this.array_for_check = new int[] {1};
        HeapSort.sortArr(this.array_to_sort);
        assert(Arrays.equals(this.array_to_sort, this.array_for_check));
    }

    /**
     * Testing with unique value.
     */
    @Test
    void twoNumbers() {
        this.array_to_sort = new int[] {0, 0, 0, 0, 0, -1};
        this.array_for_check = new int[] {-1, 0, 0, 0, 0, 0};
        HeapSort.sortArr(this.array_to_sort);
        assert(Arrays.equals(this.array_to_sort, this.array_for_check));
    }

    /**
     * Testing with sorted array.
     */
    @Test
    void sortedCase() {
        this.array_to_sort = new int[] {1, 2, 3, 4, 5, 6};
        this.array_for_check = new int[] {1, 2, 3, 4, 5, 6};
        HeapSort.sortArr(this.array_to_sort);
        assert(Arrays.equals(this.array_to_sort, this.array_for_check));
    }

    @Test
    void otherCase() {
        this.array_to_sort = new int[] {1, 2, 3, 6, 5, 4};
        this.array_for_check = new int[] {1, 2, 3, 4, 5, 6};
        HeapSort.sortArr(this.array_to_sort);
        assert(Arrays.equals(this.array_to_sort, this.array_for_check));
    }

    @Test
    void otherCase_1() {
        this.array_to_sort = new int[] {3, 1, 2, 6, 4, 5};
        this.array_for_check = new int[] {1, 2, 3, 4, 5, 6};
        HeapSort.sortArr(this.array_to_sort);
        assert(Arrays.equals(this.array_to_sort, this.array_for_check));
    }

    @Test
    void otherCase_2() {
        this.array_to_sort = new int[] {4, 5, 6, 1, 2, 3};
        this.array_for_check = new int[] {1, 2, 3, 4, 5, 6};
        HeapSort.sortArr(this.array_to_sort);
        assert(Arrays.equals(this.array_to_sort, this.array_for_check));
    }

    @Test
    void otherCase_3() {
        this.array_to_sort = new int[] {0, 0, 0};
        this.array_for_check = new int[] {0, 0, 0};
        HeapSort.sortArr(this.array_to_sort);
        assert(Arrays.equals(this.array_to_sort, this.array_for_check));
    }

    @Test
    void otherCase_4() {
        this.array_to_sort = new int[] {-3, 160249, -192039059};
        this.array_for_check = new int[] {-192039059, -3, 160249};
        HeapSort.sortArr(this.array_to_sort);
        assert(Arrays.equals(this.array_to_sort, this.array_for_check));
    }
}
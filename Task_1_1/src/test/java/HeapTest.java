import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Testing heap.
 */
public class HeapTest {
    /**Array to sort.*/
    int[] arraytosort;
    /**Right answer.*/
    int[] arrayforcheck;

    /**
     * Testing with the empty array.
     */
    @Test
    void testEmpty() {
        this.arraytosort = new int[0];
        HeapSort.sortArr(this.arraytosort);

        assert(this.arraytosort.length == 0);
    }

    /**
     * Testing the worst case.
     */
    @Test
    void worstCase() {
        this.arraytosort = new int[] {100, 70, 55, 10, 5, 4, 3, 2, 1, 0, -1, -5, -6, -7, -10};
        this.arrayforcheck = new int[] {-10, -7, -6, -5, -1, 0, 1, 2, 3, 4, 5, 10, 55, 70, 100};
        HeapSort.sortArr(this.arraytosort);

        assert(Arrays.equals(this.arraytosort, this.arrayforcheck));
    }

    /**
     * Testing one-element array.
     */
    @Test
    void oneNumber() {
        this.arraytosort = new int[] {1};
        this.arrayforcheck = new int[] {1};
        HeapSort.sortArr(this.arraytosort);

        assert(Arrays.equals(this.arraytosort, this.arrayforcheck));
    }

    /**
     * Testing with unique value.
     */
    @Test
    void twoNumbers() {
        this.arraytosort = new int[] {0, 0, 0, 0, 0, -1};
        this.arrayforcheck = new int[] {-1, 0, 0, 0, 0, 0};
        HeapSort.sortArr(this.arraytosort);

        assert(Arrays.equals(this.arraytosort, this.arrayforcheck));
    }

    /**
     * Testing with sorted array.
     */
    @Test
    void sortedCase() {
        this.arraytosort = new int[] {1, 2, 3, 4, 5, 6};
        this.arrayforcheck = new int[] {1, 2, 3, 4, 5, 6};
        HeapSort.sortArr(this.arraytosort);

        assert(Arrays.equals(this.arraytosort, this.arrayforcheck));
    }

    @Test
    void otherCase() {
        this.arraytosort = new int[] {1, 2, 3, 6, 5, 4};
        this.arrayforcheck = new int[] {1, 2, 3, 4, 5, 6};
        HeapSort.sortArr(this.arraytosort);

        assert(Arrays.equals(this.arraytosort, this.arrayforcheck));
    }

    @Test
    void otherCase_1() {
        this.arraytosort = new int[] {3, 1, 2, 6, 4, 5};
        this.arrayforcheck = new int[] {1, 2, 3, 4, 5, 6};
        HeapSort.sortArr(this.arraytosort);

        assert(Arrays.equals(this.arraytosort, this.arrayforcheck));
    }

    @Test
    void otherCase_2() {
        this.arraytosort = new int[] {4, 5, 6, 1, 2, 3};
        this.arrayforcheck = new int[] {1, 2, 3, 4, 5, 6};
        HeapSort.sortArr(this.arraytosort);

        assert(Arrays.equals(this.arraytosort, this.arrayforcheck));
    }

    @Test
    void otherCase_3() {
        this.arraytosort = new int[] {0, 0, 0};
        this.arrayforcheck = new int[] {0, 0, 0};
        HeapSort.sortArr(this.arraytosort);

        assert(Arrays.equals(this.arraytosort, this.arrayforcheck));
    }

    @Test
    void otherCase_4() {
        this.arraytosort = new int[] {-3, 160249, -192039059};
        this.arrayforcheck = new int[] {-192039059, -3, 160249};
        HeapSort.sortArr(this.arraytosort);

        assert(Arrays.equals(this.arraytosort, this.arrayforcheck));
    }
}
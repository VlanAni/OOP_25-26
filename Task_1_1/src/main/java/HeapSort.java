/**
 * Class that sort array using Heap-object.
*/
public class HeapSort {
    /**
     * Static method that creates Heap-object and call <code>sort</code>.
     * Time complexity - O(N*log(N)).
     *
     * @param array - user's array.
     */
    public static void sortArr(int[] array)
    {
        Heap heap = new Heap();
        heap.sort(array);
    }
}

/**
 * Implementing <code>heap</code> data structure.
 * Main condition - parent is greater than its children.
 */
class Heap {
    /**nodes - array, that stores the tree.*/
    int[] nodes;
    /**size - nodes' size.*/
    int size;

    /**
     * <code>addNode</code> - adding node to the tree.
     * If added node is smaller that it's parent, then go up.
     * Time complexity - O(log(N)).
     *
     * @param number - number to add.
     */
    private void addNode(int number) {
        this.nodes[size] = number;
        int curr_idx = size;
        this.size++;
        while (curr_idx > 0 & nodes[curr_idx] < nodes[(curr_idx - 1) / 2])
        {
            swapInHeap(curr_idx, (curr_idx - 1) / 2);
            curr_idx = (curr_idx - 1) / 2;
        }
    }

    /**
     * Swapping values of given nodes.
     * Time complexity - O(1).
     *
     * @param idx1 - first node's index.
     *
     * @param idx2 - second node's index.
     */
    public void swapInHeap(int idx1, int idx2) {
        int t = this.nodes[idx1];
        this.nodes[idx1] = this.nodes[idx2];
        this.nodes[idx2] = t;
    }

    /**
     * Extracting minimal value from heap.
     * It swaps the root and last node and then goals the main condition.
     * To goal the main condition, it swaps the node and minimal child.
     * Time complexity - O(log(N)).
     *
     * @return - minimal value in the heap.
     */
    private int extractMin() {
        int min_value = this.nodes[0];
        swapInHeap(0, this.size - 1);
        this.size--;
        int child_to_swap = 0, curr_idx = 0, lc_idx, rc_idx;
        while (curr_idx * 2 + 1 < this.size) {
            lc_idx = curr_idx * 2 + 1;
            rc_idx = curr_idx * 2 + 2;
            if (this.nodes[lc_idx] < this.nodes[curr_idx]){
                child_to_swap = lc_idx;
            }
            if (rc_idx < size & nodes[rc_idx] < nodes[curr_idx] & nodes[lc_idx] > nodes[rc_idx]){
                child_to_swap = rc_idx;
            }
            if (curr_idx == child_to_swap){
                break;
            }
            swapInHeap(curr_idx, child_to_swap);
            curr_idx = child_to_swap;
        }
        return min_value;
    }

    /**
     * Creating a binary tree.
     * It reads i-th element from given array and uses {@link Heap#addNode}.
     * Time complexity: O(N * log(N)).
     *
     * @param array - array to sort.
     *
     * @param arr_size - given array's size.
     */
    private void buildHeap(int[] array, int arr_size) {
        this.nodes = new int[arr_size];
        for (int i = 0; i < arr_size; i++) {
            this.addNode(array[i]);
        }
    }

    /**
     * Sorting given array.
     * First step - creating a heap.
     * Second step - on each iteration it extracts min and rewrite array[i].
     * Time complexity:  O(2 * n * log(n)) = O(n * log(n)).
     *
     * @param array - array to sort.
     */
    public void sort(int[] array) {
        int arr_size = array.length, min_val;
        this.buildHeap(array, arr_size);
        for (int i = 0; i < arr_size; i++) {
            min_val = this.extractMin();
            array[i] = min_val;
        }
    }
}
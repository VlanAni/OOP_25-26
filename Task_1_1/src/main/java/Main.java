class Main {

    public static void main(String[] args) {
        int[] arr = new int[] {6, 5, 4, 3, 2, 1};
        System.out.println("--Unsorted array--");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.print('\n');
        HeapSort.sortArr(arr);
        System.out.println("Sorted array");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
}
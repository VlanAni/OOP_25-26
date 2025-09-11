/**
 * Класс, предоставляющий возможность произвести <b>HeapSort</b> над массивом с помощью метода <code>sortArr</code>
 * @author Анисимов Владимир 24214
*/
class HeapSort
{
    /**
     * Статический метод, создающий объект класса куча (Heap), и обращается к его методу сортировки
     * Временная сложность сортировки кучей - O(N*log(N))
     * @param array - массив, который передаёт пользователь
     */
    public static void sortArr(int[] array)
    {
        Heap heap = new Heap();
        heap.sort(array);
    }
}

/**
 * Класс, реализующий структуру данных "двоичная куча"
 * Инвариант кучи - отец меньше своих двух сыновей
 * @author Анисимов Владимир 24214
 */
class Heap
{
    /**nodes - массив, хранящий кучу в следующем виде: индекс отца = i, индекс детей = 2 * i + 1; 2 * i + 2*/
    int[] nodes;
    /**size - параметр, хранящий количество элементов в куче*/
    int size;

    /**
     * <code>addNode</code> - метод, добавляющий ноду в дерево и восстанавливающий инвариант
     * Если добавленная нода <b>меньше своего отца</b>, то поднимаем её вверх
     * Временная сложность операции - O(log(N))
     * @param number - добавляемое число
     */
    private void addNode(int number)
    {
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
     * Метод, позволяющий нодам обменяться значениями
     * Временная сложность - O(1)
     * @param idx1 - индекс первой ноды
     * @param idx2 - индекс второй ноды
     */
    public void swapInHeap(int idx1, int idx2)
    {
        int t = this.nodes[idx1];
        this.nodes[idx1] = this.nodes[idx2];
        this.nodes[idx2] = t;
    }

    /**
     * Метод, извлекающий минимальное значение из кучи (<b>корень бинарного дерева</b>)
     * Метод меняет местами самую последнюю ноду и корень, удаляет ноду с минимумом и восстанавливает инвариант
     * Инвариант восстанавливается перемещением нового корня вниз, меняя его местами с минимальным сыном
     * Таким образом, сложность операции - O(log(N))
     * @return - минимальное значение в куче
     */
    private int extractMin()
    {
        int min_value = this.nodes[0];
        swapInHeap(0, this.size - 1);
        this.size--;
        int child_to_swap = 0, curr_idx = 0, lc_idx, rc_idx;
        while (curr_idx * 2 + 1 < this.size)
        {
            lc_idx = curr_idx * 2 + 1;
            rc_idx = curr_idx * 2 + 2;
            if (this.nodes[lc_idx] < this.nodes[curr_idx]){
                child_to_swap = lc_idx;
            }
            if (rc_idx < this.size & this.nodes[rc_idx] < nodes[curr_idx] & this.nodes[lc_idx] > this.nodes[rc_idx]){
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
     * Метод, который по входному массиву и его размеру создаёт бинарное дерево
     * На каждой итерации цикла берётся i-ый элемент из массива и добавляется в кучу с помощью {@link Heap#addNode}
     * Сложность работы метода: O(n * log(n)), так как на каждой итерации добавляется нода в дерево
     * @param array - массив, из которого строится куча
     * @param arr_size - размер массива
     */
    private void buildHeap(int[] array, int arr_size)
    {
        this.nodes = new int[arr_size];
        for (int i = 0; i < arr_size; i++)
        {
            this.addNode(array[i]);
        }
    }

    /**
     * Метод, осуществляющий сортровку массива
     * 1 шаг - построение кучи из исходного массива
     * 2 шаг - на каждой итерации мы извлекаем минимум из кучи и перезаписываем i-ый элемент в массиве
     * Сложность операции: O(n * log(n) + n * log (n)) = O(2 * n * log(n)) = O(n * log(n))
     * @param array - массив, который необходимо отсортировать
     */
    public void sort(int[] array)
    {
        int arr_size = array.length, min_val;
        this.buildHeap(array, arr_size);
        for (int i = 0; i < arr_size; i++)
        {
            min_val = this.extractMin();
            array[i] = min_val;
        }
    }
}
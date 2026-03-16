package algorithm;

import java.util.Comparator;

/**
 * Реализация алгоритма бинарного поиска для отсортированных массивов с использованием компаратора.
 * Ищет индекс заданного элемента за O(log n) времени.
 */
public class BinarySearch {
  private BinarySearch() {
    /* This utility class should not be instantiated */
  }


  /**
   * Выполняет бинарный поиск элемента в отсортированном массиве.
   * Алгоритм последовательно делит интервал поиска пополам, сравнивая средний элемент
   * с искомым ключом. На каждом шаге отбрасывается половина оставшихся элементов.
   *
   * @param sortedArray отсортированный массив для поиска (не должен быть null)
   * @param key искомый элемент (может быть null, если компаратор поддерживает null)
   * @param low начальный индекс диапазона поиска (включительно)
   * @param high конечный индекс диапазона поиска (включительно)
   * @param comparator компаратор для сравнения элементов (не должен быть null)
   * @return индекс найденного элемента, либо -1, если элемент не найден
   */
  public static <T> int search(
      T[] sortedArray, T key, int low, int high, Comparator<T> comparator) {

    //    System.out.println("Got low=" + low + "\nGot high=" + high);
    while (low <= high) {
      //      System.out.printf("%s %s\n", low, high);
      int mid = (high + low) / 2;
      if (comparator.compare(sortedArray[mid], key) < 0) {
        low = mid + 1;
      } else if (comparator.compare(sortedArray[mid], key) > 0) {
        high = mid - 1;
      } else if (comparator.compare(sortedArray[mid], key) == 0) {
        return mid;
      }
    }
    return -1;
  }
}

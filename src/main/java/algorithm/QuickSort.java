package algorithm;

import java.util.Comparator;


/**
 * Реализация алгоритма быстрой сортировки (QuickSort) с использованием компаратора.
 * Сортирует массив на месте, используя стратегию «разделяй и властвуй».
 */
public class QuickSort {
  private QuickSort() {
    /* This utility class should not be instantiated */
  }

  /**
   * Сортирует подмассив arr[low..high] с использованием алгоритма быстрой сортировки.
   *
   * @param arr массив для сортировки (не должен быть null)
   * @param low начальный индекс подмассива (включительно)
   * @param high конечный индекс подмассива (включительно)
   * @param comparator компаратор для сравнения элементов (не должен быть null)
   */
  public static <T> void quickSort(T[] arr, int low, int high, Comparator<T> comparator) throws NullPointerException {
    if (arr == null) {
      throw new NullPointerException("Массив для сортировки не должен быть null");
    } else if (comparator == null) {
      throw new NullPointerException("Компаратор для сортировки не должен быть null");
    }
    if (low < high) {
      int pi = partition(arr, low, high, comparator);

      quickSort(arr, low, pi - 1, comparator);
      quickSort(arr, pi + 1, high, comparator);
    }
  }

  /**
   * Разбивает подмассив arr[low..high] вокруг опорного элемента (pivot = arr[high]).
   * Элементы, меньшие опорного, перемещаются влево, большие или равные — вправо.
   *
   * @param arr массив, в котором выполняется разбиение
   * @param low начальный индекс подмассива
   * @param high конечный индекс подмассива
   * @param comparator компаратор для сравнения элементов
   * @return индекс опорного элемента после разбиения
   */
  private static <T> int partition(T[] arr, int low, int high, Comparator<T> comparator) {
    T pivot = arr[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {
      if (comparator.compare(arr[j], pivot) < 0) {
        i++;

        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    T temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
  }
}

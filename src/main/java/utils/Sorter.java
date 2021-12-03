package utils;

import java.util.Comparator;

public interface Sorter<T> {
    void sort(Repository<T> rep, Comparator<T> comparator);

}
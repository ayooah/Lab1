package utils;

import models.Contract;
import utils.annotations.AutoInjectable;
import utils.sorters.BubbleSorter;
import utils.sorters.Sorter;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * utils.ArrayRepository class is a dynamically expanding array that implements the {@code utils.Repository} interface
 *
 * @param <T> the type of elements in this repository
 * @autor Anna Ushakova
 */
public class ArrayRepository<T extends Contract> implements Repository<T> {
    /**
     * Array storing all types of contracts
     */
    private T[] arr;
    /**
     * Start length of array
     */
    private int initionalSize = 20;
    /**
     * Count of not null element in array
     */
    private int size = 0;
    /**
     * Length of array
     */
    private int length;

    public Sorter<Contract> getSorter() {
        return sorter;
    }

    @AutoInjectable
    private BubbleSorter sorter;

    /**
     * Constructs a repository of initional size
     */

    public ArrayRepository() {
        this.arr = (T[]) new Contract[initionalSize];
        this.length = initionalSize;
    }

    /**
     * @return count of not null element in repository
     */
    public int getSize() {
        return size;
    }

    /**
     * Appends a contract to the end of the repository
     *
     * @param contract added to the repository
     */
    public void add(T contract) {
        if (this.size >= this.length) {
            this.length *= 2;
            T[] prevArr = this.arr;
            this.arr = (T[]) new Contract[this.length];
            System.arraycopy(prevArr, 0, this.arr, 0, this.size);
        }
        this.arr[size] = contract;
        size++;
    }

    public void addByIndex(T contract, int index) {

        T[] prevArr = this.arr;

        if (this.size >= this.length) {
            this.length *= 2;
        }
        this.arr = (T[]) new Contract[this.length];
        System.arraycopy(prevArr, 0, this.arr, 0, index);
        this.arr[index] = contract;
        System.arraycopy(prevArr, index, this.arr, index + 1, this.arr.length - index - 1);

        size++;
    }

    /**
     * Appends array of contracts to the end of the repository
     *
     * @param arr added to the repository
     * @return true if operation success
     */
    public boolean addArr(T[] arr) {
        if (arr != null) {
            for (T i : arr) {
                add(i);
            }
            return true;
        }
        return false;
    }

    /**
     * Removes a contract from the repository  with a specific id
     *
     * @param id of the contract to be deleted
     */
    public boolean removeById(int id) {
        for (int i = 0; i < size; i++) {

            if (this.arr[i] != null && this.arr[i].getId() == id) {
                removeByIndex(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes a contract from the repository  in a certain position
     *
     * @param index of deletions
     */
    public void removeByIndex(int index) {
        T[] prevArr = this.arr;
        if (size < this.initionalSize) {
            this.arr = (T[]) new Contract[initionalSize];
        } else {
            this.arr = (T[]) new Contract[length];
        }
        System.arraycopy(prevArr, 0, this.arr, 0, index);
        System.arraycopy(prevArr, index + 1, this.arr, index, prevArr.length - index - 1);
        size--;

    }

    /**
     * Returns a repository with matching items
     *
     * @param p             predicate
     * @param expectedClass
     * @return the found repository
     */
    public Repository<T> search(Predicate p, Class expectedClass) {
        Repository<T> res = new ArrayRepository<>();
        for (int i = 0; i < this.size; i++) {

            if ((expectedClass == this.arr[i].getClass() || expectedClass == Contract.class)
                    && p.test(this.arr[i])) {
                res.add(this.arr[i]);
            }
        }
        return res;
    }

    /**
     * Returns a contract with a specific id from the repository
     *
     * @param id of the contract
     * @return the found contract
     */
    public T getbyId(int id) {
        for (int i = 0; i < size; i++) {
            if (this.arr[i] != null && this.arr[i].getId() == id) {
                return this.arr[i];
            }
        }
        return null;
    }

    /**
     * Returns a contract at a specific index in the repository
     *
     * @param index of the contract
     * @return an Optional with the specified present non-null value.
     */
    public Optional<T> getbyIndex(int index) {
        return Optional.of(this.arr[index]);
    }
}

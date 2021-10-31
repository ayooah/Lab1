import Models.Contract;

import java.util.Optional;
/**
 * ArrayRepository class is a dynamically expanding array that implements the {@code Repository} interface
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
    /**
     * Constructs a repository of initional size
     */
    public ArrayRepository() {
        this.arr = (T[]) new Contract[initionalSize];
        this.length=initionalSize;
    }
    /**
     * @return count of not null element in repository
     */
    public int getSize() {
        return size;
    }
    /**
     * Appends a contract to the end of the repository
     * @param contract added to the repository
     */
    public void add(T contract) {
        if (this.size >= this.length) {
            this.length*=2;
            T[] prevArr = this.arr;
            this.arr = (T[]) new Contract[this.length];
            System.arraycopy(prevArr, 0, this.arr, 0, this.size);
        }
        this.arr[size] = contract;
        size++;
    }
    /**
     * Appends array of contracts to the end of the repository
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
     * Returns a contract with a specific id from the repository
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
     * @param index of the contract
     * @return an Optional with the specified present non-null value.
     */
    public Optional<T> getbyIndex(int index) {
        return Optional.of(this.arr[index]);
    }
}

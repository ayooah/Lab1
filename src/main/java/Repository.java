import java.util.Optional;
/**
 * Repository interface contains the main methods for processing data in the repository
 * @param <T> the type of elements in this repository
 * @autor Anna Ushakova
 */
public interface Repository<T> {
    void add(T contract);
    boolean removeById(int id);
    T getbyId(int id);
    int getSize();
    boolean addArr(T[] arr);
    Optional<T> getbyIndex(int index);
    void removeByIndex(int index);

}

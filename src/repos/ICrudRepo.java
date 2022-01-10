package repos;

import java.util.List;

public interface ICrudRepo<T> {
    /**
     * Gets all objects in the database
     * @return list of all objects in database
     */
    List<T> getAll();
}

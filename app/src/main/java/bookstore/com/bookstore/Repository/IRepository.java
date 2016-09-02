package bookstore.com.bookstore.Repository;

import java.util.Set;

/**
 * Created by AbelN on 01/09/2016.
 */
public interface IRepository <E,ID>{
    E findById(ID id);

    E add(E entity);

    E update(E entity);

    E remove(E entity);

    Set<E> findAll();

    int removeAll();
}


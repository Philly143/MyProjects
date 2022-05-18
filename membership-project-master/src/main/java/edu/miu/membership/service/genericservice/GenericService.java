package edu.miu.membership.service.genericservice;

import java.io.Serializable;
import java.util.List;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/17/22
 */
public interface GenericService<T> {
    List<T> findAll();

    T save(T t);

    T getById(Long id);

    void deleteById(Long id);
}

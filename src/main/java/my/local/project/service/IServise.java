package my.local.project.service;

import java.util.List;

public interface IServise<T> {
    List<T> findAll();
    T findById(Long id);
    T save(T element);
    void delete(T element);
    void deleteByID(Long id);
    void deleteAll(List<T> elements);
}

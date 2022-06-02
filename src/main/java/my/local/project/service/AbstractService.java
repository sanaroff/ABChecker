package my.local.project.service;

import my.local.project.repository.EventJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractService <T, R extends JpaRepository<T, Long>>  implements IServise <T>{

    R repository;

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public T save(T element) {
        return repository.save(element);
    }

    @Override
    public void delete(T element) {
        repository.delete(element);
    }

    @Override
    public void deleteByID(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll(List<T> elements) {
        repository.deleteAll(elements);
    }
}

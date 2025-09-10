package dao;

import java.util.List;
import exception.DAOException;

public interface RepositoryDAO<T> {
    Long insert(T o) throws DAOException;
    void update(T o) throws DAOException;
    void delete(Long Id) throws DAOException;
    T findById(Long Id) throws DAOException;
    List<T> findAll() throws DAOException;
}
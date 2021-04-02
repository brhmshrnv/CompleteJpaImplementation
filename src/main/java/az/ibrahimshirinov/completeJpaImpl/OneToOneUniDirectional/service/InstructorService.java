package az.ibrahimshirinov.completeJpaImpl.OneToOneUniDirectional.service;

import az.ibrahimshirinov.completeJpaImpl.OneToOneUniDirectional.model.Instructor;

import java.util.List;

public interface InstructorService {

    Instructor save(Instructor instructor);
    Instructor findById(Long id);
    List<Instructor> findAll();
    Instructor update(Long id, Instructor instructor);
    void delete(Long id);
}

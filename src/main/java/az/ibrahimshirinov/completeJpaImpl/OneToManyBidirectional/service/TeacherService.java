package az.ibrahimshirinov.completeJpaImpl.OneToManyBidirectional.service;

import az.ibrahimshirinov.completeJpaImpl.OneToManyBidirectional.model.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher save(Teacher teacher);
    Teacher findById(Long id);
    List<Teacher> findAll();
    Teacher update(Long id,Teacher teacher);
    void delete(Long id);
}

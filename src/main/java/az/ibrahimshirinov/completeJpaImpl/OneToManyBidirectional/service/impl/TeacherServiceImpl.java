package az.ibrahimshirinov.completeJpaImpl.OneToManyBidirectional.service.impl;

import az.ibrahimshirinov.completeJpaImpl.OneToManyBidirectional.model.Teacher;
import az.ibrahimshirinov.completeJpaImpl.OneToManyBidirectional.repository.TeacherRepository;
import az.ibrahimshirinov.completeJpaImpl.OneToManyBidirectional.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher findById(Long id) {

        Optional<Teacher> optional = teacherRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found teacher with id="+ id);
        }

    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher update(Long id, Teacher teacher) {

        Optional<Teacher> optional = teacherRepository.findById(id);

        if (optional.isPresent()) {
            return teacherRepository.save(teacher);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cant update teacher with id="+id);
        }
    }

    @Override
    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }
}

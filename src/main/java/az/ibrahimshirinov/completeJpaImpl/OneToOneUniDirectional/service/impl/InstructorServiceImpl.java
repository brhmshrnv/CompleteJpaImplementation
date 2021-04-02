package az.ibrahimshirinov.completeJpaImpl.OneToOneUniDirectional.service.impl;

import az.ibrahimshirinov.completeJpaImpl.OneToOneUniDirectional.model.Instructor;
import az.ibrahimshirinov.completeJpaImpl.OneToOneUniDirectional.repository.InstructorRepository;
import az.ibrahimshirinov.completeJpaImpl.OneToOneUniDirectional.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    private final InstructorRepository instructorRepository;

    @Override
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor findById(Long id) {

        Optional<Instructor> optional = instructorRepository.findById(id);

        if (optional.isPresent()){
            return optional.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Cant find Instructor with id=" + id);
        }

    }

    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor update(Long id, Instructor instructor) {

        Optional<Instructor> optional = instructorRepository.findById(id);

        if (optional.isPresent()){
            return instructorRepository.save(instructor);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cant update Instructor with id=" + id);
        }
    }

    @Override
    public void delete(Long id) {
        instructorRepository.deleteById(id);
    }
}

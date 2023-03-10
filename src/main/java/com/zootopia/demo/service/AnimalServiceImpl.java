package com.zootopia.demo.service;

import java.util.List;
import java.util.Optional;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zootopia.demo.entity.Animal;
import com.zootopia.demo.repository.AnimalRepository;

@Service
public class AnimalServiceImpl implements BaseService<Animal> {

    private AnimalRepository repository;

    public AnimalServiceImpl(AnimalRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Animal> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Animal update(Animal existingAnimal, Animal updatedAnimal) {
        existingAnimal.setName(updatedAnimal.getName());
        existingAnimal.setDate(updatedAnimal.getDate());
        return repository.save(existingAnimal);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Animal> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Animal> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Animal save(Animal animal) {
        return repository.save(animal);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
}

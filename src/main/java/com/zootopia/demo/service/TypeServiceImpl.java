package com.zootopia.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zootopia.demo.entity.Type;
import com.zootopia.demo.repository.TypeRepository;

@Service
public class TypeServiceImpl implements BaseService<Type> {

    private TypeRepository repository;

    public TypeServiceImpl(TypeRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Type> findAll() {

        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Type> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Type> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Type update(Type existingType, Type updatedType) {
        existingType.setType(updatedType.getType());
        return repository.save(existingType);
    }

    @Transactional
    @Override
    public Type save(Type type) {
        return repository.save(type);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
}

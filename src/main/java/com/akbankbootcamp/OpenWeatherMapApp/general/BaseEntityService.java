package com.akbankbootcamp.OpenWeatherMapApp.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class BaseEntityService<E extends BaseEntity, R extends JpaRepository<E, Long>>{

    private final R repository;

    @Autowired
    public BaseEntityService(R repository) {
        this.repository = repository;
    }

    public E save(E entity){

        System.out.println("Test16");
        BaseAdditionalFields baseAdditionalFields = entity.getBaseAdditionalFields();
        if (baseAdditionalFields == null){
            baseAdditionalFields = new BaseAdditionalFields();
        }

        if (entity.getId()  == null){
            baseAdditionalFields.setCreateDate(LocalDateTime.now());
            //baseAdditionalFields.setCreatedBy(0L);
        }

        baseAdditionalFields.setUpdateDate(LocalDateTime.now());
        //baseAdditionalFields.setUpdatedBy(0L);

        entity.setBaseAdditionalFields(baseAdditionalFields);
        entity = repository.save(entity);
        System.out.println("Test17");

        return entity;
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public void delete(E entity){
        repository.delete(entity);
    }

    public Optional<E> findById(Long id){
        return repository.findById(id);
    }

    public E findByIdWithControl(Long id){
        return repository.findById(id).orElseThrow();
    }

    public boolean isExist(Long id){
        return repository.existsById(id);
    }
    public R getRepository() {
        return repository;
    }

}

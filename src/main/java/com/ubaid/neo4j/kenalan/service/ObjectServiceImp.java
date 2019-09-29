package com.ubaid.neo4j.kenalan.service;

import com.ubaid.neo4j.kenalan.entity.Object;
import com.ubaid.neo4j.kenalan.repository.ObjectRepository;
import com.ubaid.neo4j.kenalan.service.def.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectServiceImp implements ObjectService {

    private ObjectRepository objectRepository;

    public ObjectServiceImp(@Autowired ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    @Override
    public Object save(Object object) {
        return objectRepository.save(object);
    }
}

package com.core.mongo.repo;

import com.core.mongo.entity.Emp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends MongoRepository<Emp, String> {

    Optional<Emp> findByEmpno(Integer empno);


}

package com.core.mongo.repo;

import com.core.mongo.entity.Dept;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepo extends MongoRepository<Dept, String> {

    Optional<Dept> findByDeptNo(Integer deptno);
}

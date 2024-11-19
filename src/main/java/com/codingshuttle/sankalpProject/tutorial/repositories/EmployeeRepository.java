package com.codingshuttle.sankalpProject.tutorial.repositories;

import com.codingshuttle.sankalpProject.tutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}

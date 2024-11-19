package com.codingshuttle.sankalpProject.tutorial.services;

import com.codingshuttle.sankalpProject.tutorial.dto.EmployeeDTO;
import com.codingshuttle.sankalpProject.tutorial.entities.EmployeeEntity;
import com.codingshuttle.sankalpProject.tutorial.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {


    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id){
         EmployeeEntity employeeEntity = employeeRepository.getById(id);

        return modelMapper.map(employeeEntity,EmployeeDTO.class);
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO){
        EmployeeEntity employeeEntity=modelMapper.map(employeeDTO,EmployeeEntity.class);
        return modelMapper.map(employeeRepository.saveAndFlush(employeeEntity),EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees(){
       return employeeRepository.findAll()
               .stream()
               .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class)).collect(Collectors.toList());

    }

    public boolean deleteEmployee(Long id){
        boolean isPresent = employeeRepository.existsById(id);
        if(!isPresent) {
            return false;
        }
        employeeRepository.deleteById(id);
        return true;
    }
}

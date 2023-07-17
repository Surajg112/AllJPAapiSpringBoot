package com.csi.controller;

import com.csi.constants.EndPointConstants;
import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import com.csi.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping(EndPointConstants.SIGN_UP)
    public ResponseEntity<String> signUp(@Valid @RequestBody Employee employee) {

        employeeServiceImpl.signUp(employee);
        return new ResponseEntity<>("SIGNUP DONE sucessfully", HttpStatus.CREATED);

    }

    @GetMapping(EndPointConstants.SIGN_IN)
    public ResponseEntity<String> signIn(@PathVariable String empEmailId, @PathVariable String empPassword) {
        boolean flag = employeeServiceImpl.signIn(empEmailId, empPassword);
        if (flag == true) {
            return ResponseEntity.ok("SIGN IN DONE sucessfully");
        } else {
            return ResponseEntity.ok("Invalid emaild or password");
        }
    }

    @PostMapping(EndPointConstants.SAVE_BULK_OF_DATA)
    public ResponseEntity<String> saveBulkOfData(@RequestBody List<Employee> employees) {
        employeeServiceImpl.SaveBulkOfData(employees);
        return new ResponseEntity<>("ALL DATAs SAVED", HttpStatus.CREATED);

    }

    @Cacheable(value = "empId")
    @GetMapping(EndPointConstants.GET_DATA_BY_ID)
    public Optional<Employee> getDataById(@PathVariable int empId) {

        log.info("########---- getting data for id: "+empId);
        return employeeServiceImpl.getDataById(empId);

    }

    @GetMapping(EndPointConstants.GET_DATA_BY_EMAIL_ID)
    public ResponseEntity<Employee> getDataByEmailId(@PathVariable String empEmailId) {
        return ResponseEntity.ok(employeeServiceImpl.getDataByEmailId(empEmailId));

    }

    @GetMapping(EndPointConstants.GET_ALL_DATA)
    public ResponseEntity<List<Employee>> getAllData() {
        return ResponseEntity.ok(employeeServiceImpl.getAllData());

    }

    @GetMapping(EndPointConstants.GET_DATA_BY_NAME)
    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String empName) {
        return ResponseEntity.ok(employeeServiceImpl.getDataByName(empName));

    }

    @GetMapping(EndPointConstants.GET_DATA_BY_CONTACT_NUMBER)
    public ResponseEntity<Employee> getDataByContactNumber(@PathVariable long empContactNumber) {
        return ResponseEntity.ok(employeeServiceImpl.getDataByContactNumber(empContactNumber));

    }

    @GetMapping(EndPointConstants.GET_DATA_BY_DOB)
    public ResponseEntity<List<Employee>> getDataByDOB(@PathVariable String empDOB) {
        return ResponseEntity.ok(employeeServiceImpl.getDataByUsingDOB(empDOB));

    }

    @GetMapping(EndPointConstants.GET_DATA_BY_ANY_INPUT)
    public ResponseEntity<List<Employee>> getDataByAnyInput(@PathVariable String input) {
        return ResponseEntity.ok(employeeServiceImpl.getDataByUsingAnyInput(input));

    }

    @GetMapping(EndPointConstants.SORT_BY_ID)
    public ResponseEntity<List<Employee>> sortById() {
        return ResponseEntity.ok(employeeServiceImpl.sortById());

    }

    @GetMapping(EndPointConstants.SORT_BY_NAME)
    public ResponseEntity<List<Employee>> sortByName() {
        return ResponseEntity.ok(employeeServiceImpl.sortByName());

    }

    @GetMapping(EndPointConstants.SORT_BY_SALARY)
    public ResponseEntity<List<Employee>> sortBySalary() {
        return ResponseEntity.ok(employeeServiceImpl.sortBySalary());

    }

    @GetMapping(EndPointConstants.SORT_BY_DOB)
    public ResponseEntity<List<Employee>> sortByDOB() {
        return ResponseEntity.ok(employeeServiceImpl.sortByDOB());

    }

    @GetMapping(EndPointConstants.FILTER_DATA_BY_SALARY)
    public ResponseEntity<List<Employee>> filterDataBySalary(@PathVariable double empSalary) {
        return ResponseEntity.ok(employeeServiceImpl.filterDataBySalary(empSalary));

    }

    @GetMapping(EndPointConstants.CHECK_LOAN_ELIGIBILTY)
    public ResponseEntity<String> checkLoanEligibilty(@PathVariable int empId) {

        if (employeeServiceImpl.checkLoanEligibility(empId)) {
            return ResponseEntity.ok("YES, ELIGIBLE FOR LOAN");

        } else {
            return ResponseEntity.ok("NOT ELIGIBLE FOR LOAN");
        }

    }


    @PutMapping(EndPointConstants.UPDATE_DATA_BY_ID)
    public ResponseEntity<String> updateDataById(@PathVariable int empId,@Valid @RequestBody Employee employee){
       Employee employee1 = employeeServiceImpl.getDataById(empId).orElseThrow(()-> new RecordNotFoundException("ID DOES NOT EXIST"));

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpPassword(employee.getEmpPassword());


        employeeServiceImpl.updateDataById(empId,employee1);
        return new ResponseEntity<>("data UPDATED SUCCESSFULLY",HttpStatus.CREATED);

    }

    @DeleteMapping(EndPointConstants.DELETE_DATA_BY_ID)
    public ResponseEntity<String> deleteDataById(@PathVariable int empId){
        employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok("data deleted sucessfully");

    }

    @DeleteMapping(EndPointConstants.DELETE_ALL_DATA)
    public ResponseEntity<String> deleteAllData(){
        employeeServiceImpl.deleteAllData();
        return ResponseEntity.ok("ALL data DELETED");

    }

}

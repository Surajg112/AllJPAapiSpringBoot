package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepository employeeRepositoryImpl;

    public void signUp(Employee employee) {
        employeeRepositoryImpl.save(employee);

    }

    /*public boolean signIn(String empEmailId, String empPassword) {
        boolean flag = false;
        for (Employee employee : getAllData()) {
            if (employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)) {
                flag = true;
                break;
            }
        }
        return flag;

    }*/

    public void SaveBulkOfData(List<Employee> employees) {
        employeeRepositoryImpl.saveAll(employees);
    }

    public Optional<Employee> getDataById(int empId) {
        return employeeRepositoryImpl.findById(empId);

    }

    /*public Employee getDataByEmailId(String empEmailId) {
        return getAllData().stream().filter(emp -> emp.getEmpEmailId().equals(empEmailId)).
                collect(Collectors.toList()).get(0);

    }*/

    public List<Employee> getAllData() {
        return employeeRepositoryImpl.findAll();
    }

    /*public List<Employee> getDataByName(String empName) {
        return getAllData().stream().filter(emp -> emp.getEmpName().equals(empName)).
                collect(Collectors.toList());
    }*/

   /* public Employee getDataByContactNumber(long empContactNumber) {
        return getAllData().stream().filter(emp -> emp.getEmpContactNumber() == empContactNumber).
                collect(Collectors.toList()).get(0);

    }*/

   /* public List<Employee> getDataByUsingDOB(String empDOB) {

        List<Employee> employeeList = new ArrayList<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        for (Employee employee : getAllData()) {
            String newDOB = simpleDateFormat.format(employee.getEmpDOB());
            if (newDOB.equals(empDOB)) {
                employeeList.add(employee);
            }
        }
        return employeeList;

    }*/

   /* public List<Employee> getDataByUsingAnyInput(String input) {

        List<Employee> employeeList = new ArrayList<>();

        for (Employee employee : getAllData()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            if (employee.getEmpName().equals(input)
                    || employee.getEmpEmailId().equals(input)
                    || employee.getEmpAddress().equals(input)
                    || String.valueOf(employee.getEmpId()).equals(input)
                    || String.valueOf(employee.getEmpContactNumber()).equals(input)
                    || String.valueOf(employee.getEmpDOB()).equals(input)) {

                employeeList.add(employee);
            }
        }
        return employeeList;
    }*/

   /* public List<Employee> sortById() {

        return getAllData().stream().sorted(Comparator.comparingInt(Employee::getEmpId)).collect(Collectors.toList());

    }*/

   /* public List<Employee> sortByName() {

        return getAllData().stream().sorted(Comparator.comparing(Employee::getEmpName)).collect(Collectors.toList());

    }
*/
   /* public List<Employee> sortBySalary() {

        return getAllData().stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary)).collect(Collectors.toList());

    }*/

   /* public List<Employee> sortByDOB() {

        return getAllData().stream().sorted(Comparator.comparing(Employee::getEmpDOB)).collect(Collectors.toList());

    }*/

   /* public List<Employee> filterDataBySalary(double empSalary) {

        return getAllData().stream().filter(emp -> emp.getEmpSalary() >= empSalary).collect(Collectors.toList());
    }
*/
 /*   public boolean checkLoanEligibility(int empId) {

        boolean flag = false;
        for (Employee employee : getAllData()) {
            if (employee.getEmpId() == empId && employee.getEmpSalary() >= 50000) {
                flag = true;
                break;
            }

        }
        return flag;

    }*/

    public void UpdateDataById(int empId, Employee employee) {
        employeeRepositoryImpl.save(employee);

    }

    public void DeleteDataById(int empId) {
        employeeRepositoryImpl.deleteById(empId);

    }

    public void DeleteAllData() {
        employeeRepositoryImpl.deleteAll();

    }

}

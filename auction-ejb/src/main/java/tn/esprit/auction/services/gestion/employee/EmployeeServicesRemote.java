package tn.esprit.auction.services.gestion.employee;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.auction.domain.Employee;

@Remote
public interface EmployeeServicesRemote {
Boolean addEmployee(Employee employee);
Boolean updateEmployee(Employee employee);
Boolean deleteEmployee(Employee employee);
Employee findEmployeeById(Integer idEmployee);
List<Employee> findAllEmployeeByName(String name);
List<Employee> findAllEmployee();
}

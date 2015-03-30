package tn.esprit.auction.services.gestion.employee;

import java.util.List;

import javax.ejb.Stateless;

import tn.esprit.auction.domain.Employee;

/**
 * Session Bean implementation class EmployeeServices
 */
@Stateless
public class EmployeeServices implements EmployeeServicesRemote, EmployeeServicesLocal {

    /**
     * Default constructor. 
     */
    public EmployeeServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addEmployee(Employee employee) {
		try{
			//traitement
			return true;
		}catch(Exception exception){
			return false;
		}
	}

	@Override
	public Boolean updateEmployee(Employee employee) {
		try{
			//traitement
			return true;
		}catch(Exception exception){
			return false;
		}
	}

	@Override
	public Boolean deleteEmployee(Employee employee) {
		try{
			//traitement
			return true;
		}catch(Exception exception){
			return false;
		}
	}

	@Override
	public Employee findEmployeeById(Integer idEmployee) {
		Employee employee = null;
		try{
			//traitement
			return employee;
		}catch(Exception exception){
			return null;
	}
	}

	@Override
	public List<Employee> findAllEmployeeByName(String name) {
	return null;
	}
	

	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

}

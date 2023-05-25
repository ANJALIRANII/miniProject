package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

import com.org.Department;
import com.org.Emploee;

import custom_exception.EmployeeHandlingException;

public class EmployeeValidationRules {

	public static Emploee parseAllInput(String id, String firstName, String lastName, String dept, String date,
			double salary, Map<String, Emploee> employee) throws EmployeeHandlingException {
		checkForDup(employee, id);
		LocalDate validDate = parsejoinDate(date);
		Department validdept = parsedept(dept);
		return new Emploee(id, firstName, lastName, validdept, validDate, salary);

	}

	public static Department parsedept(String dept) {
		return Department.valueOf(dept.toUpperCase());
	}

	public static LocalDate parsejoinDate(String date) throws EmployeeHandlingException {
		LocalDate joinDate = LocalDate.parse(date);
		int diffInYears = Period.between(joinDate, LocalDate.now()).getYears();
		if (diffInYears > 3)
			throw new EmployeeHandlingException("invalid adte");
		return joinDate;
	}

	public static void checkForDup(Map<String, Emploee> employee, String id) throws EmployeeHandlingException {
		if (employee.containsKey(id))
			throw new EmployeeHandlingException("duplicate id");
		System.out.println("no duplicate..");

	}

}

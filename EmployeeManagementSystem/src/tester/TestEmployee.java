package tester;

import static utils.EmployeeValidationRules.parseAllInput;
import static utils.IOUtils.restoreEmpDetails;
import static utils.IOUtils.storeEmpDetails;

import java.util.Map;
import java.util.Scanner;

import com.org.Emploee;

public class TestEmployee {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter filename");
			String FileName = sc.next();
			Map<String, Emploee> empMap = restoreEmpDetails(FileName);
			System.out.println("file restored" + empMap);
			boolean exit = false;
			while (!exit) {
				System.out.println("1.hire emp 2.display emp details 0.exit");
				try {
					switch (sc.nextInt()) {
					case 1:
//						private String id;
//						private String firstName;
//						private String lastName;
//						private Department dept;
//						private LocalDate date;
//						private double salary;
						System.out.println("Enter employee details : id firstname lastname dept date salary");
						Emploee validInput = parseAllInput(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), empMap);
						empMap.put(validInput.getId(), validInput);
						System.out.println("employee get hired");

						break;
					case 2:
						System.out.println("Display emp details");
						empMap.forEach((k, v) -> System.out.println(v));
						break;
					case 0:
						exit = true;
						storeEmpDetails(empMap, FileName);
						System.out.println("file stored");
						break;

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

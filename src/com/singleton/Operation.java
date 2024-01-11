package com.singleton;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Operation {
	static List<Employee> emp = new ArrayList<>();

	public static void main(String[] args) {
		emp.add(new Employee(111, "Jiya Brain", 32, "Female", "HR", 2011, 23000.0));
		emp.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales and Marketing", 2015, 13500.0));
		emp.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 10000.0));
		emp.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		emp.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		emp.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 1050000.0));
		emp.add(new Employee(177, "Manu Sharma", 35, "Male", "Account and Finance", 2010, 27000.0));
		emp.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 22700.0));
		emp.add(new Employee(199, "Amelis Zoe", 24, "Female", "Sales and Marketing", 2016, 11500.0));
		emp.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.0));
		emp.add(new Employee(211, "Jasna kaun", 27, "Female", "Infrastructure", 2014, 15700.0));
		emp.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		emp.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account and Finance", 2013, 21300.0));
		emp.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales and Marketing", 2017, 10700.0));
		emp.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastrcutre", 2018, 12700.0));
		emp.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		emp.add(new Employee(277, "Anuj Chattiar", 31, "Male", "Product Development", 2012, 35700.0));
		// Query 1 := HOw many Male and Female employee are there in the organization.
		Map<String, Long> emp1 = emp.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(emp1);
		// Query2:- Print the name of all department in the organization.
		emp.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
		// Query3:- What is the average age of male and female employee.
		Map<String, Double> emp2 = emp.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println(emp2);
		// Query 4 :- Get the details of highest paid in the organization.
		Optional<Employee> emp5 = emp.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println(emp5.get().getName());
		// Query 5:- Get the name of all employee who joined after 2015.
		emp.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);
		// Query 6:- Count the number of employee in each department.
		Map<String, Long> emp56 = emp.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(emp56);
		// Query7:- What is average salary of each department.
		Map<String, Double> emp67 = emp.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(emp67);
		// Query 8:- Get the details of youngest male employee in the product
		// development department.
		emp.stream().filter(e -> e.getDepartment() == "Product Development" && e.getGender() == "Male")
				.min(Comparator.comparing(Employee::getAge));
		// Query 9:- Who has most working experience in the organization.
		emp.stream().sorted(Comparator.comparing(Employee::getYearOfJoining));
		// Query 10:- how many male and female employee are there in the sales and
		// marketing team.
		emp.stream().filter(e -> e.getDepartment().equalsIgnoreCase("Sales and Marketing"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		// Query 11:- what is average salary of male and female employee.
		emp.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		// Query 12 :- List down all the employee in each department.
		emp.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		// Query 13:- what is average salary and total salary of the whole organization.
		DoubleSummaryStatistics emp89 = emp.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println(emp89.getSum());
		System.out.println(emp89.getAverage());
		// Query 14:- Separate employee who are younger or equal to 25 years from those
		// employee who are older than 25.
		Map<Boolean, List<Employee>> emp675 = emp.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));
		Set<Entry<Boolean, List<Employee>>> entryset = emp675.entrySet();
		for (Entry<Boolean, List<Employee>> entry : entryset) {
			System.out.println("========");
			if (entry.getKey()) {
				System.out.println("Employee older than 25 years");
			} else {
				System.out.println("Employee are not older than 25 years");
			}
		}
		// Query 15 :- who is oldest employee in the organization what is his age and
		// which department be belongs to.
		Optional<Employee> emp43 = emp.stream().max(Comparator.comparing(Employee::getAge));
		System.out.println(emp43.get().getName());
		System.out.println(emp43.get().getAge());
		System.out.println(emp43.get().getDepartment());
	}
}

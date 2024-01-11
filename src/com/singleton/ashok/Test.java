package com.singleton.ashok;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		List<Employee> lst = new ArrayList<>();
		lst.add(new Employee(1, "Jhansi", 32, "Female", "HR", 2011, 25000.00));
		lst.add(new Employee(2, "Smith", 25, "Male", "Sales", 2015, 13500.00));
		lst.add(new Employee(3, "David", 29, "Male", "Infrastructure", 2012, 18000.00));
		lst.add(new Employee(4, "orlen", 28, "Male", "Development", 2014, 32500.00));
		lst.add(new Employee(5, "charles", 27, "Male", "HR", 2013, 22700.00));
		lst.add(new Employee(6, "cathy", 43, "Male", "Secuirty", 2016, 10500.00));
		lst.add(new Employee(7, "Ramesh", 35, "Male", "Finanace", 2010, 27000.00));
		lst.add(new Employee(8, "Suresh", 31, "Male", "Development", 2015, 34500.00));
		lst.add(new Employee(9, "Gita", 24, "Female", "Sales", 2016, 11500.00));
		lst.add(new Employee(10, "Mahesh", 38, "Male", "Secuirty", 2015, 11000.00));
		lst.add(new Employee(11, "Gouri", 27, "Female", "Infrastructure", 2014, 15700.00));
		lst.add(new Employee(12, "Nithin", 25, "Male", "Development", 2016, 28200.00));
		lst.add(new Employee(13, "Swathi", 27, "Female", "Finanace", 2013, 21300.00));
		lst.add(new Employee(14, "Buttler", 24, "Male", "Sales", 2017, 10700.00));
		lst.add(new Employee(15, "Ashok", 23, "Male", "Infrastructure", 2018, 12700.00));
		lst.add(new Employee(16, "Sanvi", 26, "Female", "Development", 2015, 28900.00));

		// Quer1:- HOw many male and female employee are there in the organization.
		/*
		 * Map<String, Long> st = lst.stream().collect(Collectors.groupingBy(e ->
		 * e.getGender(), Collectors.counting())); System.out.println(st); // Query2:-
		 * Print the name of all department in organization. lst.stream().map(e ->
		 * e.getDepartment()).distinct().forEach(e -> System.out.println(e)); //
		 * query3:- Average age of male and female emp. Map<String, Double> srd =
		 * lst.stream() .collect(Collectors.groupingBy(Employee::getGender,
		 * Collectors.averagingInt(Employee::getAge))); System.out.println(srd); //
		 * Query4:- highest paid employ in org. Optional<Employee> option =
		 * lst.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::
		 * getSalary))); System.out.println(option);
		 * 
		 * lst.stream().filter(e -> e.getYearOfjoining() > 2015).map(Employee::getName)
		 * .forEach(e -> System.out.println(e)); // Query 5:- number of emp each depart.
		 * Map<String, Long> str = lst.stream()
		 * .collect(Collectors.groupingBy(Employee::getDepartment,
		 * Collectors.counting())); System.out.println(str);
		 * 
		 * // Query 6: avg sal of each depart Map<String, Double> mape =
		 * lst.stream().collect( Collectors.groupingBy(Employee::getDepartment,
		 * Collectors.averagingDouble((Employee::getSalary))));
		 * System.out.println(mape);
		 */
		// Query 7:- get the details of youngest male employeein the development
		// department.
		/*
		 * Optional<Employee> ere=
		 * lst.stream().filter(e->e.getGender()=="Male").filter(e->e.getDepartment()==
		 * "Development").collect(Collectors.minBy(Comparator.comparing(Employee::getAge
		 * ))); System.out.println(ere);
		 */
		// Query 8:- who is the most working experience in
		/*
		 * Optional<Employee> name=
		 * lst.stream().min(Comparator.comparing(Employee::getYearOfjoining));
		 * 
		 * lst.stream().filter(e->e.getDepartment().equals("Sales")).collect(Collectors.
		 * groupingBy(Employee::getGender,Collectors.counting()));
		 */// Query 9:-average sal of male and female emp.
		// lst.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst();
		// lst.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
		// Query 10 :- list down then names of all employee in each department.
		Map<String, List<Employee>> strt = lst.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		Set<Entry<String,List<Employee>>> ser=strt.entrySet();
		for (Entry<String, List<Employee>> entry : ser) {
			System.out.println(entry.getValue());
			
		}
//Query 11:- average sal and total sal of the whole organization.
		// Query 12:- who is the oldest employee in the organization what is his age and
		// which department he belongs.
	}
}

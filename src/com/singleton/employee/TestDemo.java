package com.singleton.employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestDemo {
	public static void main(String[] args) {
		Employee e1 = new Employee("John", 35, 55000.00);
		Employee e2 = new Employee("David", 25, 45000.00);
		Employee e3 = new Employee("Buttler", 35, 35000.00);
		Employee e4 = new Employee("Steve", 45, 65000.00);

		Stream<Employee> stream = Stream.of(e1, e2, e3, e4);
		stream.filter(e -> e.salary >= 50000).map(e -> e.name + "-" + e.age).forEach(e -> System.out.println(e));

		List<Employee> emp = Arrays.asList(e1, e2, e3, e4);

		Optional<Employee> emp2 = emp.stream().collect(Collectors.maxBy(Comparator.comparing(e -> e.salary)));
		System.out.println(emp2.get().salary);

		Optional<Employee> emp4 = emp.stream().collect(Collectors.minBy(Comparator.comparing(e -> e.salary)));
		System.out.println(emp4.get().salary);

		Double emp6 = emp.stream().collect(Collectors.averagingDouble(e -> e.salary));
		System.out.println(emp6);
	}
}

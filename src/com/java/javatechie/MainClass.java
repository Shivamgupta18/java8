package com.java.javatechie;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
	public static void main(String[] args) {
		List<Student> studentmap = Stream.of(
				new Student(1, "Shivam", 23, "Male", "ECE", "Kanpur", 23,
						Arrays.asList("+918770391138", "+918545048073", "+7654367854")),
				new Student(2, "Neha", 24, "Female", "CSE", "Kanpur", 52,
						Arrays.asList("+918770391138", "+918545048073", "+7654367854")),
				new Student(3, "manu", 25, "Female", "CE", "Kanpur", 34,
						Arrays.asList("+918770391138", "+918545048073", "+7654367854")),
				new Student(4, "Nisha", 26, "Male", "EEE", "Baliya", 423,
						Arrays.asList("+918770391138", "+918545048073", "+7654367854")),
				new Student(5, "Pratibha", 27, "Female", "CSE", "Allahabad", 78,
						Arrays.asList("+918770391138", "+918545048073", "+7654367854")),
				new Student(6, "Payal", 28, "Male", "MEE", "Kanpur", 12,
						Arrays.asList("+918770391138", "+918545048073", "+7654367854")),
				new Student(7, "Khushi", 29, "Female", "IT", "Kanpur", 230,
						Arrays.asList("+918770391138", "+918545048073", "+7654367854")),
				new Student(8, "namita", 30, "Male", "EEE", "Kanpur", 46,
						Arrays.asList("+918770391138", "+918545048073", "+7654367854")))
				.collect(Collectors.toList());
		// System.out.println(studentmap);

		List<Student> str = studentmap.stream().filter(e -> e.getRank() > 20 & e.getRank() < 100)
				.collect(Collectors.toList());
//	System.out.println(str);

		// find the student who stays in kanpur and sort their by name
		List<Student> sty = studentmap.stream().filter(e -> e.getCity().equalsIgnoreCase("Kanpur"))
				.sorted(Comparator.comparing(Student::getFirstName)).collect(Collectors.toList());
		// System.out.println(sty);
		// find all the dept.
		studentmap.stream().map(Student::getDept).distinct().forEach(System.out::println);

		studentmap.stream().flatMap(e -> e.getContacts().stream()).forEach(System.out::println);

		// Group the student by department name.
		Map<String, Long> stf = studentmap.stream().collect(Collectors.groupingBy(Student::getDept,Collectors.counting()));
		//System.out.println(stf);
		//average age of male and female emp.
	Map<String, Double> mapinteger=studentmap.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.averagingDouble(Student::getAge)));
	//  System.out.println(mapinteger);
	  
	  // find highest rank in each department.
	Map<String, Optional<Student>> sde=  studentmap.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.maxBy(Comparator.comparing(Student::getRank))));
	  //System.out.println(sde);mapinteger
	  // second rank
	Student se=  studentmap.stream().sorted(Comparator.comparing(Student::getRank).reversed()).skip(1).findFirst().get();
	System.out.println(se);
	}
}

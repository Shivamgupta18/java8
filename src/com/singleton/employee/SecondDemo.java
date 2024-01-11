package com.singleton.employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SecondDemo {
	public static void main(String[] args) {
		List<String> java = Arrays.asList("core java", "adv java", "spring boot");
		List<String> ul = Arrays.asList("html","css","js","bs");
	List<List<String>> cpourses=Arrays.asList(java,ul);
	cpourses.stream().forEach(c->System.out.println(c));
	   Stream<String> fms=cpourses.stream().flatMap(s->s.stream());
			  fms.forEach(e->System.out.println(e));
	
	
	}
}

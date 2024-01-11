package com.singleton.employee;

import java.util.Arrays;
import java.util.List;

public class ThirdDemo {
	public static void main(String[] args) {
          List<String> aspect=Arrays.asList("Hello", "Spring boot", "Microservices","Ankita","Anshu");
          
          aspect.stream().filter(e->e.startsWith("A")).map(e->e.length()).forEach(e->System.out.println(e));
	}
}

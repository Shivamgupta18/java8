package com.singleton;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class start {
	public static void main(String[] args) {
		System.out.println("Hello World");
		List<String> lst = Arrays.asList("430", "760", "980", "420", "4", "40", "400");

		List<String> st = lst.stream().filter(e -> e.startsWith("4")).collect(Collectors.toList());
		System.out.println(st);

		System.out.println("==============Odd and Even Number========");
		List<Integer> ls = Arrays.asList(439, 760, 980, 421, 4, 43, 400);
		List<Integer> lsr = ls.stream().filter(r -> r % 2 == 0).collect(Collectors.toList());
		System.out.println(lsr);
	}
}

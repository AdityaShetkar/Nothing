package java8;

import java.util.Arrays;
import java.util.List;

public class NoStartingWith1 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,12,8,1345,7,13,88,68,19);
		list.stream()
			.map(s->s+"") //Convert integer to string
			.filter(s->s.startsWith("1"))
			.forEach(System.out::println);
	}
}

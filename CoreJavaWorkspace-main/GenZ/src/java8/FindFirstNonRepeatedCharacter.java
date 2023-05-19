package java8;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRepeatedCharacter {
	public static void main(String[] args) {
		String input = "Java Hungry Blog Alive is Awesome";

//		for(char i : input.toCharArray()) {
//		if (input.indexOf(i) == input.lastIndexOf(i)) {
//			System.out.println("First non-repeating character is : " + i);
//			break;
//		}	
//		}

		Character result = input.chars() // Stream of String
				.mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object
																					// and then to lowercase
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet()
				.stream()
				.filter(entry -> entry.getValue() == 1L)
				.map(entry -> entry.getKey())
				.findFirst()
				.get();
		System.out.println(result);
	}

}

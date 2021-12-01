package Classes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Data {

	public Data() {
		// TODO Auto-generated constructor stub
	}

	public static List<Person> main(String[] args) {
		 int nb = 0;
		return IntStream.rangeClosed(1,nb)
	                .mapToObj(i -> new Person("first_" + i, "last_" + i, i, i % 9 == 0 ? "test": "password"+i))
	                .collect(Collectors.toList());

	}

	public static List<Person> buildPersonList(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}

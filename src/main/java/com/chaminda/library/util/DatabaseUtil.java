package com.chaminda.library.util;

import java.util.HashMap;
import java.util.Map;

import com.chaminda.library.domain.Library;

public class DatabaseUtil {

	/**
	 * This operation returns collection of libraries to be initialised.
	 * 
	 * @return map of libraries.
	 */
	public static Map<String, Library> loadInitialData() {

		Map<String, Library> map = new HashMap<String, Library>();
		Library test = new Library();
		test.setId(1L);
		test.setName("Logan");
		test.setWeighting(10);
		map.put(test.getName(), test);

		Library test1 = new Library();
		test1.setId(2L);
		test1.setName("Gold Coast");
		test1.setWeighting(30);
		map.put(test1.getName(), test1);

		Library test2 = new Library();
		test2.setId(3L);
		test2.setName("Toowomba");
		test2.setWeighting(20);
		map.put(test2.getName(), test2);

		Library test3 = new Library();
		test3.setId(4L);
		test3.setName("Mt Gravett");
		test3.setWeighting(40);
		map.put(test3.getName(), test3);

		Library test4 = new Library();
		test4.setId(5L);
		test4.setName("Hellanswale");
		test4.setWeighting(0);
		map.put(test4.getName(), test4);

		return map;

	}

}

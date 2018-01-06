package jp.dip.gpsoft.tanya.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

	class Cat {
		public String name;
		public Integer age;

		public Cat(String name, Integer age) {
			this.name = name;
			this.age = age;
		}
	}

	private List<Cat> cats;

	{
		cats = Arrays.asList(
				new Cat("クーちゃん", 12),
				new Cat("ターちゃん", 11));
	}

	@RequestMapping("/fruits")
	public List<String> func1() {
		return Arrays.asList("apple", "orange", "banana");
	}

	@RequestMapping("/cats")
	public List<Cat> func2() {
		return cats;
	}

	@GetMapping("/cats/1")
	public Cat func3() {
		return cats.get(0);
	}

	@PutMapping("/cats/1")
	public Cat func4() {
		return new Cat("クーちゃん(PUT)", 12);
	}
}

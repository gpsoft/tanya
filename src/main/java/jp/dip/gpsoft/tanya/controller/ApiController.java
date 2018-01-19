package jp.dip.gpsoft.tanya.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.dip.gpsoft.tanya.model.Cat;

@RestController
@RequestMapping("/api")
public class ApiController {

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

	@GetMapping("/cats/{id:^[0-9]+$}")
	public Cat func3(@PathVariable Integer id) {
		return cats.get(id-1);
	}

	@PutMapping("/cats/1")
	public Cat func4() {
		return new Cat("クーちゃん(PUT)", 12);
	}
}

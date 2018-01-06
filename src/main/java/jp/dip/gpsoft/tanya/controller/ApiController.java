package jp.dip.gpsoft.tanya.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

	@RequestMapping("/fruits")
	public List<String> func1() {
		return Arrays.asList("apple", "orange", "banana");
	}
}

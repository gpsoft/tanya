package jp.dip.gpsoft.tanya.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.dip.gpsoft.tanya.model.Cat;

@Controller
public class HomeController {

	@Autowired
	private Logger logger;

	@Autowired
	private MessageSource msgSource;

	@RequestMapping("/home")
	public String home(Locale locale, Model model) {
		logger.info("/home");
		model.addAttribute("now", LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
		model.addAttribute("cat", new Cat("ターちゃん", 9));
		model.addAttribute("cats", Arrays.asList(
				new Cat("クーちゃん", 12),
				new Cat("クロコ", 6),
				new Cat("ターちゃん", 9)));
		return "home";
	}

	@RequestMapping("/")
	public String top() {
		return "redirect:/home";
	}

	@RequestMapping("/greet/{name}")
	@ResponseBody
	public String greet(@PathVariable String name) {
		return "<p>Hello " + name + "</p>";
	}

	@RequestMapping("/greet2")
	@ResponseBody
	public String greet2(@RequestParam(value = "name", defaultValue = "") String name) {
		if (name.equals("")) {
			return "<p>Hello again</p>";
		}
		return "<p>Hello again, " + name + "</p>";
	}

	@PostMapping("/post")
	@ResponseBody
	public String post(@RequestBody(required = false) MultiValueMap<String, Object> cat) {
		if (cat == null) {
			return "NG";
		}
		System.out.println(cat.getFirst("name"));
		System.out.println(cat.getFirst("age"));
		return "OK";
	}
}

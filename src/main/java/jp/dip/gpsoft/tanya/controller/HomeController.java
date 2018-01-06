package jp.dip.gpsoft.tanya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping("/home")
	@ResponseBody
	public String home() {
		return "<h2>Home</h2><p>Welcome!!</p>";
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
	public String greet2(@RequestParam(value="name",defaultValue="") String name) {
		if ( name.equals("") ) {
			return "<p>Hello again</p>";
		}
		return "<p>Hello again, " + name + "</p>";
	}
}

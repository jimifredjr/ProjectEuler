package processor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@RequestMapping(value = "problem/{problem}", method = RequestMethod.GET)
	public String index(@RequestParam int problem) {
		return "Hello World "+problem;
	}
}

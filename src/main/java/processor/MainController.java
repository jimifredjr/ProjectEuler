package processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	
	
	@RequestMapping(value = "problem/{problem}", method = RequestMethod.GET)
	public String index(@RequestParam int problem) {
		return "Hello World "+problem;
	}
}

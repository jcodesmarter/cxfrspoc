package poc.raviraj.cxfrspoc.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldRestController {

	@RequestMapping(value = "/sayhi/{name}")
	@ResponseBody
	public String sayHi(@PathVariable(value = "name") String name) {
		return "Hello, " + name + " !!!";
	}

}

package poc.raviraj.cxfrspoc.service;

import javax.jws.WebService;

@WebService(name = "helloWorld")
public interface HelloWorld {
	
	public String sayHi(String name);
}

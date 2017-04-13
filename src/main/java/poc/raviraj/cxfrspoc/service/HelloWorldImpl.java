package poc.raviraj.cxfrspoc.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

@Service(value="helloWorld")
@WebService(name = "helloWorld", endpointInterface = "poc.raviraj.cxfwspoc.service.HelloWorld", serviceName="helloworld", wsdlLocation = "wsdl/helloworld.wsdl")
public class HelloWorldImpl implements HelloWorld {

	public String sayHi(@WebParam(name = "name") String name) {
		return "Hello, " + name + " !!!";
	}

}

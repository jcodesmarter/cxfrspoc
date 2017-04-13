package poc.raviraj.cxfrspoc.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(ServiceBeanConfiguration.class);
		// servlet-listener configuraiton
		container.addListener(new ContextLoaderListener(context));

		// ApplicationContext context = new
		// AnnotationConfigApplicationContext(ServiceBeanConfiguration.class);

		ServletRegistration.Dynamic webservice = container.addServlet("dispatcher", new DispatcherServlet(context));
		webservice.addMapping("/*");
		webservice.setLoadOnStartup(1);
		FilterRegistration.Dynamic corsfilter = container.addFilter("corsfilter", new CORSFilter());
		corsfilter.addMappingForUrlPatterns(null, false, "/*");
	}

}

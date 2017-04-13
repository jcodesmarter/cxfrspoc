package poc.raviraj.cxfrspoc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@Import(value = { DatabaseBeanConfiguration.class })
@ComponentScan(basePackages = { "poc.raviraj.cxfrspoc.rest", "poc.raviraj.cxfrspoc.dao" })
@EnableWebMvc
public class ServiceBeanConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	/**
	 * Setup a simple strategy: use all the defaults and return XML by default
	 * when not sure.
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		//configurer.defaultContentType(MediaType.APPLICATION_XML);
	}
}

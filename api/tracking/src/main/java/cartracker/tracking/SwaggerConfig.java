
package cartracker.tracking;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo(){
		Contact contact = new Contact("varunchandra", "https://egen.io", "vchandr5@uncc.edu");
		ApiInfo info = new ApiInfo("Spring REST API", "A simple REST API", "1.0.0", "Tnc", contact, "MIT", "https://opensource.org/licences/MIT");
		return info;
		
	}

}

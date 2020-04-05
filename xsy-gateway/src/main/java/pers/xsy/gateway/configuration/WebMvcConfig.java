package pers.xsy.gateway.configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @ClassName SecurityPropertiesConfig
 * @Description: 默认SpringMVC拦截器
 * @Author XsYounG. Tribute to Alan Turing
 * @Date 2020/4/5
 * @Version V1.0
 **/
public class WebMvcConfig extends WebMvcConfigurationSupport {
	/**
	 * 设置资源文件目录
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
				.addResourceLocations("classpath:/resources/")
				.addResourceLocations("classpath:/static/")
				.addResourceLocations("classpath:/public/");
		super.addResourceHandlers(registry);
	}
}

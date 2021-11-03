package covid.utility;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class ImageConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		exposeDirectory(registry, "prevention-image");
	}
	
	private void exposeDirectory(ResourceHandlerRegistry registry, String directory) {
		Path uploadDirPath = Paths.get(directory);
		String uploadPath = uploadDirPath.toFile().getAbsolutePath();
		
		if (directory.startsWith("../")) {
			directory = directory.replace("../", "");
		}
		
		registry.addResourceHandler("/" + directory + "/**").addResourceLocations("file:/" + uploadPath + "/");
	}
}

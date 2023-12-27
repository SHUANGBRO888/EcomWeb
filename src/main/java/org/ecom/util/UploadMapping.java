package org.ecom.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UploadMapping implements WebMvcConfigurer {
    // Upload pics
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Set the upload path and real path relationships
        registry.addResourceHandler("/upfile/**").addResourceLocations("file:/Users/gezi/Desktop/Personal Project/SpringBootEcomWeb/demo/proj_img/");
    }
}

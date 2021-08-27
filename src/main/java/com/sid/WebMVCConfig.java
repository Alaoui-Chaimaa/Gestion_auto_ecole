package com.sid;

import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMVCConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addViewControllers(ViewControllerRegistry registry){
		
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/logout").setViewName("login");
		registry.addViewController("/Acceuil").setViewName("page_acceuil");
		registry.addViewController("/candidats").setViewName("candidats");
		registry.addViewController("/responsable").setViewName("responsable"); 
		registry.addViewController("/responsable").setViewName("responsable");
         registry.addViewController("/AjouterCandidat").setViewName("AjouterCandidat");
         registry.addViewController("/Afficher").setViewName("Afficher");
         
        
 }
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        exposeDirectory("Candidat-photos", registry);
    }
     
    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
        Path uploadDir = Paths.get(dirName);
        String uploadPath =  uploadDir.toFile().getAbsolutePath();
         
        if (dirName.startsWith("../")) dirName = dirName.replace("../", "");
         
        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/"+ uploadPath + "/");
    }
    
	
    
}

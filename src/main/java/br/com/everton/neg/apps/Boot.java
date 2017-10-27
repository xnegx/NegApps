package br.com.everton.neg.apps;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import br.com.everton.neg.apps.storage.StorageProperties;
import br.com.everton.neg.apps.storage.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Boot
{

   public static void main(String[] args)
   {
      SpringApplication.run(Boot.class, args);
   }
   
   @Bean
   CommandLineRunner init(StorageService storageService) {
       return (args) -> {
           storageService.deleteAll();
           storageService.init();
       };
   }
   
}

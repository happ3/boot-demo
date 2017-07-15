package com.boot.demo.sdubbo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;


/**
 * Hello world!
 *
 */
@EnableConfigurationProperties
@SpringBootApplication(exclude={HibernateJpaAutoConfiguration.class})
@ComponentScan(basePackages = {"com.boot.demo.*"})
public class App {
    public static void main( String[] args )
    {
    	
        System.out.println( "生产者" );
        SpringApplication.run(App.class, args);  
        try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}

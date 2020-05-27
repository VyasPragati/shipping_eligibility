package com.shipping.program;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * Hello world!
 *
 */

@ComponentScan({"com.shipping.eligiblity","com.shipping.exception","com.shipping.program","com.shipping.bean","com.shipping.service","com.shipping.rules"})
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
   
        System.out.println( "started" );
    }
}

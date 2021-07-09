package br.upe.ppsw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ServletExemploApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletExemploApplication.class, args);
	}

}

package fr.sarke.inj_dependance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(fr.sarke.inj_dependance.config.InjDependanceConfig.class)
public class InjDependanceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(InjDependanceApplication.class, args);}

}

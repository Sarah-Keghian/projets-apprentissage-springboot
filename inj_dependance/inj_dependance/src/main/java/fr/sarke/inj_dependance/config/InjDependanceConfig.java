package fr.sarke.inj_dependance.config;

import fr.sarke.inj_dependance.*;
import fr.sarke.inj_dependance.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InjDependanceConfig {

    @Bean
    public ToucheAvancer toucheAvancer() {
        return new ToucheAvancerUS();
    }

    @Bean
    public ToucheAGauche toucheAGauche() {
        return new ToucheAGaucheUS();
    }

    @Bean
    public ToucheADroite toucheADroite(){
        return new ToucheADroiteUS();
    }

    @Bean
    public ToucheReculer toucheReculer(){
        return new ToucheReculerUS();
    }

    @Bean
    public AfficheurTouches toucheImpl(){
        return new TouchesImpl(toucheAvancer(), toucheAGauche(), toucheReculer(), toucheADroite());
    }


}

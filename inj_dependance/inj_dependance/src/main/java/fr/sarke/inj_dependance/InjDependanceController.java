package fr.sarke.inj_dependance;

import fr.sarke.inj_dependance.impl.TouchesImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InjDependanceController {

    private AfficheurTouches afficheurTouches;

    public InjDependanceController(AfficheurTouches afficheurTouches) {
        this.afficheurTouches = afficheurTouches;
    }

    @RequestMapping("/affiche")
    public String montreTouche(){
        return this.afficheurTouches.print();
    }

}

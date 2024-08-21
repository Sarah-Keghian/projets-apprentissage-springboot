package fr.sarke.db_for_de.service;

import fr.sarke.db_for_de.model.De;
import fr.sarke.db_for_de.repository.DeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeService {

    private final DeRepo deRepo;
    @Autowired
    public DeService(DeRepo deRepo) {this.deRepo = deRepo;}

    public List<De> getAllDes(){
        return deRepo.findAll();
    }

    public Optional<De> getDeById(Long id){
        return deRepo.findById(id);
    }

    public De addDe(De de){
        return deRepo.save(de);
    }

    public De deleteDeById(Long id){
        Optional<De> de = deRepo.findById(id);
        if (de.isPresent()) {
            deRepo.deleteById(id);
            return de.get();
        }
        else{
            return null;
        }
    }

    public De updateDeById(Long id, De newDe){

        Optional<De> oldDeOrNull = deRepo.findById(id);

        if (oldDeOrNull.isPresent()) {
            De oldDe = oldDeOrNull.get();
            oldDe.setNbFaces(newDe.getNbFaces());
            oldDe.setPosition(newDe.getPosition());
            return deRepo.save(oldDe);
        }
        else {
            return null;
        }
    }

    public List<De> deleteAllDes(){

        List<De> listeDes = this.getAllDes();
        deRepo.deleteAll(listeDes);
        return listeDes;
    }
}

package fr.sarke.db_for_de.service;

import fr.sarke.db_for_de.model.De;
import fr.sarke.db_for_de.repository.DeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DeServiceTests {

    @Mock
    DeRepo deRepo;

    @InjectMocks
    DeService deService;

    @Test
    public void DeService_getAllDe_Test(){

        De d1 = new De(1L, 6,2);
        De d2 = new De(2L, 6,3);

        when(deRepo.findAll()).thenReturn(Arrays.asList(d1, d2));

        ArrayList<De> listeAttendue = new ArrayList<>();
        listeAttendue.add(d1);
        listeAttendue.add(d2);

        List<De> listeObtenue = deService.getAllDes();
        Assertions.assertNotNull(listeObtenue);
        Assertions.assertEquals(listeAttendue, listeObtenue);
    }

    @Test
    public void DeService_getDeById_Test(){

        Long id = 1L;
        Long id2 = 2L;
        De d1 = new De(id,6,2);

        when(deRepo.findById(id)).thenReturn(Optional.of(d1));
        when(deRepo.findById(id2)).thenReturn(Optional.empty());

        Optional<De> deObtenu1 = deService.getDeById(id);

        Assertions.assertNotNull(deObtenu1);
        Assertions.assertTrue(deObtenu1.isPresent());
        Assertions.assertEquals(d1, deObtenu1.get());

        Optional<De> deObtenu2 = deService.getDeById(id2);

        Assertions.assertNotNull(deObtenu2);
        Assertions.assertFalse(deObtenu2.isPresent());
    }

    @Test
    public void DeService_addDe_Test(){
        De d1 = new De(1L, 6,2);

        when(deRepo.save(d1)).thenReturn(d1);

        De deObtenu = deService.addDe(d1);

        Assertions.assertNotNull(deObtenu);
        Assertions.assertEquals(d1, deObtenu);
    }

    @Test
    public void DeService_deleteDeById_Test(){

        Long id1 = 1L;
        Long id2 = 2L;
        De d1 = new De(id1,6,2);

        doNothing().when(deRepo).deleteById(id1);
        when(deRepo.findById(id1)).thenReturn(Optional.of(d1));
        when(deRepo.findById(id2)).thenReturn(Optional.empty());


        De deObtenu1 = deService.deleteDeById(id1);
        De deObtenu2 = deService.deleteDeById(id2);

        Assertions.assertNotNull(deObtenu1);
        Assertions.assertNull(deObtenu2);
        Assertions.assertEquals(deObtenu1, d1);
    }

    @Test
    public void DeService_updateDeById_Test(){

        Long id1 = 1L;
        Long id2 = 2L;
        De oldDe = new De(id1,6,2);
        De newDeId2 = new De(id2,6,3);
        De newDeId1 = new De(id1,6,3);

        when(deRepo.save(newDeId1)).thenReturn(newDeId1);
        when(deRepo.findById(id1)).thenReturn(Optional.of(oldDe));

        De deObtenu1 = deService.updateDeById(id1, newDeId2);
        De deObtenu2 = deService.updateDeById(id2, newDeId2);

        Assertions.assertNotNull(deObtenu1);
        Assertions.assertEquals(newDeId2.getPosition(), deObtenu1.getPosition());
        Assertions.assertEquals(newDeId2.getNbFaces(), deObtenu1.getNbFaces());
        Assertions.assertNotEquals(newDeId2.getId(), deObtenu1.getId());

        Assertions.assertEquals(newDeId1, deObtenu1);

        Assertions.assertNull(deObtenu2);
    }

    @Test
    public void DeService_deleteAllDes_Test(){
        Long id1 = 1L;
        Long id2 = 2L;
        De d1 = new De(id1,6,2);
        De d2 = new De(id2,6,3);

        when(deRepo.findAll()).thenReturn(Arrays.asList(d1, d2));

        List<De> listeDesSupprimes = deService.deleteAllDes();
        Assertions.assertNotNull(listeDesSupprimes);
        Assertions.assertEquals(listeDesSupprimes, deService.getAllDes());
    }
}

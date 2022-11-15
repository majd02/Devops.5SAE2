package tn.esprit.rh.achat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;
import tn.esprit.rh.achat.services.ProduitServiceImpl;
import tn.esprit.rh.achat.services.StockServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class OperateurServiceTest {
	
	 @Mock
	    OperateurRepository operateurRepository;

	    @InjectMocks
	    OperateurServiceImpl operateurService;

	    Operateur o1 = new Operateur(12L, "Rouka","Ch","23333",null);
	    Operateur o2 = new Operateur(22L, "Rouka2","Ch2","000000",null);

	    List<Operateur> listOperateurs = new ArrayList<Operateur>() {
	        {
	            add(o1);
	            add(new Operateur(10L, "N1","P1","11",null));
	            add(new Operateur(20L, "N2","P2","22",null));
	        }
	    };

	    @Test
	    public void retrieveOperateur() {
	        System.out.println("retrieveOperateurs");
	        Mockito.when(operateurRepository.findById(12L)).thenReturn(Optional.of(o1));
	        Operateur operateur1 = operateurService.retrieveOperateur(12L);
	        assertNotNull(operateur1);
	    }
	    @Test
	   public void testretrieveAllOperateurs() {
	        System.out.println("retrieveAllOperateurs");
	        Mockito.when(operateurRepository.findAll()).thenReturn(listOperateurs);
	        List<Operateur> operateurList3 = operateurService.retrieveAllOperateurs();
	        assertEquals(3, operateurList3.size());
	        //assertEquals(operateur1.,55L);
	    }

	    @Test
	   public void testaddOperateur(){
	        System.out.println("testaddOperateur");
	        Mockito.when(operateurRepository.save(o1)).thenReturn(o1);
	        Operateur operateur1 = operateurService.addOperateur(o1);
	        assertNotNull(operateur1);
	        Mockito.verify(operateurRepository, times(1)).save(Mockito.any(Operateur.class));
	    }


	    @Test
	   public void testdeleteOperateur(){
	        System.out.println("testdeleteoperateur");
	        operateurService.deleteOperateur(66L);
	        Mockito.verify(operateurRepository, times(0)).delete(o2);
	    }

	


}
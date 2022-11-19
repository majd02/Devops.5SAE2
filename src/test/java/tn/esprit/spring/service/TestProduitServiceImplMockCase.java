package tn.esprit.spring.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.times;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TestProduitServiceImplMockCase {
    @Mock
    ProduitRepository produitRepository;

    @Mock
    StockRepository sr;
	
	   @InjectMocks
	   ProduitServiceImpl produitService;

	    Produit p1 = new Produit(55L, "2365","produit1",50, null, null, null, null, null);
	    Produit p2 = new Produit(66L, "5681","produit5",120, null, null, null, null, null);
	    List<Produit> listProduits = new ArrayList<Produit>() {
	        {
	            add(p1);
	            add(new Produit(90L, "9687","produit2",30,null, null, null, null, null));
	            add(new Produit(46L, "4503","produit3",70, null, null, null, null, null));
	        }
	    };
	    @Test
	    public void testretrieveAllProduits() {
	        Mockito.when(produitRepository.findAll()).thenReturn(listProduits);
	        List<Produit> listproduit3 = produitService.retrieveAllProduits();
	        assertEquals(3, listproduit3.size());
	        //assertEquals(produit1.getIdProduit(),55L);
	        System.out.println("2555");
	    }
	@Test
	public void testAddFacture() { 
		 Mockito.when(produitRepository.save(p1)).thenReturn(p1);
	        Produit produit1 = produitService.addProduit(p1);
	        //assertNotNull(produit1);
	        Mockito.verify(produitRepository, times(1)).save(Mockito.any(Produit.class));
	        System.out.println("3");
	}
    @Test
    public void testdeleteProduit(){
        produitService.deleteProduit(66L);
        Mockito.verify(produitRepository, times(1)).deleteById(66L);
        System.out.println("4");
    }

    @Test
    public void testupdateProduit(){
        Mockito.when(produitRepository.save(p1)).thenReturn(p1);
        Produit produit1 = produitService.updateProduit(p1);
        Mockito.verify(produitRepository, times(1)).save(Mockito.any(Produit.class));
        System.out.println("5");
    }

    @Test
   public void testassignProduitToStock(){

        Stock stock = new Stock();
        stock.setIdStock(1L);
        stock.setLibelleStock("libelle3");
        stock.setQte(20);
        stock.setQteMin(1);

        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(p1));
        Mockito.when(sr.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
        produitService.assignProduitToStock(55L,1L);
        Mockito.verify(produitRepository, times(1)).save(Mockito.any(Produit.class));

        System.out.println("6");    }
}
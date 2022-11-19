/*
package tn.esprit.spring.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.IProduitService;



@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ProduitTestServiceImpl {

    @Autowired
    IProduitService produitService;

    @Autowired
    ProduitRepository produitRepository;

    Produit p1 = new Produit(55L, "2365","produit1",50, null, null, null, null, null);
    Produit p2 = new Produit(66L, "5681","produit5",120, null, null, null, null, null);
    
    @Order(1)
    @Test
    public void testaddProdiut() {
        Produit produitAdded =  produitService.addProduit(p1);
        Assertions.assertEquals(produitAdded.getCodeProduit(), produitAdded.getCodeProduit());
    }

    
    
    @Test
    public void testRetrieveAllProduits() {
        List<Produit> listProduits = produitService.retrieveAllProduits();
        Assertions.assertEquals(listProduits.size(), listProduits.size());
    }



    

    @Order(3)
    @Test
    public void testModifyProduit()   {

       Produit produitUpdated  = produitService.updateProduit(p2);
       Assertions.assertEquals(p2.getCodeProduit(), produitUpdated.getCodeProduit());
    }

    

    @Order(4)
    @Test
    public void testDeleteProduit() {

        produitService.deleteProduit(55L); 
    	produitRepository.delete(p1);
        Assertions.assertNull(produitService.retrieveProduit(55L));
       
    }
}

*/


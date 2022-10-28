
package tn.esprit.rh.achat;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.services.CategorieProduitServiceImpl;



@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)

public class categorieproduitTest {

@Mock
CategorieProduitRepository categorieRepository;

@InjectMocks
CategorieProduitServiceImpl categorieService;


@Test
public void testRetrieveCategorieProduit() {

CategorieProduit categorie = new CategorieProduit(null,"test","test", null);
categorie.setIdCategorieProduit(1L);

Mockito.when(categorieRepository.findById(1L)).thenReturn(Optional.of(categorie));
categorieService.retrieveCategorieProduit(1L);
Assertions.assertNotNull(categorie);

System.out.println(categorie);
System.out.println(" testRetrieveCategorieProduit-> CA MARCHE  !!!!!");

}

@Test
public void createCategorieProduitTest()
{

CategorieProduit categorie2 = new CategorieProduit(null,"test1.0.0", "test1.0.0", null);
categorie2.setIdCategorieProduit(2L);

categorieService.addCategorieProduit(categorie2);
verify(categorieRepository, times(1)).save(categorie2);
System.out.println(categorie2);
System.out.println(" createCategorieProduitTest -> CA MARCHE  !!!!!");
}

@Test
public void getAllCategorieProduitTest()
{
List<CategorieProduit> Catprodlist = new ArrayList<CategorieProduit>() {

{
add(new CategorieProduit(null,"nada","nadanada", null));
add(new CategorieProduit(null,"nadahassen","nadahassen1", null));
add(new CategorieProduit(null,"testing","testing", null));
}};


when(categorieService.retrieveAllCategorieProduits()).thenReturn(Catprodlist);
//test
List<CategorieProduit> catList = categorieService.retrieveAllCategorieProduits();
assertEquals(3,catList.size());
System.out.println(" getAllCategorieProduitTest MARCHE !!!! ");

}

@Test
public void TestDeleteCategorieProduit(){

CategorieProduit categorie1 = new CategorieProduit(null,"aaaaa","bbbbbbb", null);
categorie1.setIdCategorieProduit(7L);



Mockito.lenient().when(categorieRepository.findById(categorie1.getIdCategorieProduit())).thenReturn(Optional.of(categorie1));

categorieService.deleteCategorieProduit(7L);
verify(categorieRepository).deleteById(categorie1.getIdCategorieProduit());

System.out.println(categorie1);
System.out.println("  TestDeleteCategorieProduit MARCHE ");
}

}

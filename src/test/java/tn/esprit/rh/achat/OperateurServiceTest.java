package tn.esprit.rh.achat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;
import tn.esprit.rh.achat.services.StockServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@AutoConfigureMockMvc

public class OperateurServiceTest {
	@Mock
	OperateurRepository sr;
	@InjectMocks
	OperateurServiceImpl ss;

	@Test
	public void testAddOperateur() {
		Operateur operateur = new Operateur();
		Mockito.when(sr.save(ArgumentMatchers.any(Operateur.class))).thenReturn(operateur);
		Operateur Operateuradd = ss.addOperateur(operateur);
		assertThat(Operateuradd.getNom()).isSameAs(Operateuradd.getNom());
	}

	@Test
	public void RetrieveAllOperateurTest() {
		List<Operateur> operateurs = new ArrayList<>();
		operateurs.add(new Operateur());
		when(sr.findAll()).thenReturn(operateurs);
		List<Operateur> expected = ss.retrieveAllOperateurs();
		assertEquals(expected, operateurs);
		verify(sr).findAll();
	}

	@Test
	public void DeleteOperateurTest() {
		Operateur operateur = new Operateur();
		operateur.getIdOperateur();
		operateur.getNom();
		operateur.getPrenom();
		operateur.getPassword();
		/*Mockito.when(sr.findById(stock.getIdStock())).thenReturn(Optional.of(stock));
		ss.deleteStock(stock.getIdStock());
		verify(sr).deleteById(stock.getIdStock());*/
		System.out.println("testdeleteOperateur");
        ss.deleteOperateur(null);
        Mockito.verify(sr, times(0)).delete(operateur);
	}

}
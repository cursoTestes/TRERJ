package br.scrumban;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.dbunit.DBTestCase;
import org.junit.Test;

import br.scrumban.dao.VendaDAO;
import br.scrumban.dao.VendedorDAO;
import br.scrumban.infra.BaseDBTest;

public class VendaDAOTest extends BaseDBTest {

	@Test
	public void testTotalVendasVendedorComUmaVendaNoAno() {
		// Arrange

		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 2;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2011;
		double resultado;
		double esperado = 100.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
	
	@Test
	public void testTotalVendasVendedorSemVendasNoAno() {
		// Arrange

		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 2;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2012;
		double resultado;
		double esperado = 0.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
		
	@Test
	public void testTotalVendasVendedorComMaisDeUmaVendaNoAno() {
		// Arrange

		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 3;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2012;
		double resultado;
		double esperado = 223.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
	
	@Test
	public void testTotalVendasDeUmVendedorComUmaVendaCompartilhadaComOutroVendedor() {
		// Arrange

		Vendedor vendedor1 = new Vendedor();
		int entradaIdVendedor1 = 5;
		vendedor1.setId(entradaIdVendedor1);
		
		int entradaAno = 2012;
				
		double resultado;
		double esperado = 5;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor1, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
	
	public void testTotalVendasDeUmVendedorComUmaVendaCompartilhadaComOutrosDoisVendedores() {
		// Arrange

		Vendedor vendedor1 = new Vendedor();
		int entradaIdVendedor1 = 9;
		vendedor1.setId(entradaIdVendedor1);
		
		int entradaAno = 2014;
				
		double resultado;
		double esperado = 50;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor1, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
	
	
}

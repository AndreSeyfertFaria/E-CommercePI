package model;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import GeraRalatorio.Relatorio;
import entities.Produto;
import entities.Usuario;

public class ProdutoModel {

	public static void cadastrarProduto(String codigoProduto, String descricao, String marca, String unidade, String nomeImagem ) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce");
		EntityManager manager = factory.createEntityManager();
		Produto novoProduto = new Produto();
		
		novoProduto.setCodigoProduto(codigoProduto);
		novoProduto.setDescricao(descricao);
		novoProduto.setMarca(marca);
		novoProduto.setUnidade(unidade.toUpperCase());
		novoProduto.setNomeImagem(nomeImagem + ".jpg");
		
		manager.persist(novoProduto);
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Produto> listarProdutos() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("ecommerce");
		EntityManager manager = factory.createEntityManager();
		try {
			Query query = manager.createQuery("FROM Produto p");
			return query.getResultList();
		} finally {
			manager.close();
			factory.close();	
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public static void relatorioSintetico() {
		try {			
			Relatorio relatorio = new Relatorio();
			relatorio.gerarRelatorio("./Blank_A4.jrxml", false);
		} catch (Exception e) {
			e.printStackTrace();
			
		} 
	}
	
	
	
//	@SuppressWarnings("unchecked")
//	public static void relatorioSintetico() {
//		EntityManagerFactory factory = Persistence
//				.createEntityManagerFactory("ecommerce");
//		EntityManager manager = factory.createEntityManager();
//		try {
//			Query query = manager.createQuery("SELECT COUNT(p) FROM produto p");
//			List Lista = query.getResultList();
//			
//			for (Object obj : Lista) {
//				System.out.println(obj);
//			}
//			
//			Relatorio relatorio = new Relatorio();
//			relatorio.gerarRelatorio("/GeraRelatorio/sintetico/Sintetico.jrxml", false);
//		} catch (Exception e) {
//			e.printStackTrace();
//			
//		} finally {
//			manager.close();
//			factory.close();	
//		}
//	}
	
	
	
}

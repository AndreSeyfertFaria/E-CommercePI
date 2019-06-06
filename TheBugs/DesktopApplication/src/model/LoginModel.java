package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Usuario;

public class LoginModel {
	
	public static Boolean userCheck(String usuario, String senha) {
		//Usuario usuario = new Usuario();
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("ecommerce");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery("SELECT u FROM Usuario u WHERE USUARIO = ? AND SENHA = ?");
		query.setParameter(1, usuario);
		query.setParameter(2, senha);
		List<Usuario> user = query.getResultList();
		manager.close();
		factory.close();
		if (user.size() == 1) {
			return true;
		} else {
			return false;
		}
	}
}

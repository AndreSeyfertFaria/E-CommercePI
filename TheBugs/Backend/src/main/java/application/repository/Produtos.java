package application.repository;

import org.springframework.data.repository.CrudRepository;

import application.model.Produto;

public interface Produtos extends CrudRepository<Produto, Long> {

}

package br.pucminas.livrariavirtual.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pucminas.livrariavirtual.api.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>
{

}

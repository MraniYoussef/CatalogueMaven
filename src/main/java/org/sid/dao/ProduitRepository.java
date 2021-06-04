package org.sid.dao;

import java.io.Serializable;

import org.sid.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long>  {

}

package org.sid;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CataMvc4Application {

	public static void main(String[] args) {
		
		  ApplicationContext ctx = SpringApplication.run(CataMvc4Application.class,
		  args); 
		  ProduitRepository produitRepository =
		 ctx.getBean(ProduitRepository.class);
			/*
			 * produitRepository.save(new Produit("Aduleur",1000,5));
			 * produitRepository.save(new Produit("Imprimente",1500,3));
			 * produitRepository.save(new Produit("Computer hp",10000,5));
			 */
		  
		  produitRepository.findAll().forEach(p ->
		  System.out.println(p.getDesignation()));
		 
	}

}

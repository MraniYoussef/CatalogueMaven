package org.sid.web;

import java.awt.print.Pageable;
import java.util.List;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository produitRpository;
	
	@RequestMapping(value="/index")
	public String index(Model model) {
		List<Produit> produits = produitRpository.findAll();
		model.addAttribute("listProduits", produits);
		return "produits";
	}
}

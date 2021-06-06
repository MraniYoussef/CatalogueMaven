package org.sid.web;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProduitController  {
	@Autowired
	private ProduitRepository produitRpository;
	
	
	  @RequestMapping(value="/index") public String index(Model model,
	  @RequestParam(name="page",defaultValue ="0")int p,
	  @RequestParam(name="size",defaultValue="5")int s,
	  @RequestParam(name="mc",defaultValue="")String mc ) 
	  { Page<Produit>
	  pageProduits = produitRpository.chercher("%"+mc+"%", PageRequest.of(p, s));
	  model.addAttribute("listProduits", pageProduits.getContent());
	  model.addAttribute("pages",new int[pageProduits.getTotalPages()]);
	  model.addAttribute("currentPage",p); model.addAttribute("size",s);
	  model.addAttribute("mc",mc); 
	  return "produits"; }
	 
	
	
	
	  @RequestMapping(value="/delete",method=RequestMethod.GET) 
	 public String delete(Long id,String mc, int page,int size) { 
		 produitRpository.deleteById(id);
	  return "redirect:/index?page="+page+"&size="+size+"&mc="+mc;}
	 
	 
}








/*
 * @RequestMapping(value="/index") public String index(Model model,
 * 
 * @RequestParam(name="page",defaultValue ="0")int p,
 * 
 * @RequestParam(name="size",defaultValue="5")int s,
 * 
 * @RequestParam(name="mc",defaultValue="")String mc ) { Page<Produit>
 * pageProduits = produitRpository.chercher("%"+mc+"%",PageRequest.of(p, s));
 * model.addAttribute("listProduits", pageProduits.getContent());
 * model.addAttribute("pages",new int[pageProduits.getTotalPages()]);
 * model.addAttribute("currentPage",p); model.addAttribute("size",s);
 * model.addAttribute("mc",mc); return "produits"; }
 */


/*
 * @RequestMapping(value="/index") public String index(Model model,
 * 
 * @RequestParam(name="page",defaultValue ="0")int p,
 * 
 * @RequestParam(name="size",defaultValue="5")int s,
 * 
 * @RequestParam(name="mc",defaultValue="")String mc ) { Page<Produit>
 * pageProduits = produitRpository.chercher("%"+mc+"%", new PageRequest(p, s));
 * model.addAttribute("listProduits", pageProduits.getContent());
 * model.addAttribute("pages",new int[pageProduits.getTotalPages()]);
 * model.addAttribute("currentPage",p); model.addAttribute("size",s);
 * model.addAttribute("mc",mc); return "produits";
 */
package org.sid.web;

import javax.validation.Valid;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProduitController  {
	@Autowired
	private ProduitRepository produitRepository;
	
	
	  @RequestMapping(value="/user/index") public String index(Model model,
	  @RequestParam(name="page",defaultValue ="0")int p,
	  @RequestParam(name="size",defaultValue="5")int s,
	  @RequestParam(name="mc",defaultValue="")String mc ) 
	  { 
	  Page<Produit>
	  pageProduits = produitRepository.findAll(PageRequest.of(p, s));
	  model.addAttribute("listProduits", pageProduits.getContent());
	  model.addAttribute("pages",new int[pageProduits.getTotalPages()]);
	  model.addAttribute("currentPage",p); model.addAttribute("size",s);
	  model.addAttribute("mc",mc); 
	  return "produits"; }
	 
		
	  @RequestMapping(value="/admin/delete",method=RequestMethod.GET) 
	 public String delete(Long id,String mc, int page,int size) { 
		 produitRepository.deleteById(id);
	  return "redirect:/user/index?page="+page+"&size="+size+"&mc="+mc;}
	 
	  @RequestMapping(value="/admin/form", method=RequestMethod.GET)
	 public String formProduit(Model model) {
		 model.addAttribute("produit", new Produit());
		 return "FormProduit";
	 }
	  @RequestMapping(value="/admin/edit", method=RequestMethod.GET)
		 public String edit(Model model,Long id) {
		  Produit p=produitRepository.getById(id);
			model.addAttribute("produit", p);
			 return "EditProduit";
		 }
	  
	  @RequestMapping(value="/admin/save", method=RequestMethod.POST)
		 public String save(Model model, @Valid Produit produit, BindingResult bindingResult ) {
		  if(bindingResult.hasErrors())
			  return "formProduit";
		  produitRepository.save(produit);
			 return "Confirmation";
		 }
	  
	  @RequestMapping(value="/")
	  public String home() {
		  
		  return "redirect:/user/index";
	  }
	  @RequestMapping(value="/403")
	  public String accessDenied() {
		  
		  return "403";
	  }
	  @RequestMapping(value="/login")
	  public String login() {
		  
		  return "login";
	  }
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
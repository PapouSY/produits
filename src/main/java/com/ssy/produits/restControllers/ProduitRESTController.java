package com.ssy.produits.restControllers;

import com.ssy.produits.dto.ProduitDTO;
import com.ssy.produits.entities.Produit;
import com.ssy.produits.repos.ProduitRepository;
import com.ssy.produits.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRESTController {

    @Autowired
    ProduitService produitService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ProduitDTO> getALLProduits(){
        return produitService.getAllProduit();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Produit getProduitById(@PathVariable("id") Long id){
        return produitService.getProduit(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProduitDTO createProduit(@RequestBody ProduitDTO produitDTO){
        return produitService.saveProduit(produitDTO);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ProduitDTO updateProduit(@RequestBody ProduitDTO produitDTO){
        return produitService.saveProduit(produitDTO);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduit (@PathVariable("id") Long id){
        produitService.deleteProduitById(id);
    }

    @RequestMapping(value = "/prodscat/{idCat}", method = RequestMethod.GET)
    public List<Produit> getProduitByCatId(@PathVariable("idCat") Long idCat){
        return produitService.findByCategorieIdCat(idCat);
    }

    @RequestMapping(value = "/prodsByName/{nom}", method = RequestMethod.GET)
    public List<Produit> findByNomProduitContains(@PathVariable("nom") String nom){
        return produitService.findByNomProduitContains(nom);

    }
}

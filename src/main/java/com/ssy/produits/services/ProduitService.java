package com.ssy.produits.services;

import com.ssy.produits.dto.ProduitDTO;
import com.ssy.produits.entities.Produit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitService {

   // Produit saveProduit(Produit p);
    ProduitDTO saveProduit(ProduitDTO p);
    ProduitDTO UpdateProduit(ProduitDTO p);
    List<ProduitDTO> getAllProduit();



    void deleteProduit(Produit p);
    void deleteProduitById(Long id);
    Produit getProduit(Long id);

    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);
    List<Produit> findByNomPrix (String nom,  Double prix);
    List<Produit> findByOrderByNomProduitDesc();
    List<Produit> findByCategorieIdCat(Long id);

    ProduitDTO convertEntityToDto(Produit produit);

    Produit convertDtoToEntity(ProduitDTO produitDTO);
}

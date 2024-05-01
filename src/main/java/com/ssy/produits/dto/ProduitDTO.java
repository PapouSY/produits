package com.ssy.produits.dto;

import com.ssy.produits.entities.Categorie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduitDTO {

    private Long idProduit;
    private String nomProduit;
    private Double prixProduit;
    private Date dateCreation;
    private String nomCat;

    private Categorie categorie;
}

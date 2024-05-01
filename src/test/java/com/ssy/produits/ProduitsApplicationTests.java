package com.ssy.produits;

import com.ssy.produits.entities.Produit;
import com.ssy.produits.repos.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;


@SpringBootTest
class ProduitsApplicationTests {

    @Autowired
   private ProduitRepository produitRepository;

    @Test
    public void testCreateProduit(){
        Produit produit = new Produit("PC DeLL", 2220.300, new Date());
        Produit produit2 = new Produit("PC Hp", 1220.300, new Date());
        Produit produit3 = new Produit("Asus", 1820.300, new Date());
        produitRepository.save(produit2);
        produitRepository.save(produit);

    }

    @Test
    public void testFindProduitById(){
        Produit produit = produitRepository.findById(1L).get();
        System.out.println(produit);
    }

    @Test
    public  void testUpdateProduitById(){
        Produit produit = produitRepository.findById(1L).get();
        produit.setPrixProduit(2300.500);
        produitRepository.save(produit);
        System.out.println(produit);
    }

    @Test
    public void testDeleteProduitById(){
        produitRepository.deleteById(2L);

    }

    @Test
    public void testFindAllProduits(){
        List<Produit> produitList = produitRepository.findAll();

        produitList.stream().forEach(produit -> System.out.println(produit.getNomProduit()));
  /*      for (Produit produit: produitList ) {
            System.out.println(produit.toString());
        }*/

    }

    @Test
    public void testFindProduitByNom(){
        List<Produit> produits = produitRepository.findByNomProduit("PC DeLL");
        produits.stream().forEach(p -> System.out.println(p.getNomProduit() + "  "+ p.getPrixProduit()));
    }

    @Test
    public void testFindProduitByNomContains(){
        List<Produit> produits = produitRepository.findByNomProduitContains(" DeLL");
        produits.stream().forEach(p -> System.out.println(p.getNomProduit() + "  "+ p.getPrixProduit()));
    }

    @Test
    public void testFindBynomPrix(){
        List<Produit> produits = produitRepository.findByNomPrix("DeLL", 2230.00);
        produits.stream().forEach(p -> System.out.println(p.getNomProduit() +" et  "+ p.getPrixProduit()));
    }


    @Test
    public void testFindByOrderByNompProduitAsc(){
        List<Produit> produits = produitRepository.findByOrderByNomProduitDesc();
        produits.stream().forEach(p -> System.out.println(p.getNomProduit() +" et  "+ p.getPrixProduit()));
    }
}

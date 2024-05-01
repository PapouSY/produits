package com.ssy.produits.services;

import com.ssy.produits.dto.ProduitDTO;
import com.ssy.produits.entities.Produit;
import com.ssy.produits.repos.ProduitRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitServiceImpl implements ProduitService{
    @Autowired
    ProduitRepository produitRepository;
    @Override
//    public Produit saveProduit(Produit p) {
//        return produitRepository.save(p);
//    }
    public ProduitDTO saveProduit(ProduitDTO p) {

         return convertEntityToDto(produitRepository.save(convertDtoToEntity(p)));

    }

    @Override
    public ProduitDTO UpdateProduit(ProduitDTO p) {

        return convertEntityToDto(produitRepository.save(convertDtoToEntity(p)));
    }

    @Override
    public List<ProduitDTO> getAllProduit() {
        List<ProduitDTO> produitDTOList = new ArrayList<>();


        //return produitRepository.findAll().stream().forEach(p ->convertEntityToDto(p);
         produitRepository.findAll().stream().forEach(p ->produitDTOList.add(convertEntityToDto(p)));
         return produitDTOList;
 /*       return produitRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());*/
    }

    @Override
    public void deleteProduit(Produit p) {
        produitRepository.delete(p);

    }

    @Override
    public void deleteProduitById(Long id) {

        produitRepository.deleteById(id);
    }

    @Override
    public Produit getProduit(Long id) {
        return produitRepository.findById(id).get();
    }


    @Override
    public List<Produit> findByNomProduit(String nom) {
        return produitRepository.findByNomProduit(nom);
    }

    @Override
    public List<Produit> findByNomProduitContains(String nom) {
        return produitRepository.findByNomProduitContains(nom);
    }

    @Override
    public List<Produit> findByNomPrix(String nom, Double prix) {
        return produitRepository.findByNomPrix(nom,prix);
    }

    @Override
    public List<Produit> findByOrderByNomProduitDesc() {
        return produitRepository.findByOrderByNomProduitDesc();
    }

    @Override
    public List<Produit> findByCategorieIdCat(Long id) {
        return produitRepository.findByCategorieIdCat(id);
    }

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProduitDTO convertEntityToDto(Produit produit) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ProduitDTO produitDTO = modelMapper.map(produit, ProduitDTO.class);
        return  produitDTO;
/*        ProduitDTO produitDTO = new ProduitDTO();
        produitDTO.setIdProduit(produit.getIdProduit());
        produitDTO.setPrixProduit(produit.getPrixProduit());
        produitDTO.setNomProduit(produit.getNomProduit());
        produitDTO.setDateCreation(produit.getDateCreation());
        produitDTO.setCategorie(produit.getCategorie());
        return produitDTO;*/

/*        return ProduitDTO.builder()
                .idProduit(produit.getIdProduit())
                .nomProduit(produit.getNomProduit())
                .prixProduit(produit.getPrixProduit())
                .dateCreation(produit.getDateCreation())
               // .nomCat(produit.getCategorie().getNomCat())
                .build();*/
    }

    @Override
    public Produit convertDtoToEntity(ProduitDTO produitDTO) {

        Produit produit = modelMapper.map(produitDTO, Produit.class);
        return produit;


/*        Produit produit = new Produit();
        produit.setIdProduit(produitDTO.getIdProduit());
        produit.setNomProduit(produitDTO.getNomProduit());
        produit.setPrixProduit(produitDTO.getPrixProduit());
        produit.setDateCreation(produitDTO.getDateCreation());
        produit.setCategorie(produitDTO.getCategorie());
        return produit;*/
    }


}

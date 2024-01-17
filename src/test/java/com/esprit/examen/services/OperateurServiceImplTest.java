package com.esprit.examen.services;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OperateurServiceImpl.class})
@ExtendWith(SpringExtension.class)
class OperateurServiceImplTest {
    @MockBean
    private OperateurRepository operateurRepository;

    @Autowired
    private OperateurServiceImpl operateurServiceImpl;


    @Test
    void testRetrieveAllOperateurs() {
        List<Operateur> actualRetrieveAllOperateursResult = this.operateurServiceImpl.retrieveAllOperateurs();
        Assertions.assertEquals(0, actualRetrieveAllOperateursResult.size());
    }


    @Test
    void testAddOperateur() {
        Operateur operateur = new Operateur();
        operateur.setFactures(new HashSet<>());
        operateur.setIdOperateur(1L);
        operateur.setNom("Nom");
        operateur.setPassword("iloveyou");
        operateur.setPrenom("Prenom");
        when(operateurRepository.save(any())).thenReturn(operateur);

        Operateur operateur1 = new Operateur();
        operateur1.setFactures(new HashSet<>());
        operateur1.setIdOperateur(1L);
        operateur1.setNom("Nom");
        operateur1.setPassword("iloveyou");
        operateur1.setPrenom("Prenom");
        assertSame(operateur1, operateurServiceImpl.addOperateur(operateur1));
        verify(operateurRepository).save(any());
    }


    @Test
    void testDeleteOperateur() {
        doNothing().when(operateurRepository).deleteById(any());
        operateurServiceImpl.deleteOperateur(123L);
        verify(operateurRepository).deleteById(any());
    }


    @Test
    void testUpdateOperateur() {
        Operateur operateur = new Operateur();
        operateur.setFactures(new HashSet<>());
        operateur.setIdOperateur(1L);
        operateur.setNom("Nom");
        operateur.setPassword("iloveyou");
        operateur.setPrenom("Prenom");
        when(operateurRepository.save(any())).thenReturn(operateur);

        Operateur operateur1 = new Operateur();
        operateur1.setFactures(new HashSet<>());
        operateur1.setIdOperateur(1L);
        operateur1.setNom("Nom");
        operateur1.setPassword("iloveyou");
        operateur1.setPrenom("Prenom");
        assertSame(operateur1, operateurServiceImpl.updateOperateur(operateur1));
        verify(operateurRepository).save(any());
    }


    @Test
    void testRetrieveOperateur() {
        Operateur operateur = new Operateur();
        operateur.setFactures(new HashSet<>());
        operateur.setIdOperateur(1L);
        operateur.setNom("Nom");
        operateur.setPassword("iloveyou");
        operateur.setPrenom("Prenom");
        Optional<Operateur> ofResult = Optional.of(operateur);
        when(operateurRepository.findById(any())).thenReturn(ofResult);
        assertSame(operateur, operateurServiceImpl.retrieveOperateur(123L));
        verify(operateurRepository).findById(any());
    }
}


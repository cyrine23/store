package com.tekup.examen.services;

import com.tekup.examen.TpAchatProjectApplication;
import com.tekup.examen.entities.FournisseurDTO;
import com.tekup.examen.entities.SecteurActiviteDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TpAchatProjectApplication.class)
public  class SecteurActiviteDTOServiceImplTest {
    @Autowired
    private ISecteurActiviteService secteurActiviteService;
    @Test
    public void shouldSaveSecteurActiviteSuccefully(){

        FournisseurDTO f1 =  FournisseurDTO.builder()
                .code("123")
                .build();

        Set<FournisseurDTO> fournisseurDTOS = new HashSet<FournisseurDTO>();
        fournisseurDTOS.add(f1);
        SecteurActiviteDTO s = SecteurActiviteDTO.builder()
                .codeSecteurActivite("123456789")
                .libelleSecteurActivite("best secteur ever")
                .fournisseurDTOS(fournisseurDTOS)
                .build();

        SecteurActiviteDTO ss =secteurActiviteService.addSecteurActivite(s);

        assertNotNull(ss);
        assertEquals(ss.getCodeSecteurActivite(), s.getCodeSecteurActivite());

    }
    @Test
    public void shouldDeleteSecteurActiviteSuccefully(){

        FournisseurDTO f1 =  FournisseurDTO.builder()
                .code("123")
                .build();

        Set<FournisseurDTO> fournisseurDTOS = new HashSet<FournisseurDTO>();
        fournisseurDTOS.add(f1);
        SecteurActiviteDTO s = SecteurActiviteDTO.builder()
                .codeSecteurActivite("123456789")
                .libelleSecteurActivite("best secteur ever")
                .fournisseurDTOS(fournisseurDTOS)
                .build();

        SecteurActiviteDTO ss =secteurActiviteService.addSecteurActivite(s);

        assertNotNull(ss);
        assertEquals(ss.getCodeSecteurActivite(), s.getCodeSecteurActivite());
        secteurActiviteService.deleteSecteurActivite(ss.getIdSecteurActivite());
        assertNull(secteurActiviteService.retrieveSecteurActivite(ss.getIdSecteurActivite()));


    }



}
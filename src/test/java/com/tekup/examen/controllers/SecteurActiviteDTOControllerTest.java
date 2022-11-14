package com.tekup.examen.controllers;

import com.tekup.examen.entities.FournisseurDTO;
import com.tekup.examen.entities.SecteurActiviteDTO;
import com.tekup.examen.services.ISecteurActiviteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SecteurActiviteDTOControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mvc;
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private ISecteurActiviteService secteurActiviteService;
    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void shoulAddSecteurActiviteSuccefully() throws Exception{
        FournisseurDTO f1 = FournisseurDTO.builder()
                .code("123")
                .build();
        Set<FournisseurDTO> fournisseurDTOS = new HashSet<FournisseurDTO>();
        fournisseurDTOS.add(f1);
        SecteurActiviteDTO s = SecteurActiviteDTO.builder()
                .codeSecteurActivite("123456789")
                .libelleSecteurActivite("best secteur ever")
                .fournisseurDTOS(fournisseurDTOS)
                .build();
        MvcResult result = mvc.perform(
                        post("/secteurActivite/add-secteurActivite")
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding("utf-8")
                                .content(objectMapper.writeValueAsString(s))
                ).andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        SecteurActiviteDTO createdSecteurActiviteDTO = objectMapper.readValue(result.getResponse().getContentAsString(), SecteurActiviteDTO.class);
        assertNotNull(createdSecteurActiviteDTO);
    }
    @Test
    public void shouldDeleteSecteurActiviteSuccefully() throws Exception{
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
        mvc.perform(
                        delete("/secteurActivite/remove-secteurActivite/"+ss.getIdSecteurActivite())
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    }
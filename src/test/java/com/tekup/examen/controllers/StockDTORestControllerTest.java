package com.tekup.examen.controllers;

import com.tekup.examen.entities.StockDTO;
import com.tekup.examen.services.IStockService;
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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StockDTORestControllerTest {
@Autowired
private WebApplicationContext webApplicationContext;
private MockMvc mvc;
    @Autowired
    IStockService stockService;
private final ObjectMapper objectMapper = new ObjectMapper();
    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
@Test
    public void shouldSaveStockSuccessfully() throws Exception {
    StockDTO s = new StockDTO("stock test",10,100);
    MvcResult result = mvc.perform(
            post("/stock/add-stock")
                    .contentType(MediaType.APPLICATION_JSON)
                    .characterEncoding("utf-8")
                    .content(objectMapper.writeValueAsString(s))
    ).andDo(print())
            .andExpect(status().isOk())
            .andReturn();
    StockDTO createdStockDTO = objectMapper.readValue(result.getResponse().getContentAsString(), StockDTO.class);
    assertNotNull(createdStockDTO);
}
    @Test
    public void ShouldDeleteStockSuccessfully() throws Exception {
        StockDTO s = new StockDTO("stock test",30,60);
        StockDTO savedStockDTO = stockService.addStock(s);
        StockDTO ss = stockService.retrieveStock(savedStockDTO.getIdStock());
        mvc.perform(
                delete("/stock/remove-stock/"+ss.getIdStock())
                        .contentType(MediaType.APPLICATION_JSON)

                )
                         .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void ShouldgetStockSuccessfully() throws Exception {
        StockDTO s = new StockDTO("stock test",30,60);
        StockDTO s1 = new StockDTO("stock111 test",10,60);
        StockDTO s2 = new StockDTO("stock222 test",20,60);
         stockService.addStock(s);
       stockService.addStock(s1);
       stockService.addStock(s2);

        mvc.perform(
                        get("/stock/retrieve-all-stocks/")
                                .contentType(MediaType.APPLICATION_JSON)

                )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}
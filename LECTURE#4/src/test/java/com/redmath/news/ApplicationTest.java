//package com.redmath.news;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.redmath.news.core.News;
//import org.junit.*;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import org.hamcrest.Matchers;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ApplicationTest {
//
//
//    @Autowired
//    private MockMvc mockMvc;
//
//@Test
//    public void testNewsPost() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/ver1/news")
//                        .contentType("application/json")
//                        .content("{\"id\":1,\"title\":\"title 1\",\"details\":\"details 1\",\"tags\":\"tags 1\"}"))
//                        .andDo(MockMvcResultHandlers.print())
//                        .andExpect(MockMvcResultMatchers.status().isConflict());
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/ver1/news")
//                        .contentType("application/json")
//                        .content("{\"title\":\"title 456\",\"details\":\"details 456\",\"tags\":\"tags 456\"}"))
//                        .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.notNullValue()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("title 456")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.details", Matchers.is("details 456")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.tags", Matchers.is("tags 456")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.reportedAt", Matchers.notNullValue()));
//    }
//
//
//    @Test
//    public void testGet() throws Exception{
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/ver1/news?title=%e 2%"))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful()
//        ); //title 2 de rhy to successful bcz exit krta e agr lekin yehi cheez hum 5 k lye krein to not found wala status ana chaye
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/ver1/news/1"))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("title 1")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.details", Matchers.is("details 1")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.tags", Matchers.is("tags 1")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.reportedAt", Matchers.notNullValue()));
//
//
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/ver1/news/1"))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("title 1")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.details", Matchers.is("details 1")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.tags", Matchers.is("tags 1")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.reportedAt", Matchers.notNullValue()));
//
//    }
//
//
//
//@Test
//    public void testPut() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/ver1/news/1")
//                        .contentType("application/json")
//                        .content("{\"title\":\"title 3\",\"details\":\"details 3\",\"tags\":\"tags 3\"}"))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
//    }
//}

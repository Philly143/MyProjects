package edu.miu.membership.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import edu.miu.membership.domain.Membership;
import edu.miu.membership.service.MembershipService;

import java.time.LocalDate;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {MembershipController.class})
@ExtendWith(SpringExtension.class)
class MembershipControllerTest {
    @Autowired
    private MembershipController membershipController;

    @MockBean
    private MembershipService membershipService;

    @Test
    void testFindAll() throws Exception {
        when(this.membershipService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/miu/memberships");
        MockMvcBuilders.standaloneSetup(this.membershipController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testFindAll2() throws Exception {
        when(this.membershipService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/miu/memberships");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.membershipController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testFindById() throws Exception {
        Membership membership = new Membership();
        membership.setEndDate(LocalDate.ofEpochDay(1L));
        membership.setId(123L);
        membership.setIsDeleted(true);
        membership.setStartDate(LocalDate.ofEpochDay(1L));
        membership.setTransactions(new ArrayList<>());
        when(this.membershipService.findById((Long) any())).thenReturn(membership);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/miu/memberships/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.membershipController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"startDate\":[1970,1,2],\"endDate\":[1970,1,2],\"transactions\":[],\"isDeleted\":true}"));
    }

    @Test
    void testFindById2() throws Exception {
        Membership membership = new Membership();
        membership.setEndDate(LocalDate.ofEpochDay(1L));
        membership.setId(123L);
        membership.setIsDeleted(true);
        membership.setStartDate(LocalDate.ofEpochDay(1L));
        membership.setTransactions(new ArrayList<>());
        when(this.membershipService.findById((Long) any())).thenReturn(membership);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/miu/memberships/{id}", 123L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.membershipController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"startDate\":[1970,1,2],\"endDate\":[1970,1,2],\"transactions\":[],\"isDeleted\":true}"));
    }
}


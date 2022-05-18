package edu.miu.membership.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.membership.domain.Plan;
import edu.miu.membership.enums.Plans;
import edu.miu.membership.enums.Role;
import edu.miu.membership.service.PlanService;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PlanController.class})
@ExtendWith(SpringExtension.class)
class PlanControllerTest {
    @Autowired
    private PlanController planController;

    @MockBean
    private PlanService planService;

    @Test
    void testFindAll() throws Exception {
        when(this.planService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/plans");
        MockMvcBuilders.standaloneSetup(this.planController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testFindAll2() throws Exception {
        when(this.planService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/plans");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.planController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testFindById() throws Exception {
        Plan plan = new Plan();
        plan.setDescription("The characteristics of someone or something");
        plan.setId(123L);
        plan.setIsDeleted(true);
        plan.setLocations(new HashSet<>());
        plan.setMemberships(new HashSet<>());
        plan.setName("Name");
        plan.setPlanType(Plans.LIMITED);
        plan.setRole(Role.STUDENT);
        when(this.planService.findById((Long) any())).thenReturn(plan);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/plans/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.planController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"description\":\"The characteristics of someone or something\",\"planType\":\"LIMITED"
                                        + "\",\"role\":\"STUDENT\",\"memberships\":[],\"locations\":[],\"isDeleted\":true}"));
    }

    @Test
    void testFindById2() throws Exception {
        Plan plan = new Plan();
        plan.setDescription("The characteristics of someone or something");
        plan.setId(123L);
        plan.setIsDeleted(true);
        plan.setLocations(new HashSet<>());
        plan.setMemberships(new HashSet<>());
        plan.setName("Name");
        plan.setPlanType(Plans.LIMITED);
        plan.setRole(Role.STUDENT);
        when(this.planService.findById((Long) any())).thenReturn(plan);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/plans/{id}", 123L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.planController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"description\":\"The characteristics of someone or something\",\"planType\":\"LIMITED"
                                        + "\",\"role\":\"STUDENT\",\"memberships\":[],\"locations\":[],\"isDeleted\":true}"));
    }

    @Test
    void testSave() throws Exception {
        when(this.planService.findAll()).thenReturn(new ArrayList<>());

        Plan plan = new Plan();
        plan.setDescription("The characteristics of someone or something");
        plan.setId(123L);
        plan.setIsDeleted(true);
        plan.setLocations(new HashSet<>());
        plan.setMemberships(new HashSet<>());
        plan.setName("Name");
        plan.setPlanType(Plans.LIMITED);
        plan.setRole(Role.STUDENT);
        String content = (new ObjectMapper()).writeValueAsString(plan);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/plans")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.planController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}


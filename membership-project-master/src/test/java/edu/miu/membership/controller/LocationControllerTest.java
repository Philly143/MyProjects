package edu.miu.membership.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.membership.domain.Location;
import edu.miu.membership.enums.LocationType;
import edu.miu.membership.service.LocationService;

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

@ContextConfiguration(classes = {LocationController.class})
@ExtendWith(SpringExtension.class)
class LocationControllerTest {
    @Autowired
    private LocationController locationController;

    @MockBean
    private LocationService locationService;

    @Test
    void testFindAll() throws Exception {
        when(this.locationService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/miu/locations");
        MockMvcBuilders.standaloneSetup(this.locationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testFindAll2() throws Exception {
        when(this.locationService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/miu/locations");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.locationController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetById() throws Exception {
        Location location = new Location();
        location.setCapacity(1L);
        location.setDescription("The characteristics of someone or something");
        location.setId(123L);
        location.setIsDeleted(true);
        location.setLocationType(LocationType.DINNING_HALL);
        location.setName("Name");
        location.setTimeSlots(new HashSet<>());
        location.setTransactions(new ArrayList<>());
        when(this.locationService.getById((Long) any())).thenReturn(location);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/miu/locations/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.locationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"locationType\":\"DINNING_HALL\",\"transactions\":[],\"timeSlots\":[],\"description\":\"The"
                                        + " characteristics of someone or something\",\"capacity\":1,\"isDeleted\":true}"));
    }

    @Test
    void testGetById2() throws Exception {
        Location location = new Location();
        location.setCapacity(1L);
        location.setDescription("The characteristics of someone or something");
        location.setId(123L);
        location.setIsDeleted(true);
        location.setLocationType(LocationType.DINNING_HALL);
        location.setName("Name");
        location.setTimeSlots(new HashSet<>());
        location.setTransactions(new ArrayList<>());
        when(this.locationService.getById((Long) any())).thenReturn(location);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/miu/locations/{id}", 123L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.locationController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"locationType\":\"DINNING_HALL\",\"transactions\":[],\"timeSlots\":[],\"description\":\"The"
                                        + " characteristics of someone or something\",\"capacity\":1,\"isDeleted\":true}"));
    }

    @Test
    void testSave() throws Exception {
        when(this.locationService.findAll()).thenReturn(new ArrayList<>());

        Location location = new Location();
        location.setCapacity(1L);
        location.setDescription("The characteristics of someone or something");
        location.setId(123L);
        location.setIsDeleted(true);
        location.setLocationType(LocationType.DINNING_HALL);
        location.setName("Name");
        location.setTimeSlots(new HashSet<>());
        location.setTransactions(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(location);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/miu/locations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.locationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}


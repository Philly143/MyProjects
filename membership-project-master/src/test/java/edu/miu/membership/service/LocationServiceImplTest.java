package edu.miu.membership.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import edu.miu.membership.domain.Location;
import edu.miu.membership.enums.LocationType;
import edu.miu.membership.repository.LocationRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {LocationServiceImpl.class})
@ExtendWith(SpringExtension.class)
class LocationServiceImplTest {
    @MockBean
    private LocationRepository locationRepository;

    @Autowired
    private LocationServiceImpl locationServiceImpl;

    @Test
    void testFindAll() {
        ArrayList<Location> locationList = new ArrayList<>();
        when(this.locationRepository.findAll()).thenReturn(locationList);
        List<Location> actualFindAllResult = this.locationServiceImpl.findAll();
        assertSame(locationList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(this.locationRepository).findAll();
    }

    @Test
    void testSave() {
        Location location = new Location();
        location.setCapacity(1L);
        location.setDescription("The characteristics of someone or something");
        location.setId(123L);
        location.setIsDeleted(true);
        location.setLocationType(LocationType.DINNING_HALL);
        location.setName("Name");
        location.setTimeSlots(new HashSet<>());
        location.setTransactions(new ArrayList<>());
        when(this.locationRepository.save((Location) any())).thenReturn(location);

        Location location1 = new Location();
        location1.setCapacity(1L);
        location1.setDescription("The characteristics of someone or something");
        location1.setId(123L);
        location1.setIsDeleted(true);
        location1.setLocationType(LocationType.DINNING_HALL);
        location1.setName("Name");
        location1.setTimeSlots(new HashSet<>());
        location1.setTransactions(new ArrayList<>());
        assertSame(location, this.locationServiceImpl.save(location1));
        verify(this.locationRepository).save((Location) any());
    }

    @Test
    void testGetById() {
        Location location = new Location();
        location.setCapacity(1L);
        location.setDescription("The characteristics of someone or something");
        location.setId(123L);
        location.setIsDeleted(true);
        location.setLocationType(LocationType.DINNING_HALL);
        location.setName("Name");
        location.setTimeSlots(new HashSet<>());
        location.setTransactions(new ArrayList<>());
        when(this.locationRepository.getById((Long) any())).thenReturn(location);
        assertSame(location, this.locationServiceImpl.getById(123L));
        verify(this.locationRepository).getById((Long) any());
    }
}


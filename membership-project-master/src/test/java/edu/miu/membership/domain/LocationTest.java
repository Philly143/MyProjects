package edu.miu.membership.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.miu.membership.enums.LocationType;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class LocationTest {
    @Test
    void testConstructor() {
        Location actualLocation = new Location();
        actualLocation.setCapacity(1L);
        actualLocation.setDescription("The characteristics of someone or something");
        actualLocation.setId(123L);
        actualLocation.setIsDeleted(true);
        actualLocation.setLocationType(LocationType.DINNING_HALL);
        actualLocation.setName("Name");
        HashSet<TimeSlot> timeSlotSet = new HashSet<>();
        actualLocation.setTimeSlots(timeSlotSet);
        ArrayList<Transaction> transactionList = new ArrayList<>();
        actualLocation.setTransactions(transactionList);
        assertEquals(1L, actualLocation.getCapacity().longValue());
        assertEquals("The characteristics of someone or something", actualLocation.getDescription());
        assertEquals(123L, actualLocation.getId().longValue());
        assertTrue(actualLocation.getIsDeleted());
        assertEquals(LocationType.DINNING_HALL, actualLocation.getLocationType());
        assertEquals("Name", actualLocation.getName());
        assertSame(timeSlotSet, actualLocation.getTimeSlots());
        assertSame(transactionList, actualLocation.getTransactions());
    }
}


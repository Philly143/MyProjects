package edu.miu.membership.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import edu.miu.membership.enums.Day;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

class TimeSlotTest {
    @Test
    void testConstructor() {
        TimeSlot actualTimeSlot = new TimeSlot();
        actualTimeSlot.setDay(Day.SUNDAY);
        actualTimeSlot.setEndTime(mock(Timestamp.class));
        actualTimeSlot.setId(123L);
        actualTimeSlot.setIsDeleted(true);
        actualTimeSlot.setSlot("Slot");
        actualTimeSlot.setStartTime(mock(Timestamp.class));
        assertEquals(Day.SUNDAY, actualTimeSlot.getDay());
        assertEquals(123L, actualTimeSlot.getId().longValue());
        assertTrue(actualTimeSlot.getIsDeleted());
        assertEquals("Slot", actualTimeSlot.getSlot());
    }
}


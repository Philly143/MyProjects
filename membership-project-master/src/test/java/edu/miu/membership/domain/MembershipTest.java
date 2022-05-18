package edu.miu.membership.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class MembershipTest {
    @Test
    void testConstructor() {
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        LocalDate ofEpochDayResult1 = LocalDate.ofEpochDay(1L);
        Membership actualMembership = new Membership(ofEpochDayResult, ofEpochDayResult1);

        LocalDate endDate = actualMembership.getEndDate();
        assertSame(ofEpochDayResult1, endDate);
        assertEquals("1970-01-02", endDate.toString());
        assertTrue(actualMembership.getTransactions().isEmpty());
        LocalDate startDate = actualMembership.getStartDate();
        assertSame(ofEpochDayResult, startDate);
        assertEquals("1970-01-02", startDate.toString());
        assertNull(actualMembership.getIsDeleted());
        assertNull(actualMembership.getId());
    }
}


package edu.miu.membership.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.miu.membership.enums.Status;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class BadgeTest {
    @Test
    void testConstructor() {
        Badge actualBadge = new Badge();
        actualBadge.setBarcode("Barcode");
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualBadge.setExpireDate(ofEpochDayResult);
        actualBadge.setId(123L);
        actualBadge.setIsDeleted(true);
        LocalDate ofEpochDayResult1 = LocalDate.ofEpochDay(1L);
        actualBadge.setIssueDate(ofEpochDayResult1);
        actualBadge.setStatus(Status.ACTIVE);
        ArrayList<Transaction> transactionList = new ArrayList<>();
        actualBadge.setTransactions(transactionList);
        assertEquals("Barcode", actualBadge.getBarcode());
        assertSame(ofEpochDayResult, actualBadge.getExpireDate());
        assertEquals(123L, actualBadge.getId().longValue());
        assertTrue(actualBadge.getIsDeleted());
        assertSame(ofEpochDayResult1, actualBadge.getIssueDate());
        assertEquals(Status.ACTIVE, actualBadge.getStatus());
        assertSame(transactionList, actualBadge.getTransactions());
    }
}


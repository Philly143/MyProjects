package edu.miu.membership.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

class TransactionTest {
    @Test
    void testConstructor() {
        Transaction actualTransaction = new Transaction();
        actualTransaction.setCheckIn(mock(Timestamp.class));
        actualTransaction.setCheckOut(mock(Timestamp.class));
        actualTransaction.setId(123L);
        actualTransaction.setIsDeleted(true);
        assertEquals(123L, actualTransaction.getId().longValue());
        assertTrue(actualTransaction.getIsDeleted());
    }

    @Test
    void testConstructor2() {
        Transaction actualTransaction = new Transaction(123L, mock(Timestamp.class), mock(Timestamp.class), true);
        actualTransaction.setCheckIn(mock(Timestamp.class));
        actualTransaction.setCheckOut(mock(Timestamp.class));
        actualTransaction.setId(123L);
        actualTransaction.setIsDeleted(true);
        assertEquals(123L, actualTransaction.getId().longValue());
        assertTrue(actualTransaction.getIsDeleted());
    }
}


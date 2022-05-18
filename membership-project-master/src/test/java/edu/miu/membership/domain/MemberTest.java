package edu.miu.membership.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

class MemberTest {
    @Test
    void testConstructor() {
        Member actualMember = new Member();
        HashSet<Badge> badgeSet = new HashSet<>();
        actualMember.setBadges(badgeSet);
        actualMember.setEmail("jane.doe@example.org");
        actualMember.setFirstName("Jane");
        actualMember.setId(123L);
        actualMember.setIsDeleted(true);
        actualMember.setLastName("Doe");
        HashSet<Membership> membershipSet = new HashSet<>();
        actualMember.setMemberships(membershipSet);
        actualMember.setPhone("4105551212");
        assertSame(badgeSet, actualMember.getBadges());
        assertEquals("jane.doe@example.org", actualMember.getEmail());
        assertEquals("Jane", actualMember.getFirstName());
        assertEquals(123L, actualMember.getId().longValue());
        assertTrue(actualMember.getIsDeleted());
        assertEquals("Doe", actualMember.getLastName());
        assertSame(membershipSet, actualMember.getMemberships());
        assertEquals("4105551212", actualMember.getPhone());
    }
}


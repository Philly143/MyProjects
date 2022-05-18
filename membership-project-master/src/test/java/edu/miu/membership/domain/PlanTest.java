package edu.miu.membership.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.miu.membership.enums.Plans;
import edu.miu.membership.enums.Role;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

class PlanTest {
    @Test
    void testConstructor() {
        Plan actualPlan = new Plan();
        actualPlan.setDescription("The characteristics of someone or something");
        actualPlan.setId(123L);
        actualPlan.setIsDeleted(true);
        HashSet<Location> locationSet = new HashSet<>();
        actualPlan.setLocations(locationSet);
        HashSet<Membership> membershipSet = new HashSet<>();
        actualPlan.setMemberships(membershipSet);
        actualPlan.setName("Name");
        actualPlan.setPlanType(Plans.LIMITED);
        actualPlan.setRole(Role.STUDENT);
        assertEquals("The characteristics of someone or something", actualPlan.getDescription());
        assertEquals(123L, actualPlan.getId().longValue());
        assertTrue(actualPlan.getIsDeleted());
        assertSame(locationSet, actualPlan.getLocations());
        assertSame(membershipSet, actualPlan.getMemberships());
        assertEquals("Name", actualPlan.getName());
        assertEquals(Plans.LIMITED, actualPlan.getPlanType());
        assertEquals(Role.STUDENT, actualPlan.getRole());
    }
}


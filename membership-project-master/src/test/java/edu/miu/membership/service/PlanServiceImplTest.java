package edu.miu.membership.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import edu.miu.membership.domain.Plan;
import edu.miu.membership.enums.Plans;
import edu.miu.membership.enums.Role;
import edu.miu.membership.repository.PlanRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PlanServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PlanServiceImplTest {
    @MockBean
    private PlanRepository planRepository;

    @Autowired
    private PlanServiceImpl planServiceImpl;

    @Test
    void testSave() {
        Plan plan = new Plan();
        plan.setDescription("The characteristics of someone or something");
        plan.setId(123L);
        plan.setIsDeleted(true);
        plan.setLocations(new HashSet<>());
        plan.setMemberships(new HashSet<>());
        plan.setName("Name");
        plan.setPlanType(Plans.LIMITED);
        plan.setRole(Role.STUDENT);
        when(this.planRepository.save((Plan) any())).thenReturn(plan);

        Plan plan1 = new Plan();
        plan1.setDescription("The characteristics of someone or something");
        plan1.setId(123L);
        plan1.setIsDeleted(true);
        plan1.setLocations(new HashSet<>());
        plan1.setMemberships(new HashSet<>());
        plan1.setName("Name");
        plan1.setPlanType(Plans.LIMITED);
        plan1.setRole(Role.STUDENT);
        assertSame(plan, this.planServiceImpl.save(plan1));
        verify(this.planRepository).save((Plan) any());
    }

    @Test
    void testFindAll() {
        ArrayList<Plan> planList = new ArrayList<>();
        when(this.planRepository.findAll()).thenReturn(planList);
        List<Plan> actualFindAllResult = this.planServiceImpl.findAll();
        assertSame(planList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(this.planRepository).findAll();
    }

    @Test
    void testFindById() {
        Plan plan = new Plan();
        plan.setDescription("The characteristics of someone or something");
        plan.setId(123L);
        plan.setIsDeleted(true);
        plan.setLocations(new HashSet<>());
        plan.setMemberships(new HashSet<>());
        plan.setName("Name");
        plan.setPlanType(Plans.LIMITED);
        plan.setRole(Role.STUDENT);
        Optional<Plan> ofResult = Optional.of(plan);
        when(this.planRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(plan, this.planServiceImpl.findById(123L));
        verify(this.planRepository).findById((Long) any());
    }
}


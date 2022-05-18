package edu.miu.membership.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import edu.miu.membership.domain.Membership;
import edu.miu.membership.repository.MembershipRepository;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MembershipServiceImpl.class})
@ExtendWith(SpringExtension.class)
class MembershipServiceImplTest {
    @MockBean
    private MembershipRepository membershipRepository;

    @Autowired
    private MembershipServiceImpl membershipServiceImpl;

    @Test
    void testFindAll() {
        ArrayList<Membership> membershipList = new ArrayList<>();
        when(this.membershipRepository.findAll()).thenReturn(membershipList);
        List<Membership> actualFindAllResult = this.membershipServiceImpl.findAll();
        assertSame(membershipList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(this.membershipRepository).findAll();
    }

    @Test
    void testFindById() {
        Membership membership = new Membership();
        membership.setEndDate(LocalDate.ofEpochDay(1L));
        membership.setId(123L);
        membership.setIsDeleted(true);
        membership.setStartDate(LocalDate.ofEpochDay(1L));
        membership.setTransactions(new ArrayList<>());
        Optional<Membership> ofResult = Optional.of(membership);
        when(this.membershipRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(membership, this.membershipServiceImpl.findById(123L));
        verify(this.membershipRepository).findById((Long) any());
    }
}


package edu.miu.membership.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import edu.miu.membership.domain.Member;
import edu.miu.membership.domain.Membership;
import edu.miu.membership.dto.MemberDto;
import edu.miu.membership.dto.MembershipDto;
import edu.miu.membership.exception.custom.EntityNotFoundException;
import edu.miu.membership.modelmapper.MapStruct;
import edu.miu.membership.repository.MemberRepository;
import edu.miu.membership.repository.MembershipRepository;
import edu.miu.membership.repository.PlanRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.config.Configuration;
import org.modelmapper.internal.InheritingConfiguration;
import org.modelmapper.internal.TypeResolvingList;
import org.modelmapper.spi.ConditionalConverter;
import org.modelmapper.spi.ValueReader;
import org.modelmapper.spi.ValueWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MemberServiceImpl.class})
@ExtendWith(SpringExtension.class)
class MemberServiceImplTest {
    @MockBean
    private MapStruct mapStruct;

    @MockBean
    private MemberRepository memberRepository;

    @Autowired
    private MemberServiceImpl memberServiceImpl;

    @MockBean
    private MembershipRepository membershipRepository;

    @MockBean
    private ModelMapper modelMapper;

    @MockBean
    private PlanRepository planRepository;

    @Test
    void testConstructor() {
        MemberRepository memberRepository = mock(MemberRepository.class);
        ModelMapper modelMapper = new ModelMapper();
        MemberServiceImpl actualMemberServiceImpl = new MemberServiceImpl(memberRepository, modelMapper, new MapStruct());
        Membership membership = new Membership();
        membership.setEndDate(LocalDate.ofEpochDay(1L));
        membership.setId(123L);
        membership.setIsDeleted(true);
        membership.setStartDate(LocalDate.ofEpochDay(1L));
        membership.setTransactions(new ArrayList<>());
        actualMemberServiceImpl.saveMembership(123L, membership);
        actualMemberServiceImpl.savePlan(123L, 123L);
        Configuration configuration = modelMapper.getConfiguration();
        List<ConditionalConverter<?, ?>> expectedConverters = configuration.getConverters();
        assertSame(expectedConverters, ((InheritingConfiguration) configuration).converterStore.getConverters());
        Collection<TypeMap<?, ?>> expectedGetResult = modelMapper.getTypeMaps();
        assertSame(expectedGetResult, ((InheritingConfiguration) configuration).typeMapStore.get());
        assertSame(configuration.getValueReaders(),
                ((InheritingConfiguration) configuration).valueAccessStore.getValueReaders());
        assertSame(configuration.getValueWriters(),
                ((InheritingConfiguration) configuration).valueMutateStore.getValueWriters());
    }

    @Test
    void testFindAllMembers() {
        when(this.memberRepository.findAllMembers()).thenReturn(new ArrayList<>());
        assertTrue(this.memberServiceImpl.findAllMembers().isEmpty());
        verify(this.memberRepository).findAllMembers();
    }

    @Test
    void testFindAllMembers2() {
        Member member = new Member();
        member.setBadges(new HashSet<>());
        member.setEmail("jane.doe@example.org");
        member.setFirstName("Jane");
        member.setId(123L);
        member.setIsDeleted(true);
        member.setLastName("Doe");
        member.setMemberships(new HashSet<>());
        member.setPhone("4105551212");

        ArrayList<Member> memberList = new ArrayList<>();
        memberList.add(member);
        when(this.memberRepository.findAllMembers()).thenReturn(memberList);
        HashSet<MembershipDto> memberships = new HashSet<>();
        when(this.mapStruct.convertToMemberDto((Member) any())).thenReturn(
                new MemberDto(123L, "Jane", "Doe", "4105551212", "jane.doe@example.org", memberships, new HashSet<>(), true));
        assertEquals(1, this.memberServiceImpl.findAllMembers().size());
        verify(this.memberRepository).findAllMembers();
        verify(this.mapStruct).convertToMemberDto((Member) any());
    }

    @Test
    void testFindAllMembers3() {
        Member member = new Member();
        member.setBadges(new HashSet<>());
        member.setEmail("jane.doe@example.org");
        member.setFirstName("Jane");
        member.setId(123L);
        member.setIsDeleted(true);
        member.setLastName("Doe");
        member.setMemberships(new HashSet<>());
        member.setPhone("4105551212");

        Member member1 = new Member();
        member1.setBadges(new HashSet<>());
        member1.setEmail("jane.doe@example.org");
        member1.setFirstName("Jane");
        member1.setId(123L);
        member1.setIsDeleted(true);
        member1.setLastName("Doe");
        member1.setMemberships(new HashSet<>());
        member1.setPhone("4105551212");

        ArrayList<Member> memberList = new ArrayList<>();
        memberList.add(member1);
        memberList.add(member);
        when(this.memberRepository.findAllMembers()).thenReturn(memberList);
        HashSet<MembershipDto> memberships = new HashSet<>();
        when(this.mapStruct.convertToMemberDto((Member) any())).thenReturn(
                new MemberDto(123L, "Jane", "Doe", "4105551212", "jane.doe@example.org", memberships, new HashSet<>(), true));
        assertEquals(2, this.memberServiceImpl.findAllMembers().size());
        verify(this.memberRepository).findAllMembers();
        verify(this.mapStruct, atLeast(1)).convertToMemberDto((Member) any());
    }

    @Test
    void testFindAllMembers4() {
        Member member = new Member();
        member.setBadges(new HashSet<>());
        member.setEmail("jane.doe@example.org");
        member.setFirstName("Jane");
        member.setId(123L);
        member.setIsDeleted(true);
        member.setLastName("Doe");
        member.setMemberships(new HashSet<>());
        member.setPhone("4105551212");

        ArrayList<Member> memberList = new ArrayList<>();
        memberList.add(member);
        when(this.memberRepository.findAllMembers()).thenReturn(memberList);
        when(this.mapStruct.convertToMemberDto((Member) any())).thenThrow(new EntityNotFoundException("An error occurred"));
        assertThrows(EntityNotFoundException.class, () -> this.memberServiceImpl.findAllMembers());
        verify(this.memberRepository).findAllMembers();
        verify(this.mapStruct).convertToMemberDto((Member) any());
    }

    @Test
    void testSave() {
        Member member = new Member();
        member.setBadges(new HashSet<>());
        member.setEmail("jane.doe@example.org");
        member.setFirstName("Jane");
        member.setId(123L);
        member.setIsDeleted(true);
        member.setLastName("Doe");
        member.setMemberships(new HashSet<>());
        member.setPhone("4105551212");
        when(this.memberRepository.save((Member) any())).thenReturn(member);

        Member member1 = new Member();
        member1.setBadges(new HashSet<>());
        member1.setEmail("jane.doe@example.org");
        member1.setFirstName("Jane");
        member1.setId(123L);
        member1.setIsDeleted(true);
        member1.setLastName("Doe");
        member1.setMemberships(new HashSet<>());
        member1.setPhone("4105551212");
        assertSame(member, this.memberServiceImpl.save(member1));
        verify(this.memberRepository).save((Member) any());
    }

    @Test
    void testSave2() {
        when(this.memberRepository.save((Member) any())).thenThrow(new EntityNotFoundException("An error occurred"));

        Member member = new Member();
        member.setBadges(new HashSet<>());
        member.setEmail("jane.doe@example.org");
        member.setFirstName("Jane");
        member.setId(123L);
        member.setIsDeleted(true);
        member.setLastName("Doe");
        member.setMemberships(new HashSet<>());
        member.setPhone("4105551212");
        assertThrows(EntityNotFoundException.class, () -> this.memberServiceImpl.save(member));
        verify(this.memberRepository).save((Member) any());
    }

    @Test
    void testFindById() {
        Member member = new Member();
        member.setBadges(new HashSet<>());
        member.setEmail("jane.doe@example.org");
        member.setFirstName("Jane");
        member.setId(123L);
        member.setIsDeleted(true);
        member.setLastName("Doe");
        member.setMemberships(new HashSet<>());
        member.setPhone("4105551212");
        Optional<Member> ofResult = Optional.of(member);
        when(this.memberRepository.findById((Long) any())).thenReturn(ofResult);
        HashSet<MembershipDto> memberships = new HashSet<>();
        when(this.mapStruct.convertToMemberDto((Member) any())).thenReturn(
                new MemberDto(123L, "Jane", "Doe", "4105551212", "jane.doe@example.org", memberships, new HashSet<>(), true));
        assertTrue(this.memberServiceImpl.findById(123L).isPresent());
        verify(this.memberRepository).findById((Long) any());
        verify(this.mapStruct).convertToMemberDto((Member) any());
    }

    @Test
    void testFindById2() {
        Member member = new Member();
        member.setBadges(new HashSet<>());
        member.setEmail("jane.doe@example.org");
        member.setFirstName("Jane");
        member.setId(123L);
        member.setIsDeleted(true);
        member.setLastName("Doe");
        member.setMemberships(new HashSet<>());
        member.setPhone("4105551212");
        Optional<Member> ofResult = Optional.of(member);
        when(this.memberRepository.findById((Long) any())).thenReturn(ofResult);
        when(this.mapStruct.convertToMemberDto((Member) any())).thenThrow(new EntityNotFoundException("An error occurred"));
        assertThrows(EntityNotFoundException.class, () -> this.memberServiceImpl.findById(123L));
        verify(this.memberRepository).findById((Long) any());
        verify(this.mapStruct).convertToMemberDto((Member) any());
    }

    @Test
    void testFindById3() {
        when(this.memberRepository.findById((Long) any())).thenReturn(Optional.empty());
        HashSet<MembershipDto> memberships = new HashSet<>();
        when(this.mapStruct.convertToMemberDto((Member) any())).thenReturn(
                new MemberDto(123L, "Jane", "Doe", "4105551212", "jane.doe@example.org", memberships, new HashSet<>(), true));
        assertThrows(EntityNotFoundException.class, () -> this.memberServiceImpl.findById(123L));
        verify(this.memberRepository).findById((Long) any());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testFindById4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.util.Objects.requireNonNull(Objects.java:221)
        //       at java.util.Optional.<init>(Optional.java:107)
        //       at java.util.Optional.of(Optional.java:120)
        //       at edu.miu.membership.service.MemberServiceImpl.findById(MemberServiceImpl.java:72)
        //   In order to prevent findById(Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findById(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        Member member = new Member();
        member.setBadges(new HashSet<>());
        member.setEmail("jane.doe@example.org");
        member.setFirstName("Jane");
        member.setId(123L);
        member.setIsDeleted(true);
        member.setLastName("Doe");
        member.setMemberships(new HashSet<>());
        member.setPhone("4105551212");
        Optional<Member> ofResult = Optional.of(member);
        when(this.memberRepository.findById((Long) any())).thenReturn(ofResult);
        when(this.mapStruct.convertToMemberDto((Member) any())).thenReturn(null);
        this.memberServiceImpl.findById(123L);
    }

    @Test
    void testGetPlans() {
        assertNull(this.memberServiceImpl.getPlans(123L));
    }
}


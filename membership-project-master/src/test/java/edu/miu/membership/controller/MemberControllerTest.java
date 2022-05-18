package edu.miu.membership.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.membership.domain.Member;
import edu.miu.membership.domain.Membership;
import edu.miu.membership.domain.Transaction;
import edu.miu.membership.dto.MemberDto;
import edu.miu.membership.dto.MembershipDto;
import edu.miu.membership.service.MemberServiceImpl;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {MemberController.class})
@ExtendWith(SpringExtension.class)
class MemberControllerTest {
    @Autowired
    private MemberController memberController;

    @MockBean
    private MemberServiceImpl memberServiceImpl;

    @Test
    void testFindAllMember() throws Exception {
        when(this.memberServiceImpl.findAllMembers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/miu/members");
        MockMvcBuilders.standaloneSetup(this.memberController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testSaveMembership() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of MemberController.
        //   Add a package-visible constructor or a factory method for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at edu.miu.membership.controller.MemberController.saveMembership(MemberController.java:58)
        //   In order to prevent saveMembership(Long, Membership)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   saveMembership(Long, Membership).
        //   See https://diff.blue/R013 to resolve this issue.

        MemberController memberController = new MemberController(null);

        Membership membership = new Membership();
        membership.setEndDate(LocalDate.ofEpochDay(1L));
        membership.setId(123L);
        membership.setIsDeleted(true);
        membership.setStartDate(LocalDate.ofEpochDay(1L));
        membership.setTransactions(new ArrayList<>());
        memberController.saveMembership(123L, membership);
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testSaveMembership2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of MemberController.
        //   Add a package-visible constructor or a factory method for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at edu.miu.membership.controller.MemberController.saveMembership(MemberController.java:58)
        //   In order to prevent saveMembership(Long, Membership)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   saveMembership(Long, Membership).
        //   See https://diff.blue/R013 to resolve this issue.

        MemberController memberController = new MemberController(null);
        Membership membership = mock(Membership.class);
        doNothing().when(membership).setEndDate((LocalDate) any());
        doNothing().when(membership).setId((Long) any());
        doNothing().when(membership).setIsDeleted((Boolean) any());
        doNothing().when(membership).setStartDate((LocalDate) any());
        doNothing().when(membership).setTransactions((java.util.List<Transaction>) any());
        membership.setEndDate(LocalDate.ofEpochDay(1L));
        membership.setId(123L);
        membership.setIsDeleted(true);
        membership.setStartDate(LocalDate.ofEpochDay(1L));
        membership.setTransactions(new ArrayList<>());
        memberController.saveMembership(123L, membership);
    }

    @Test
    void testSaveMembership3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of MemberController.
        //   Add a package-visible constructor or a factory method for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008

        MemberServiceImpl memberServiceImpl = mock(MemberServiceImpl.class);
        doNothing().when(memberServiceImpl).saveMembership((Long) any(), (Membership) any());
        MemberController memberController = new MemberController(memberServiceImpl);
        Membership membership = mock(Membership.class);
        doNothing().when(membership).setEndDate((LocalDate) any());
        doNothing().when(membership).setId((Long) any());
        doNothing().when(membership).setIsDeleted((Boolean) any());
        doNothing().when(membership).setStartDate((LocalDate) any());
        doNothing().when(membership).setTransactions((java.util.List<Transaction>) any());
        membership.setEndDate(LocalDate.ofEpochDay(1L));
        membership.setId(123L);
        membership.setIsDeleted(true);
        membership.setStartDate(LocalDate.ofEpochDay(1L));
        membership.setTransactions(new ArrayList<>());
        memberController.saveMembership(123L, membership);
        verify(memberServiceImpl).saveMembership((Long) any(), (Membership) any());
        verify(membership).setEndDate((LocalDate) any());
        verify(membership).setId((Long) any());
        verify(membership).setIsDeleted((Boolean) any());
        verify(membership).setStartDate((LocalDate) any());
        verify(membership).setTransactions((java.util.List<Transaction>) any());
    }

    @Test
    void testFindAllMember2() throws Exception {
        when(this.memberServiceImpl.findAllMembers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/miu/members");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.memberController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testFindOneMember() throws Exception {
        HashSet<MembershipDto> memberships = new HashSet<>();
        when(this.memberServiceImpl.findById((Long) any())).thenReturn(Optional.of(
                new MemberDto(123L, "Jane", "Doe", "4105551212", "jane.doe@example.org", memberships, new HashSet<>(), true)));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/miu/members/{memberId}", 123L);
        MockMvcBuilders.standaloneSetup(this.memberController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"member_id\":123,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"phone\":\"4105551212\",\"email\":\"jane.doe@example"
                                        + ".org\",\"memberships\":[],\"badges\":[],\"isDeleted\":true}"));
    }

    @Test
    void testFindOneMember2() throws Exception {
        HashSet<MembershipDto> memberships = new HashSet<>();
        when(this.memberServiceImpl.findById((Long) any())).thenReturn(Optional.of(
                new MemberDto(123L, "Jane", "Doe", "4105551212", "jane.doe@example.org", memberships, new HashSet<>(), true)));
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/miu/members/{memberId}", 123L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.memberController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"member_id\":123,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"phone\":\"4105551212\",\"email\":\"jane.doe@example"
                                        + ".org\",\"memberships\":[],\"badges\":[],\"isDeleted\":true}"));
    }

    @Test
    void testGetMemberships() throws Exception {
        when(this.memberServiceImpl.getPlans((Long) any())).thenReturn(new HashSet<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/miu/members/{memberId}/memberships",
                123L);
        MockMvcBuilders.standaloneSetup(this.memberController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetMemberships2() throws Exception {
        when(this.memberServiceImpl.getPlans((Long) any())).thenReturn(new HashSet<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/miu/members/{memberId}/memberships",
                123L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.memberController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testSaveMember() throws Exception {
        when(this.memberServiceImpl.findAllMembers()).thenReturn(new ArrayList<>());

        Member member = new Member();
        member.setBadges(new HashSet<>());
        member.setEmail("jane.doe@example.org");
        member.setFirstName("Jane");
        member.setId(123L);
        member.setIsDeleted(true);
        member.setLastName("Doe");
        member.setMemberships(new HashSet<>());
        member.setPhone("4105551212");
        String content = (new ObjectMapper()).writeValueAsString(member);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/miu/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.memberController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testUpdateMember() throws Exception {
        Member member = new Member();
        member.setBadges(new HashSet<>());
        member.setEmail("jane.doe@example.org");
        member.setFirstName("Jane");
        member.setId(123L);
        member.setIsDeleted(true);
        member.setLastName("Doe");
        member.setMemberships(new HashSet<>());
        member.setPhone("4105551212");
        when(this.memberServiceImpl.save((Member) any())).thenReturn(member);
        HashSet<MembershipDto> memberships = new HashSet<>();
        when(this.memberServiceImpl.findById((Long) any())).thenReturn(Optional.of(
                new MemberDto(123L, "Jane", "Doe", "4105551212", "jane.doe@example.org", memberships, new HashSet<>(), true)));

        Member member1 = new Member();
        member1.setBadges(new HashSet<>());
        member1.setEmail("jane.doe@example.org");
        member1.setFirstName("Jane");
        member1.setId(123L);
        member1.setIsDeleted(true);
        member1.setLastName("Doe");
        member1.setMemberships(new HashSet<>());
        member1.setPhone("4105551212");
        String content = (new ObjectMapper()).writeValueAsString(member1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/miu/members/{memberId}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.memberController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"phone\":\"4105551212\",\"email\":\"jane.doe@example.org\",\"memberships"
                                        + "\":[],\"badges\":[],\"isDeleted\":true,\"member_id\":123}"));
    }
}


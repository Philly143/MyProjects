package edu.miu.membership.repository;

import edu.miu.membership.domain.Member;
import edu.miu.membership.domain.Membership;
import edu.miu.membership.domain.Transaction;
import edu.miu.membership.dto.MemberDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/15/22
 */
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("from Member ")
    List<Member> findAllMembers();

    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO member('membership_id','member_id','plan_id','end_date', 'start_date', 'is_deleted') " +
            "values (12,1,1,'2022-05-10','2022-05-10', false)")
    void addMemberShip(@Param("memberId") Long memberId,
                       @Param("planId") Long planId,
                       @Param("membership") Membership membership);

    @Query("Select transaction from Member  m join m.badges badge join badge.transactions transaction where m.id =:memberId")
    List<Transaction> findAllTransactions(@Param("memberId") Long memberId);
}

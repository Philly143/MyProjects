package edu.miu.membership.service;

import edu.miu.membership.domain.Member;
import edu.miu.membership.domain.Membership;
import edu.miu.membership.domain.Plan;
import edu.miu.membership.domain.Transaction;
import edu.miu.membership.dto.MemberDto;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/15/22
 */
public interface MemberService {
    List<MemberDto> findAllMembers();


    void deleteById(Long id);

    Member save(Member member) throws IOException, BarcodeException, OutputException;


    void updateAllTables(Member member);
    void addMemberShip(Long memberId, Long planId, Membership membership);

    void savePlan(Long memberId, Long planId);
    void deleteMemberById(Long memberId);

   Optional<MemberDto> findById(Long memberId);
    List<Transaction> getTransactions(Long memberId);
}

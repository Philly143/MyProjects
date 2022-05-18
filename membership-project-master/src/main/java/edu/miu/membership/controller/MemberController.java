package edu.miu.membership.controller;

import edu.miu.membership.domain.Member;
import edu.miu.membership.domain.Membership;
import edu.miu.membership.domain.Plan;
import edu.miu.membership.dto.MemberDto;
import edu.miu.membership.exception.custom.EntityNotFoundException;
import edu.miu.membership.service.MemberServiceImpl;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/15/22
 */
@RestController
@RequestMapping( "/api/miu/members")
public class MemberController {
    private MemberServiceImpl memberServiceImpl;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @GetMapping("/test")
    public String test(){
        return "This is test";
    }
    @Autowired
    MemberController(MemberServiceImpl memberServiceImpl) {
        this.memberServiceImpl = memberServiceImpl;
    }
    @GetMapping()
    public ResponseEntity<List<MemberDto>> findAllMember() {
     return ResponseEntity.ok(memberServiceImpl.findAllMembers());
    }
    @GetMapping("/{memberId}")
    public ResponseEntity<?> findOneMember(@PathVariable Long memberId) {
        Optional<MemberDto> member = memberServiceImpl.findById(memberId);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Member> saveMember(@RequestBody Member member) throws IOException, OutputException, BarcodeException {
        return new ResponseEntity<>(memberServiceImpl.save(member), HttpStatus.CREATED);
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<String> updateMember(@RequestBody Member member, @PathVariable Long memberId){
        member.setId(memberId);
        memberServiceImpl.findById(memberId).orElseThrow(()-> new EntityNotFoundException(String.format("Id  %s doesnt  exist ",memberId)));
        memberServiceImpl.save(member);
        return new ResponseEntity<>(String.format("Member with id %s updated", memberId),HttpStatus.OK);
    }

/*    @DeleteMapping("/{memberId}")
    public ResponseEntity<String> deleteMember(@PathVariable Long memberId){
        //set deleteFlag = true for every linked tables
        Member member = memberServiceImpl.findById(memberId).orElseThrow(()-> new EntityNotFoundException(String.format("Id  %s doesnt  exist ",memberId)));
        memberServiceImpl.updateAllTables(member);
        return new ResponseEntity<>(String.format("Member with id %s deleted", memberId),HttpStatus.OK);
    }*/

    @DeleteMapping("/{memberId}")
    public ResponseEntity<String> deleteMember(@PathVariable Long memberId){
        memberServiceImpl.deleteMemberById(memberId);
        return new ResponseEntity<>(String.format("Member with id %s deleted", memberId),HttpStatus.OK);
    }

    @PostMapping("/{memberId}/membership")
    public ResponseEntity<?> saveMember(
            @PathVariable Long memberId,
            @RequestParam Long planId,
            @RequestBody Membership membership) {
        memberServiceImpl.addMemberShip(memberId, planId, membership);
        return new ResponseEntity<>("Member added", HttpStatus.CREATED);
    }

    @PostMapping("/{memberId}/memberships")
    public void saveMembership(@PathVariable Long memberId, @RequestBody Membership membership){
        memberServiceImpl.saveMembership(memberId, membership);
    }

    @GetMapping("/{memberId}/memberships")
    public Set<Plan> getMemberships(@PathVariable Long memberId){
        return memberServiceImpl.getPlans(memberId);
    }
    @GetMapping("/{memberId}/transactions")
    public ResponseEntity<?> getTransactions(@PathVariable Long memberId){
        return new ResponseEntity<>(memberServiceImpl.getTransactions(memberId), HttpStatus.OK);
    }
}

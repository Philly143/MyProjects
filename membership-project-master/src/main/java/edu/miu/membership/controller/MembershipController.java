package edu.miu.membership.controller;

import edu.miu.membership.domain.Member;
import edu.miu.membership.domain.Membership;
import edu.miu.membership.domain.Plan;
import edu.miu.membership.exception.custom.EntityNotFoundException;
import edu.miu.membership.service.MembershipService;
import edu.miu.membership.service.PlanService;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping( "/api/miu/memberships")
public class MembershipController {

    MembershipService membershipService;

    @Autowired
    MembershipController(MembershipService membershipService){
        this.membershipService = membershipService;
    }

    @GetMapping()
    public ResponseEntity<List<Membership>> findAll(){
        return ResponseEntity.ok(membershipService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(membershipService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Membership> save(@RequestBody Membership membership) throws IOException, OutputException, BarcodeException {
        return new ResponseEntity<>(membershipService.save(membership), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        membershipService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Membership> update(@RequestBody Membership membership, @PathVariable Long id){
        membership.setId(id);
        membershipService.findById(id).orElseThrow(()-> new EntityNotFoundException(String.format("Id  %s doesnt  exist ",id)));
        return new ResponseEntity<>(membershipService.save(membership), HttpStatus.OK);
    }
}

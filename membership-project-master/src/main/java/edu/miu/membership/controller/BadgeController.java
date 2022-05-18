package edu.miu.membership.controller;


import edu.miu.membership.domain.Badge;
import edu.miu.membership.domain.Location;
import edu.miu.membership.domain.Member;
import edu.miu.membership.dto.BadgeDto;
import edu.miu.membership.dto.MemberDto;
import edu.miu.membership.exception.custom.EntityNotFoundException;
import edu.miu.membership.service.BadgeService;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/miu/badges")
public class BadgeController {

    BadgeService badgeService;

    @Autowired
    BadgeController(BadgeService badgeService){
        this.badgeService = badgeService;
    }

    @GetMapping()
    public ResponseEntity<List<BadgeDto>> findAll() {
        return ResponseEntity.ok(badgeService.findAll());
    }

    @PostMapping()
    public ResponseEntity<Badge> save(@RequestBody Badge badge) throws IOException, OutputException, BarcodeException {
        return new ResponseEntity<>(badgeService.save(badge), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(badgeService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        badgeService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Badge> update(@RequestBody Badge badge, @PathVariable Long id){
        badge.setId(id);
        badgeService.findById(id).orElseThrow(()-> new EntityNotFoundException(String.format("Id  %s doesnt  exist ",id)));
        return new ResponseEntity<>(badgeService.save(badge), HttpStatus.OK);
    }
}

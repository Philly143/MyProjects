package edu.miu.membership.controller;


import edu.miu.membership.domain.Badge;
import edu.miu.membership.domain.Member;
import edu.miu.membership.domain.Plan;
import edu.miu.membership.exception.custom.EntityAlreadyExistException;
import edu.miu.membership.exception.custom.EntityNotFoundException;
import edu.miu.membership.service.PlanService;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Asma Aiouez
 * @DATE 5/16/22
 */

@RestController
@RequestMapping("/api/miu/plans")
public class PlanController {

    PlanService planService;

    @Autowired
    PlanController(PlanService planService){
        this.planService = planService;
    }


    @PostMapping()
    public ResponseEntity<Plan> save(@RequestBody Plan plan) throws IOException, OutputException, BarcodeException {
        return new ResponseEntity<>(planService.save(plan), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Plan>> findAll(){
        return ResponseEntity.ok(planService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(planService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        planService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plan> update(@RequestBody Plan plan, @PathVariable Long id){
        plan.setId(id);
        planService.findById(id).orElseThrow(()-> new EntityNotFoundException(String.format("Id  %s doesnt  exist ",id)));
        return new ResponseEntity<>(planService.save(plan), HttpStatus.OK);
    }
}

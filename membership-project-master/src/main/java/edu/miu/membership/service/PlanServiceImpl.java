package edu.miu.membership.service;

import edu.miu.membership.domain.Member;
import edu.miu.membership.domain.Membership;
import edu.miu.membership.domain.Plan;
import edu.miu.membership.dto.MemberDto;
import edu.miu.membership.dto.MembershipDto;
import edu.miu.membership.dto.PlanDto;
import edu.miu.membership.exception.custom.EntityNotFoundException;
import edu.miu.membership.modelmapper.MapStruct;
import edu.miu.membership.repository.MembershipRepository;
import edu.miu.membership.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Asma Aiouez
 * @DATE 5/16/22
 */

@Service
@Transactional
public class PlanServiceImpl implements PlanService{

    private PlanRepository planRepository;
    private MapStruct mapStruct;

    @Autowired
    PlanServiceImpl(PlanRepository planRepository, MapStruct mapStruct){
        this.planRepository = planRepository;
        this.mapStruct = mapStruct;
    }

    public Plan save(Plan plan){
        return planRepository.save(plan);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Plan> findAll() {
        return planRepository.findAll();
    }


    @Override
    public Optional<PlanDto> findById(Long id) {
        Plan plan = planRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id+ " not found"));
        return Optional.of(mapStruct.convertToPlanDto(plan));
    }

    @Override
    public void deleteById(Long id) {
        planRepository.deleteById(id);
    }

}


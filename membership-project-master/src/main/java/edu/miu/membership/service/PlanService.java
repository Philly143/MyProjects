package edu.miu.membership.service;


import edu.miu.membership.domain.Plan;
import edu.miu.membership.dto.PlanDto;

import java.util.List;
import java.util.Optional;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Asma Aiouez
 * @DATE 5/16/22
 */

public interface PlanService {

    Plan save(Plan plan);

    List<Plan> findAll();

    Optional<PlanDto> findById(Long id);

    void deleteById(Long id);
}

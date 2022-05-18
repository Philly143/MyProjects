package edu.miu.membership.repository;

import edu.miu.membership.domain.Member;
import edu.miu.membership.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Asma Aiouez
 * @DATE 5/16/22
 */

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

    @Query("from Plan ")
    List<Member> findAllPlans();
}

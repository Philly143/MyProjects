package edu.miu.membership.repository;

import edu.miu.membership.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Asma Aiouez
 * @DATE 5/16/22
 */

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {

    @Query(value = "insert into Membership (startDate, endDate) values (:startDate, :endDate) ", nativeQuery = true)
    void save(LocalDate startDate, LocalDate endDate);

}

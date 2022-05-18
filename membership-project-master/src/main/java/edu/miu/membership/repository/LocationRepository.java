package edu.miu.membership.repository;

import edu.miu.membership.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Asma Aiouez
 * @DATE 5/16/22
 */

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}

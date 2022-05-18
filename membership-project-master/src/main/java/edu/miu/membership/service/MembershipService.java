package edu.miu.membership.service;

import edu.miu.membership.domain.Membership;
import edu.miu.membership.domain.Plan;
import edu.miu.membership.dto.MembershipDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Asma Aiouez
 * @DATE 5/16/22
 */

public interface MembershipService {
    List<Membership> findAll();

    Optional<MembershipDto> findById(Long id);

    Membership save(Membership membership);

    void deleteById(Long id);
}

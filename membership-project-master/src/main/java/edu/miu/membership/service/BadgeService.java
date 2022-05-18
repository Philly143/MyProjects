package edu.miu.membership.service;

import edu.miu.membership.domain.Badge;
import edu.miu.membership.domain.Location;
import edu.miu.membership.dto.BadgeDto;
import edu.miu.membership.dto.MemberDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Asma Aiouez
 * @DATE 5/16/22
 */


public interface BadgeService {

    Badge save(Badge badge);

    Optional<BadgeDto> findById(Long id);

    void deleteById(Long id);

    List<BadgeDto> findAll();
}

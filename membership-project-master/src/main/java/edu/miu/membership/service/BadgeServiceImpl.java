package edu.miu.membership.service;

import edu.miu.membership.domain.Badge;
import edu.miu.membership.domain.Member;
import edu.miu.membership.dto.BadgeDto;
import edu.miu.membership.dto.MemberDto;
import edu.miu.membership.exception.custom.EntityNotFoundException;
import edu.miu.membership.modelmapper.MapStruct;
import edu.miu.membership.repository.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Asma Aiouez
 * @DATE 5/16/22
 */

@Service
@Transactional
public class BadgeServiceImpl implements BadgeService{

    private BadgeRepository badgeRepository;
    private MapStruct mapStruct;

    @Autowired
    BadgeServiceImpl(BadgeRepository badgeRepository, MapStruct mapStruct){
        this.badgeRepository= badgeRepository;
        this.mapStruct = mapStruct;
    }

    @Override
    public Badge save(Badge badge) {
        return badgeRepository.save(badge);
    }

    @Override
    public Optional<BadgeDto> findById(Long id) {
        Badge badge = badgeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id+ " not found"));
        return Optional.of(mapStruct.convertToBadgeDto(badge));
    }

    @Override
    public void deleteById(Long id) {
        badgeRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BadgeDto> findAll() {
        List<Badge> badges = badgeRepository.findAll();
        return badges.stream().map(badge -> mapStruct.convertToBadgeDto(badge))
                .collect(Collectors.toList());
    }
}

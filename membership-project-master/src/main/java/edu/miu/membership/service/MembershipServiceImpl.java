package edu.miu.membership.service;

import edu.miu.membership.domain.Member;
import edu.miu.membership.domain.Membership;
import edu.miu.membership.domain.Plan;
import edu.miu.membership.dto.MemberDto;
import edu.miu.membership.dto.MembershipDto;
import edu.miu.membership.exception.custom.EntityNotFoundException;
import edu.miu.membership.modelmapper.MapStruct;
import edu.miu.membership.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Asma Aiouez
 * @DATE 5/16/22
 */

@Service
@Transactional
public class MembershipServiceImpl implements MembershipService{

    private MembershipRepository membershipRepository;
    private MapStruct mapStruct;

    @Autowired
    MembershipServiceImpl(MembershipRepository membershipRepository, MapStruct mapStruct){
        this.membershipRepository = membershipRepository;
        this.mapStruct = mapStruct;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Membership> findAll() {
        return membershipRepository.findAll();
    }

    @Override
    public Optional<MembershipDto> findById(Long id) {
        Membership membership = membershipRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id+ " not found"));
        return Optional.of(mapStruct.convertToMembershipDto(membership));
    }

    @Override
    public Membership save(Membership membership) {
        return membershipRepository.save(membership);
    }

    @Override
    public void deleteById(Long id) {
        membershipRepository.deleteById(id);
    }
}

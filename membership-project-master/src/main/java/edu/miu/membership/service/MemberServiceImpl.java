package edu.miu.membership.service;

import edu.miu.membership.domain.*;
import edu.miu.membership.dto.*;
import edu.miu.membership.exception.custom.EntityNotFoundException;
import edu.miu.membership.modelmapper.MapStruct;
import edu.miu.membership.repository.MemberRepository;
import edu.miu.membership.repository.MembershipRepository;
import edu.miu.membership.repository.PlanRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/15/22
 */

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;
    private MapStruct mapStruct;
    private ModelMapper modelMapper;

    @Autowired
    MemberServiceImpl(MemberRepository memberRepository,
                      ModelMapper modelMapper,
                      MapStruct mapStruct) {
        this.memberRepository = memberRepository;
        this.mapStruct = mapStruct;
        this.modelMapper = modelMapper;
    }
    @Autowired
    PlanRepository planRepository;

    @Autowired
    MembershipRepository membershipRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MemberDto> findAllMembers() {
        List<Member> members = memberRepository.findAllMembers();
        List<MemberDto> memberDtos = members.stream().map(member -> mapStruct.convertToMemberDto(member))
                .collect(Collectors.toList());
        return memberDtos;
    }

    @Override
    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Member save(Member member){

        //Barcode barcode = BarcodeFactory.createEAN13("adfadfasdf");
        // member.getBadges().iterator().next().setBarcode(BarcodeImageHandler.getImage(barcode));

        System.out.println("here");
        System.out.println(member.getPhone());
        return memberRepository.save(member);
    }

    @Override
    public Optional<MemberDto> findById(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id+ " not found"));
        return Optional.of(mapStruct.convertToMemberDto(member));
    }

    @Override
    public void updateAllTables(Member member) {
        member.setIsDeleted(true);
        member.getBadges().stream().forEach(badge -> badge.setIsDeleted(true));
        member.getMemberships().stream().forEach(membership -> membership.setIsDeleted(true));
        member.getBadges().stream().forEach(badge-> badge.getTransactions().forEach(trx -> trx.setIsDeleted(true)));
        member.getMemberships().stream().forEach(membership -> membership.getTransactions().stream().forEach(trx -> trx.setIsDeleted(true)));
        memberRepository.save(member);
    }

    @Override
    public void addMemberShip(Long memberId, Long planId, Membership membership) {
         memberRepository.addMemberShip(memberId, planId, membership);
    }

    @Override
    public void savePlan(Long memberId, Long planId) {

    }

    @Override
    public void deleteMemberById(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    @Override
    public List<Transaction> getTransactions(Long memberId) {
        return memberRepository.findAllTransactions(memberId);
    }

    public void saveMembership(Long memberId, Membership membership) {
        /*membership




        Member member = memberRepository.findById(memberId).get();
       // member.getPlans().add(plan);
        Membership membership = new Membership(LocalDate.now(),LocalDate.now().plusYears(1));
        membershipRepository.save(membership);
        member.getMemberships().add(membership);
        plan.getMemberships().add(membership);*/

    }

    public Set<Plan> getPlans(Long memberId) {
        //return memberRepository.findById(memberId).get().getPlans();
        return null;
    }

}

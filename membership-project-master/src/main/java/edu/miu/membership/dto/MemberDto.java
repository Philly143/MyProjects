package edu.miu.membership.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.miu.membership.domain.Badge;
import edu.miu.membership.domain.Member;
import edu.miu.membership.domain.Membership;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;


/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/14/22
 */

@Getter
@Setter
@AllArgsConstructor
@JsonPropertyOrder({"id", "firstName","lastName", "phone", "email", "memberships", "badges", "plans" })
public class MemberDto {
    @JsonProperty("member_id")
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Set<MembershipDto> memberships ;
    private Set<BadgeDto> badges ;
    //private Set<PlanDto> plans;
    private Boolean isDeleted = false;

}

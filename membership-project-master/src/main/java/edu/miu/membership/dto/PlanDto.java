package edu.miu.membership.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.miu.membership.domain.Plan;
import edu.miu.membership.enums.Plans;
import edu.miu.membership.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
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
@JsonPropertyOrder({"id"})
public class PlanDto{

    @JsonProperty("plan_id")
    private Long id;
    private String name;
    private String description;
    private Plans planType;
    //private Role role;

    @JsonIgnore
    private Set<MembershipDto> memberships ;
    private Set<LocationDto> locations;
    private Boolean isDeleted = false;


}

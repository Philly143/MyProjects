package edu.miu.membership.domain;

import edu.miu.membership.enums.Plans;
import edu.miu.membership.enums.Role;
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
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Plan implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "plan_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Plans planType;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(cascade =  CascadeType.ALL)
    @JoinColumn(name = "plan_id")
    private Set<Membership> memberships = new HashSet<>();

    @OneToMany(cascade =  CascadeType.ALL, fetch =  FetchType.EAGER)
    @JoinColumn(name = "plan_id")
    private Set<Location> locations = new HashSet<>();

    private Boolean isDeleted = false;

}

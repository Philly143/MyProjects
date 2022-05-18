package edu.miu.membership.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.miu.membership.enums.LocationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/15/22
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "location_id", nullable = false)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private LocationType locationType;

    @OneToMany(cascade =  CascadeType.ALL, fetch =  FetchType.EAGER)
    @JoinTable(name="location_transaction", joinColumns = {@JoinColumn(name = "location_id")},
            inverseJoinColumns = {@JoinColumn(name = "transaction_id")})
    private List<Transaction> transactions = new ArrayList<>();

    @OneToMany(cascade =  CascadeType.ALL, fetch =  FetchType.EAGER)
    @JoinColumn(name = "location_id")
    private Set<TimeSlot> timeSlots = new HashSet<>();

    @Lob
    private String description;

    private Long capacity;

    private Boolean isDeleted = false;



}

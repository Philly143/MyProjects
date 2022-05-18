package edu.miu.membership.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/14/22
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Membership implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "membership_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @OneToMany(cascade =  CascadeType.ALL, fetch =  FetchType.EAGER)
    @JoinColumn(name="membership_id")
    private List<Transaction> transactions = new ArrayList<>();

    public Membership(LocalDate startDate, LocalDate endDate) {
        this.startDate=startDate;
        this.endDate=endDate;
    }
    private Boolean isDeleted = false;


}

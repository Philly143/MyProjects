package edu.miu.membership.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.miu.membership.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.EAN;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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

public class Badge implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "badge_id", nullable = false)
    private Long id;

    private LocalDate issueDate;
    private LocalDate expireDate;

    //@Lob
    //@EAN
    private String barcode;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="badge_transaction", joinColumns = {@JoinColumn(name = "badge_id")},
            inverseJoinColumns = {@JoinColumn(name = "transaction_id")})
    private Collection<Transaction> transactions = new ArrayList<>();

    private Boolean isDeleted = false;


}

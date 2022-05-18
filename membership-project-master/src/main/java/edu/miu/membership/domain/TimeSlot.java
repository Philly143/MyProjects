package edu.miu.membership.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.miu.membership.enums.Day;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/15/22
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TimeSlot {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "timeslot_id", nullable = false)
    private Long id;
    private Timestamp startTime;
    private Timestamp endTime;
    private String slot;
    @Enumerated(EnumType.STRING)
    private Day day;
    private Boolean isDeleted = false;

}

package edu.miu.membership.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.miu.membership.enums.Day;
import lombok.AllArgsConstructor;
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

@Getter
@Setter
@AllArgsConstructor
@JsonPropertyOrder({"id"})
public class TimeSlotDto{

    @JsonProperty("timeslot_id")
    private Long id;
    private Timestamp startTime;
    private Timestamp endTime;
    private String slot;
    private Day day;
    private Boolean isDeleted = false;

}

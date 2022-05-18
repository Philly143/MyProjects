package edu.miu.membership.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.miu.membership.enums.LocationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/15/22
 */
@Getter
@Setter
@AllArgsConstructor
@JsonPropertyOrder({"id", "name","description", "capacity", "locationType", "transactions", "timeSlots" })
public class LocationDto {

    @JsonProperty("location_id")
    private Long id;
    private String name;
    private String description;
    private Long capacity;
    private LocationType locationType;
    private List<TransactionDto> transactions;
    private Set<TimeSlotDto> timeSlots;
    private Boolean isDeleted = false;

}

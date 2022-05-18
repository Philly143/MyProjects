package edu.miu.membership.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.miu.membership.domain.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

@Getter @Setter
@AllArgsConstructor
@JsonPropertyOrder({"id", "startDate","endDate" })
public class MembershipDto{

    @JsonProperty("membership_id")
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<TransactionDto> transactions;
    private Boolean isDeleted = false;


}

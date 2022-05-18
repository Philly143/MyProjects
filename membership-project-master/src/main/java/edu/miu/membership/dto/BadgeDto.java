package edu.miu.membership.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.miu.membership.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/15/22
 */
@Getter
@Setter
@AllArgsConstructor
@JsonPropertyOrder({"id", "issueDate","expireDate", "barcode", "status", "transactions" })
public class BadgeDto {

    @JsonProperty("badge_id")
    private Long id;
    private LocalDate issueDate;
    private LocalDate expireDate;
    private String barcode;
    private Status status;
    private Collection<TransactionDto> transactions ;
    private Boolean isDeleted = false;

}

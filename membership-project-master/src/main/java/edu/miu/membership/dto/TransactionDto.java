package edu.miu.membership.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/15/22
 */
@Getter
@Setter
@AllArgsConstructor
@JsonPropertyOrder({"id"})
public class TransactionDto{

    @JsonProperty("transaction_id")
    private Long id;
    private Timestamp checkOut;
    private Timestamp checkIn;
    private Boolean isDeleted = false;
}

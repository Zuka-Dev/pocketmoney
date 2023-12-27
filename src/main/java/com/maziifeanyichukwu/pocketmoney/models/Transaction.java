package com.maziifeanyichukwu.pocketmoney.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private Long id;
    private String senderUsername;
    private String receiverUsername;
    private double amount;
    private LocalDateTime timestamp;

}

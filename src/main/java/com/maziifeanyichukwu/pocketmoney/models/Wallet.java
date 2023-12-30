package com.maziifeanyichukwu.pocketmoney.models;

import com.fasterxml.jackson.databind.DatabindException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long walletId;
    private Double balance;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDateTime createdAt = LocalDateTime.now();
}

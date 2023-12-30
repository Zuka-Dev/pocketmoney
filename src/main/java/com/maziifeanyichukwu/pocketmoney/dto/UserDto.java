package com.maziifeanyichukwu.pocketmoney.dto;

import com.maziifeanyichukwu.pocketmoney.models.Wallet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private  String userName;
    private String email;
    private List<Wallet> wallets;

}

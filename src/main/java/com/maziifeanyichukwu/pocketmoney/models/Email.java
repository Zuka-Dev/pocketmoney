package com.maziifeanyichukwu.pocketmoney.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    private String recipient;
    private String subject;
    private String sender;
    private String body;
}

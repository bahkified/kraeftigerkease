package net.kraeftigerkase.website.dto;

import lombok.Data;

@Data
public class EmailDto {

    private String emailAddress;
    private String name;
    private String phoneNumber;
    private String subject;
    private String comments;

}

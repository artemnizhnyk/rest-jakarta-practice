package com.artemnizhnyk.restjakartapractice.web.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Data
public class UserDto {

    private Long id;
    private String username;
    private String password;
}
package com.sparta.project_11_03.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PostRequestDto {

    private Long id;

    private String username;

    private String password;

    private String contents;
    private String title;

    //private LocalDate date;


}

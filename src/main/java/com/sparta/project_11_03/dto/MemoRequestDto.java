package com.sparta.project_11_03.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MemoRequestDto {

    private Long id;

    private String username;

    private String password;

    private String contents;

    //private LocalDate date;


}

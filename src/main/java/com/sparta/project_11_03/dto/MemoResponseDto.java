package com.sparta.project_11_03.dto;

import com.sparta.project_11_03.entity.Memo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemoResponseDto {

    private Long id;

    private String username;

    private String password;

    private String contents;

    //private LocalDate date;
    public MemoResponseDto(Memo memo) {
        this.id = memo.getId();
        this.username = memo.getUsername();
        this.password = memo.getPassword();
        this.contents = memo.getContents();
    }

}

package com.sparta.project_11_03.entity;


import com.sparta.project_11_03.dto.MemoRequestDto;
import com.sparta.project_11_03.dto.MemoResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.nio.file.AccessDeniedException;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")

public class Memo {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "contents", nullable = false)
    private String contents;


    //private LocalDate date;

    public Memo(MemoRequestDto memoRequestDto){

        this.id = memoRequestDto.getId();
        this.username = memoRequestDto.getUsername();
        this.password = memoRequestDto.getPassword();
        this.contents = memoRequestDto.getContents();


    }

    public void setId(Long id) {
        this.id = id;
    }

    public void update(MemoRequestDto memoRequestDto){

            this.id = memoRequestDto.getId();
            this.username = memoRequestDto.getUsername();
            this.password = memoRequestDto.getPassword();
            this.contents = memoRequestDto.getContents();

    }



}

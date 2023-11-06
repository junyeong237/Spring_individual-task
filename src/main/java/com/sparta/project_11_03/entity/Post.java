package com.sparta.project_11_03.entity;


import com.sparta.project_11_03.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")

public class Post extends Timestamped{

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
    @Column(name = "title", nullable = false)
    private String title;


    //private LocalDate date;

    public Post(PostRequestDto postRequestDto){

        this.id = postRequestDto.getId();
        this.username = postRequestDto.getUsername();
        this.password = postRequestDto.getPassword();
        this.contents = postRequestDto.getContents();
        this.title = postRequestDto.getTitle();


    }

    public void setId(Long id) {
        this.id = id;
    }

    public void update(PostRequestDto postRequestDto){

            //this.id = postRequestDto.getId();
            this.username = postRequestDto.getUsername();
            this.password = postRequestDto.getPassword();
            this.contents = postRequestDto.getContents();
            this.title = postRequestDto.getTitle();


    }



}

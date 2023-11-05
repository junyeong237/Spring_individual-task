package com.sparta.project_11_03.dto;

import com.sparta.project_11_03.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {

    private Long id;

    private String username;

    private String password;

    private String contents;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    //private LocalDate date;
    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.username = post.getUsername();
        this.password = post.getPassword();
        this.contents = post.getContents();
        this.title = post.getTitle();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }

}

package com.sparta.project_11_03.dto;

import com.sparta.project_11_03.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {

    private Long id;

    private String username;

    private String password;

    private String contents;

    //private LocalDate date;
    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.username = post.getUsername();
        this.password = post.getPassword();
        this.contents = post.getContents();
    }

}

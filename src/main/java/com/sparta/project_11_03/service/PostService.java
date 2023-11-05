package com.sparta.project_11_03.service;


import com.sparta.project_11_03.dto.PostRequestDto;
import com.sparta.project_11_03.dto.PostResponseDto;
import com.sparta.project_11_03.entity.Post;
import com.sparta.project_11_03.respository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository){

        this.postRepository = postRepository;

    }

    public void createPost(PostRequestDto requestDto) {

        Post post = new Post(requestDto);
        Post savePost = postRepository.save(post);
        PostResponseDto postResponseDto = new PostResponseDto(savePost);
        //return postResponseDto;
    }

    public List<Post> getPostList(){
        return postRepository.findAll();
    }

    @Transactional //transactional 전파해야되기때문에 transactional 걸어줘야함
    public ResponseEntity<String> updatePost(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다."));

        if(requestDto.getPassword().equals(post.getPassword())){
            post.update(requestDto);
            return ResponseEntity.ok("게시글이 수정되었습니다.");
        }
        else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("비밀번호가 일치하지 않습니다.");
        }

    }


    public ResponseEntity<String> deletePost(Long id, String password) {

        Post post = postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다."));
        if (password.equals(post.getPassword())) {
            postRepository.delete(post);
            return ResponseEntity.ok("게시글이 삭제되었습니다.");
        }
        else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("비밀번호가 일치하지 않습니다.");
        }
    }

    public Post getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다."));
        return post;
    }


}

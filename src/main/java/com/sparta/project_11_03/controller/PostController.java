package com.sparta.project_11_03.controller;

import com.sparta.project_11_03.dto.PostRequestDto;
import com.sparta.project_11_03.dto.PostResponseDto;
import com.sparta.project_11_03.entity.Post;
import com.sparta.project_11_03.service.PostService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Controller
public class PostController {

    @Autowired
    private PostService postService;

    public PostController(PostService postService){

        this.postService = postService;

    }

    @GetMapping("/mypost")
    public String startView(){
        return "index";
    }
    @GetMapping("/mypost/create")
    public String createView() {
        return "post/createPost";
    }

    @PostMapping("/mypost/create")
    public String createPost(@ModelAttribute PostRequestDto requestDto){
        postService.createPost(requestDto);
        return "index";
    }



    @GetMapping("/mypost/get") //게시글 전체 리스트
    public String getPostList(Model model) {
        List<Post> posts = postService.getPostList();
        model.addAttribute("posts", posts);
        return "post/postList";
    }

    @GetMapping("/mypost/{id}")
    public String getPost(@PathVariable Long id, Model model){

        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        return "post/postGet";
    }

    @GetMapping("/mypost/update/{id}") //값수정하는 html로
    public String inputUpdatePost(@PathVariable Long id, Model model){
        model.addAttribute("postId",id);
        return "post/updatePost";
    }
    @GetMapping("/mypost/inputpassword/{id}")
    public String inputDeletePassword(@PathVariable Long id, Model model) {
        model.addAttribute("postId",id);
        return "post/inputPassword";
    }
    @PutMapping("/mypost/{id}")
    @ResponseBody // 이거 필수인가? 모르겄네
    public ResponseEntity<String> updatePost(@PathVariable Long id, @ModelAttribute PostRequestDto requestDto){
        System.out.println("전송성공");
        return postService.updatePost(id,requestDto);
    }

    @DeleteMapping("/mypost/{id}")
    @ResponseBody
    public ResponseEntity<String> deletePost(@PathVariable Long id,@RequestParam String password) {
        return postService.deletePost(id,password);
    }


}

package com.sparta.project_11_03.controller;

import com.sparta.project_11_03.dto.PostRequestDto;
import com.sparta.project_11_03.entity.Post;
import com.sparta.project_11_03.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PostController {

    @Autowired
    private PostService postService;

    public PostController(PostService postService){

        this.postService = postService;

    }
    @GetMapping(value = "/mypost")
    public String startView(){
        return "home";
    }
    @GetMapping(value = "/mypost/create")
    public String createView() {
        return "post/createPost";
    }

//    @PostMapping("/mymemos/create")
//    @ResponseBody
//    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
//        return memoService.createMemo(requestDto);
//    }

    @PostMapping("/mypost/create")
    public String createPost(@RequestBody PostRequestDto requestDto) {
        postService.createPost(requestDto);
        return "home";
    }


//
//
//    @GetMapping("/mymemos")
//    @ResponseBody
//    public List<Memo> getMemoList(){
//
//        return memoService.getMemoList();
//
//    }

    @GetMapping(value = "/mypost/get")
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

//    @PutMapping("/mymemos/{id}")
//    //@ResponseBody
//    public String updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) throws AccessDeniedException {
//        memoService.updateMemo(id,requestDto);
//        return "home";
//    }
//
    @PutMapping("/post/{id}")
    //@ResponseBody // 이거 필수인가? 몰겄네
    public ResponseEntity<String> updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        return postService.updatePost(id,requestDto);
    }

    @DeleteMapping("/post/{id}")
    //@ResponseBody
    public ResponseEntity<String> deletePost(@PathVariable Long id,@RequestParam String password) {
        return postService.deletePost(id,password);
    }
}

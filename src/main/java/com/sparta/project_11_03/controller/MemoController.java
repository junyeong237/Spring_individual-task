package com.sparta.project_11_03.controller;

import com.sparta.project_11_03.dto.MemoRequestDto;
import com.sparta.project_11_03.dto.MemoResponseDto;
import com.sparta.project_11_03.entity.Memo;
import com.sparta.project_11_03.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;


@Controller
public class MemoController {

    @Autowired
    private MemoService memoService;

    public MemoController(MemoService memoService){

        this.memoService = memoService;

    }
    @GetMapping(value = "/mymemos")
    public String startView(){
        return "home";
    }
    @GetMapping(value = "/mymemos/create")
    public String createView() {
        return "memos/createMemo";
    }

//    @PostMapping("/mymemos/create")
//    @ResponseBody
//    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
//        return memoService.createMemo(requestDto);
//    }

    @PostMapping("/mymemos/create")
    public String createMemo(@RequestBody MemoRequestDto requestDto) {
        memoService.createMemo(requestDto);
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

    @GetMapping(value = "/mymemos/get")
    public String getMemoList(Model model) {
        List<Memo> members = memoService.getMemoList();
        model.addAttribute("members", members);
        return "memos/memosList";
    }

    @GetMapping("/mymemos/{id}")
    public String getMemo(@PathVariable Long id, Model model){

        Memo members = memoService.getMemo(id);
        model.addAttribute("members", members);
        return "memos/memosGet";
    }

//    @PutMapping("/mymemos/{id}")
//    //@ResponseBody
//    public String updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) throws AccessDeniedException {
//        memoService.updateMemo(id,requestDto);
//        return "home";
//    }
//
    @PutMapping("/mymemos/{id}")
    //@ResponseBody // 이거 필수인가? 몰겄네
    public ResponseEntity<String> updatePost(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        return memoService.updatePost(id,requestDto);
    }

    @DeleteMapping("/mymemos/{id}")
    //@ResponseBody
    public ResponseEntity<String> deleteMemo(@PathVariable Long id,@RequestParam String password) {
        return memoService.deletePost(id,password);
    }
}

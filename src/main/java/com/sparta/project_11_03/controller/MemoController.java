package com.sparta.project_11_03.controller;

import com.sparta.project_11_03.dto.MemoRequestDto;
import com.sparta.project_11_03.dto.MemoResponseDto;
import com.sparta.project_11_03.entity.Memo;
import com.sparta.project_11_03.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
//@RequestMapping("/api")
public class MemoController {

    @Autowired
    private MemoService memoService;

    public MemoController(MemoService memoService){

        this.memoService = memoService;

    }

    @GetMapping(value = "/mymemos/create")
    public String startView() {
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
        return "redirect:/";
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

    @GetMapping(value = "/mymemos")
    public String getMemoList(Model model) {
        List<Memo> members = memoService.getMemoList();
        model.addAttribute("members", members);
        return "memos/memosList";
    }

    @GetMapping("/mymemos/{id}")
    @ResponseBody
    public void getMemo(@PathVariable Long id){

        memoService.getMemo(id);

    }

    @PutMapping("/mymemos/{id}")
    //@ResponseBody
    public String updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        memoService.updateMemo(id,requestDto);
        return "redirect:/";

    }

    @DeleteMapping("/mymemos/{id}")
    @ResponseBody
    public Long deleteMemo(@PathVariable Long id) {
        return memoService.deleteMemo(id);

    }

}

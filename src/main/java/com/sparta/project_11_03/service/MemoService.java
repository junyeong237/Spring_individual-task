package com.sparta.project_11_03.service;


import com.sparta.project_11_03.dto.MemoRequestDto;
import com.sparta.project_11_03.dto.MemoResponseDto;
import com.sparta.project_11_03.entity.Memo;
import com.sparta.project_11_03.respository.MemoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Service
public class MemoService {

    @Autowired
    MemoRepository memoRepository;

    @Autowired
    public MemoService(MemoRepository memoRepository){

        this.memoRepository = memoRepository;

    }

    public MemoResponseDto createMemo(MemoRequestDto requestDto) {

        Memo memo = new Memo(requestDto);
        Memo saveMemo = memoRepository.save(memo);
        MemoResponseDto memoResponseDto = new MemoResponseDto(saveMemo);
        return memoResponseDto;
    }

    public List<Memo> getMemoList(){
        return memoRepository.findAll();
    }

    @Transactional //transactional 전파해야되기때문에 transactional 걸어줘야함
    public ResponseEntity<String> updatePost(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다."));

        if(requestDto.getPassword().equals(memo.getPassword())){
            memo.update(requestDto);
            return ResponseEntity.ok("게시글이 수정되었습니다.");
        }
        else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("비밀번호가 일치하지 않습니다.");
        }

    }


    public ResponseEntity<String> deletePost(Long id, String password) {

        Memo memo = memoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다."));
        if (password.equals(memo.getPassword())) {
            memoRepository.delete(memo);
            return ResponseEntity.ok("게시글이 삭제되었습니다.");
        }
        else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("비밀번호가 일치하지 않습니다.");
        }
    }

    public Memo getMemo(Long id) {
        Memo memo = memoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다."));
        return memo;
    }


}

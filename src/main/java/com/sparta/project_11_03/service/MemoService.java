package com.sparta.project_11_03.service;


import com.sparta.project_11_03.dto.MemoRequestDto;
import com.sparta.project_11_03.dto.MemoResponseDto;
import com.sparta.project_11_03.entity.Memo;
import com.sparta.project_11_03.respository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public void updateMemo(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다."));
        memo.update(requestDto);

    }


    public Long deleteMemo(Long id) {

        Memo memo = memoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다."));

        memoRepository.delete(memo);
        return id;

    }

    public void getMemo(Long id) {



    }
}

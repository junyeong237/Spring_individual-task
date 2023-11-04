package com.sparta.project_11_03.respository;

import com.sparta.project_11_03.entity.Memo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface MemoRepository extends JpaRepository<Memo,Long> {

}

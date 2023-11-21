package com.purushotham.repository;

import com.purushotham.entity.NoticeDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NoticeRepository extends CrudRepository<NoticeDetail, Long> {
   /* @Query(value = "SELECT  n FROM NoticeDetail as n where CURDATE() BETWEEN n.notic_beg_dt AND n.notic_beg_dt")
    List<Notice> findByAllActiveNotices();*/

    @Query(value = "from NoticeDetail n where CURDATE() BETWEEN noticBegDt AND noticEndDt")
    List<NoticeDetail> findAllActiveNotices();
}

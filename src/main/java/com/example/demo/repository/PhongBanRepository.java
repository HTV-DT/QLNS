package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PhongBan;

@Repository
public interface PhongBanRepository extends JpaRepository<PhongBan, Long>{
   PhongBan findBymaPB(Long maPB); //Tim kiem User co ton tai trong DB khong?
   Boolean existsBytenPB(String tenPB);
}

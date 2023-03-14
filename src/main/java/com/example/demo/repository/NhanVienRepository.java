package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.NhanVien;
import com.example.demo.model.PhongBan;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long>{
    Optional<NhanVien> findBycCCD(String cCCD); //Tim kiem User co ton tai trong DB khong?
    Boolean existsByEmail(String email); //email da co trong DB chua
    NhanVien findBymaNV(Long maNV);
    Boolean existsByPhongBan(PhongBan phongBan);
}

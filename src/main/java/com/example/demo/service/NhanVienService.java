package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.NhanVien;

public interface NhanVienService {
    Optional<NhanVien> findByCCCD(String cCCD); //Tim kiem User co ton tai trong DB khong?
    Boolean existsByEmail(String email); //email da co trong DB chua
    NhanVien save(NhanVien nhanVien);
    List<NhanVien> findAllNhanVien();
    public void saveFile(MultipartFile file);
    public boolean deleteById(int id) ;
    public NhanVien updateNhanVien(NhanVien nV,Long id) ;
}

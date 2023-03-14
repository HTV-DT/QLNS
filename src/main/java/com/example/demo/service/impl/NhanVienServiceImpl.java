package com.example.demo.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.helper.Helper;
import com.example.demo.model.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.NhanVienService;

@Service
public class NhanVienServiceImpl implements NhanVienService{

    @Autowired //tự động truyền tải các mối quan hệ
    NhanVienRepository nhanVienRepository;

    @Override
    public Optional<NhanVien> findByCCCD(String cCCD) {
        return nhanVienRepository.findBycCCD(cCCD);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return nhanVienRepository.existsByEmail(email);
    }

    @Override
    public NhanVien save(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    @Override
    public List<NhanVien> findAllNhanVien() {
        List<NhanVien> nhanVien = nhanVienRepository.findAll();
        return nhanVien;
    }
    
    @Override
    public void saveFile(MultipartFile file) {

        try {
            List<NhanVien> nhanViens = Helper.convertExcelToListOfProduct(file.getInputStream());
            this.nhanVienRepository.saveAll(nhanViens);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public boolean deleteById(int id)  
    {  
        try {
            NhanVien nhanVien = nhanVienRepository.findBymaNV(Long.valueOf(id));
            nhanVien.setTrangThai(false);
            //nhanVienRepository.deleteById((long) id); 
            nhanVienRepository.save(nhanVien);
            return true;
        } catch (Exception e) {
            System.out.println("Xóa thất bại");
            return false;
        }
    }

    @Override
    public NhanVien updateNhanVien(NhanVien nV,Long id) {
        NhanVien nhanVien = nhanVienRepository.findBymaNV(id);
		nhanVien.setTenNhanSu(nV.getTenNhanSu());
		nhanVien.setCCCD(nV.getCCCD());
		nhanVien.setEmail(nV.getEmail());
		nhanVien.setNgaySinh(nV.getNgaySinh());
		nhanVien.setHinhAnh(nV.getHinhAnh());
		nhanVien.setDanToc(nV.getDanToc());
		nhanVien.setQuocTich(nV.getQuocTich());
		nhanVien.setNgayKyHopDong(nV.getNgayKyHopDong());
		nhanVien.setSoTK(nV.getSoTK());
		return nhanVienRepository.save(nhanVien);   
    }
   
    
}

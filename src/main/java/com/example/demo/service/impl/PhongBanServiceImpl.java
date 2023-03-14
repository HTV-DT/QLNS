package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import com.example.demo.model.PhongBan;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.repository.PhongBanRepository;
import com.example.demo.service.PhongBanService;

@Service
public class PhongBanServiceImpl implements PhongBanService {

    @Autowired
    PhongBanRepository phongBanRepository;
    @Autowired
    NhanVienRepository nhanVienRepository;

    @Override
    public PhongBan findBymaPB(Long maPB) {
        return phongBanRepository.findBymaPB(maPB);
    }

    @Override
    public PhongBan save(PhongBan phongBan) {
        return phongBanRepository.save(phongBan);
    }

    @Override
    public List<PhongBan> findAllPhongBan() {
        List<PhongBan> phongBan = phongBanRepository.findAll();
        return phongBan;
    }

    @Override
    public boolean deleteById(int id) {
        try {
            //phongBanRepository.deleteById((long) id); 
            PhongBan phongBan = phongBanRepository.findBymaPB(Long.valueOf(id));
            if(nhanVienRepository.existsByPhongBan(phongBan)){
                System.out.println("Xóa thất bại");
                return false;
            }
            phongBan.setTrangThaiPB(false);
            phongBanRepository.save(phongBan);  
            return true;
        } catch (Exception e) {
            System.out.println("Xóa thất bại");
            return false;
        }
    }

    @Override
    public PhongBan updatePhongBan(PhongBan pB, Long id) {
        PhongBan phongBan = phongBanRepository.findBymaPB(id);
		phongBan.setTenPB(pB.getTenPB());
        return phongBanRepository.save(phongBan);   
    }

    @Override
    public Boolean existsBytenPB(String tenPB) {
        return phongBanRepository.existsBytenPB(tenPB);
    }
    
}

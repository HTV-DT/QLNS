package com.example.demo.service;

import java.util.List;


import com.example.demo.model.PhongBan;

public interface PhongBanService {
    PhongBan findBymaPB(Long maPB); 
    Boolean existsBytenPB(String tenPB);
    PhongBan save(PhongBan phongBan);
    List<PhongBan> findAllPhongBan();
    public boolean deleteById(int id) ;
    public PhongBan updatePhongBan(PhongBan pB,Long id) ;
}

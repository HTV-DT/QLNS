package com.example.demo.model;


import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PhongBan")
public class PhongBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maPB;
    @NotBlank // Not null
    @Size(min = 0, max = 50)
    private String tenPB;
    private boolean trangThaiPB=true;


    @OneToMany(mappedBy = "phongBan", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (nhanVien) (1 địa điểm có nhiều người ở)
    // MapopedBy trỏ tới tên biến phongBan ở trong nhanVien.
    private Collection<NhanVien> nhanViens;


    public PhongBan() {
    }

    public PhongBan(String tenPB) {
        this.tenPB = tenPB;
    }

    public Long getMaPB() {
        return this.maPB;
    }

    public void setMaPB(Long maPB) {
        this.maPB = maPB;
    }

    public String getTenPB() {
        return this.tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

   
    @Override
    public String toString() {
        return "{" +
                " maPB='" + getMaPB() + "'" +
                ", tenPB='" + getTenPB() + "'" +
                "}";
    }
    public boolean isTrangThaiPB() {
        return this.trangThaiPB;
    }

    public boolean getTrangThaiPB() {
        return this.trangThaiPB;
    }

    public void setTrangThaiPB(boolean trangThaiPB) {
        this.trangThaiPB = trangThaiPB;
    }

}

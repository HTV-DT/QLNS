package com.example.demo.dto.request;

import com.example.demo.model.PhongBan;

public class AddNhanVienForm {
    private String tenNhanSu;
    private String cCCD;
    private String email;
    private String ngaySinh;
    private String hinhAnh;
    private String danToc;
    private String quocTich;
    private String ngayKyHopDong;
    private String soTK;
    private String sDT;
    private Long phongBan;

    public Long getPhongBan() {
        return this.phongBan;
    }

    public void setPhongBan(Long phongBan) {
        this.phongBan = phongBan;
    }

  
    public AddNhanVienForm() {
    }

    public AddNhanVienForm(String tenNhanSu, String cCCD, String email, String ngaySinh, String hinhAnh, String danToc, String quocTich, String ngayKyHopDong, String soTK, String sDT, Long phongBan) {
        this.tenNhanSu = tenNhanSu;
        this.cCCD = cCCD;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.hinhAnh = hinhAnh;
        this.danToc = danToc;
        this.quocTich = quocTich;
        this.ngayKyHopDong = ngayKyHopDong;
        this.soTK = soTK;
        this.sDT = sDT;
        this.phongBan = phongBan;
    }

  /*   public AddNhanVienForm(String tenNhanSu, String cCCD, String email, String ngaySinh, String hinhAnh, String danToc, String quocTich, String ngayKyHopDong, String soTK) {
        this.tenNhanSu = tenNhanSu;
        this.cCCD = cCCD;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.hinhAnh = hinhAnh;
        this.danToc = danToc;
        this.quocTich = quocTich;
        this.ngayKyHopDong = ngayKyHopDong;
        this.soTK = soTK;
    }
 */
    public String getTenNhanSu() {
        return this.tenNhanSu;
    }

    public void setTenNhanSu(String tenNhanSu) {
        this.tenNhanSu = tenNhanSu;
    }

    public String getCCCD() {
        return this.cCCD;
    }

    public void setCCCD(String cCCD) {
        this.cCCD = cCCD;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNgaySinh() {
        return this.ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getHinhAnh() {
        return this.hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getDanToc() {
        return this.danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getQuocTich() {
        return this.quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getNgayKyHopDong() {
        return this.ngayKyHopDong;
    }

    public void setNgayKyHopDong(String ngayKyHopDong) {
        this.ngayKyHopDong = ngayKyHopDong;
    }

    public String getSoTK() {
        return this.soTK;
    }

    public void setSoTK(String soTK) {
        this.soTK = soTK;
    }

    public String getSDT() {
        return this.sDT;
    }

    public void setSDT(String sDT) {
        this.sDT = sDT;
    }

 

}

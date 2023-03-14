package com.example.demo.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "BangCong")
public class BangCong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maBC;
    @NotBlank // Not null
    private Date ngay;
    @NotBlank
    private Date gioVao;
    // @NaturalId
    @NotBlank
    private Date gioRa;
    private Boolean trangThaiBC=true;
    @NotBlank
    private String maLoaiCong;



    public BangCong() {
    }

    public BangCong(Date ngay, Date gioVao, Date gioRa, String maLoaiCong) {
        this.ngay = ngay;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
        this.maLoaiCong = maLoaiCong;
    }


    public Long getMaBC() {
        return this.maBC;
    }

    public void setMaBC(Long maBC) {
        this.maBC = maBC;
    }

    public Date getNgay() {
        return this.ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Date getGioVao() {
        return this.gioVao;
    }

    public void setGioVao(Date gioVao) {
        this.gioVao = gioVao;
    }

    public Date getGioRa() {
        return this.gioRa;
    }

    public void setGioRa(Date gioRa) {
        this.gioRa = gioRa;
    }

    public Boolean isTrangThaiBC() {
        return this.trangThaiBC;
    }

    public Boolean getTrangThaiBC() {
        return this.trangThaiBC;
    }

    public void setTrangThaiBC(Boolean trangThaiBC) {
        this.trangThaiBC = trangThaiBC;
    }

    public String getMaLoaiCong() {
        return this.maLoaiCong;
    }

    public void setMaLoaiCong(String maLoaiCong) {
        this.maLoaiCong = maLoaiCong;
    }


}

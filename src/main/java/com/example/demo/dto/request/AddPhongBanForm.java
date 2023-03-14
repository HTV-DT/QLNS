package com.example.demo.dto.request;

public class AddPhongBanForm {
    private String tenPB;


    public AddPhongBanForm() {
    }

    public AddPhongBanForm(String tenPB) {
        this.tenPB = tenPB;
    }

    public String getTenPB() {
        return this.tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

}

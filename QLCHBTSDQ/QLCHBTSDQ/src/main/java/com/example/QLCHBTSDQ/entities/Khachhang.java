package com.example.QLCHBTSDQ.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "khachhang")
public class Khachhang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer makhachhang;

    @Column(nullable = false, length = 100)
    private String hoten;

    @Column(length = 15)
    private String sodienthoai;

    @Column(columnDefinition = "text")
    private String diachi;

    @Column(nullable = false, unique = true)
    private Integer mataikhoan;

    // Getters & Setters
    public Integer getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(Integer makhachhang) {
        this.makhachhang = makhachhang;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Integer getMataikhoan() {
        return mataikhoan;
    }

    public void setMataikhoan(Integer mataikhoan) {
        this.mataikhoan = mataikhoan;
    }
}

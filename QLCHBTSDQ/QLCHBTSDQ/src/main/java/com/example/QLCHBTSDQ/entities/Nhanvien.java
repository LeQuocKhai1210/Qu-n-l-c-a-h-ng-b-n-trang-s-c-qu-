package com.example.QLCHBTSDQ.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "nhanvien")
public class Nhanvien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer manhanvien;

    @Column(nullable = false, length = 100)
    private String hoten;

    @Column(length = 15)
    private String sodienthoai;

    @Column(columnDefinition = "text")
    private String diachi;

    @Column(nullable = false, unique = true)
    private Integer mataikhoan;

    // Getters & Setters
    public Integer getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(Integer manhanvien) {
        this.manhanvien = manhanvien;
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

package com.example.QLCHBTSDQ.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "loaisanpham")
public class Loaisanpham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maloai;

    @Column(nullable = false, unique = true, length = 100)
    private String tenloai;

    // Getters & Setters
    public Integer getMaloai() {
        return maloai;
    }

    public void setMaloai(Integer maloai) {
        this.maloai = maloai;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

}

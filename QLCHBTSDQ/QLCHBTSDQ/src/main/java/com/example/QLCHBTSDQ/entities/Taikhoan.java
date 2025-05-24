package com.example.QLCHBTSDQ.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "taikhoan")
public class Taikhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mataikhoan;

    @Column(nullable = false, unique = true, length = 100)
    private String tendangnhap;

    @Column(nullable = false, length = 100)
    private String matkhau;

    @Column(nullable = false, length = 100)
    private String vaitro;

    // Getters and Setters
    public Integer getMataikhoan() {
        return mataikhoan;
    }

    public void setMataikhoan(Integer mataikhoan) {
        this.mataikhoan = mataikhoan;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getVaitro() {
        return vaitro;
    }

    public void setVaitro(String vaitro) {
        this.vaitro = vaitro;
    }
}

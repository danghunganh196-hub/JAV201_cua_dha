package com.example.java_web_la_cai_gi.Buoi10.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "don_hang")
@NoArgsConstructor
@AllArgsConstructor
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "khach_hang")
    private String khachHang;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "da_giao")
    private Boolean daGiao;

    @ManyToOne
    @JoinColumn(name = "id_mon_an",referencedColumnName = "id")
    private MonAn monAn;
}

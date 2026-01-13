package com.example.java_web_la_cai_gi.Buoi3.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ban_phim")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class BanPhim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_ban_phim")
    private String tenBanPhim;

    @Column(name = "tinh_trang")
    private Boolean tinhTrang;

    @Column(name = "gia")
    private Float gia;

    @Column(name = "so_luong")
    private Integer soLuong;
}

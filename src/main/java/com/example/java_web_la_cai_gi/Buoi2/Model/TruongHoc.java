package com.example.java_web_la_cai_gi.Buoi2.Model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="truong_hoc")
public class TruongHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_truong")
    private String tenTruong;

    @Column(name = "dia_chi")
    private String diaChi;
}

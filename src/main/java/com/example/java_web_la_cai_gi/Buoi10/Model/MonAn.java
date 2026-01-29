package com.example.java_web_la_cai_gi.Buoi10.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "mon_an")
@NoArgsConstructor
@AllArgsConstructor
public class MonAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_mon")
    private String tenMon;

    @Column(name = "gia_tien")
    private Double giaTien;
}

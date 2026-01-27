package com.example.java_web_la_cai_gi.Buoi2.Controller;

import com.example.java_web_la_cai_gi.Buoi2.Model.GiangVien;
import com.example.java_web_la_cai_gi.Buoi2.Util.HibernateConfig;
import org.hibernate.Session;

public class TestRepository {
    Session session = null;

    public TestRepository(){
        session = HibernateConfig.getFACTORY().openSession();
    }

//    public GiangVien
}

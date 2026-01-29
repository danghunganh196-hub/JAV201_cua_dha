package com.example.java_web_la_cai_gi.Buoi10.Repository;

import com.example.java_web_la_cai_gi.Buoi10.Model.DonHang;
import com.example.java_web_la_cai_gi.Buoi10.Model.MonAn;
import com.example.java_web_la_cai_gi.Buoi10.Utility.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class MonAnRepository {
    Session session = null;

    public MonAnRepository(){
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<MonAn> getAll(){
        return session.createQuery("SELECT ma FROM MonAn ma").list();
    }

    public MonAn getByID(Integer id){
        return session.find(MonAn.class, id);
    }
}

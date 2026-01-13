package com.example.java_web_la_cai_gi.Buoi3.Repo;

import com.example.java_web_la_cai_gi.Buoi3.Util.HibernateConfig;
import com.example.java_web_la_cai_gi.Buoi3.Model.BanPhim;
import org.hibernate.Session;

import java.util.List;

public class BanPhimRepository {
    private Session session;

    public BanPhimRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<BanPhim> getAll(){
        return session.createQuery("SELECT bp FROM BanPhim bp").list();
    }

    public BanPhim getByID(Integer id){
        return session.find(BanPhim.class, id);
    }

    public void them(BanPhim banPhim){
        try{
            session.getTransaction().begin();
            session.save(banPhim);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void sua(BanPhim banPhim){
        try{
            session.getTransaction().begin();
            session.merge(banPhim);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void xoa(Integer id){
        try{
            session.getTransaction().begin();
            session.remove(this.getByID(id));
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}

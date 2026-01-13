package com.example.java_web_la_cai_gi.Buoi2.Repository;

import com.example.java_web_la_cai_gi.Buoi2.Model.TruongHoc;
import com.example.java_web_la_cai_gi.Buoi2.Util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class TruongHocRepository {
    private Session session = null;

    public TruongHocRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<TruongHoc> getAll(){
        return session.createQuery("SELECT th FROM TruongHoc th").list();
    }

    public TruongHoc getByID(Integer id){
        return session.find(TruongHoc.class, id);
    }

    public void them(TruongHoc truongHoc){
        try{
            session.getTransaction().begin();
            session.save(truongHoc);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void sua(TruongHoc truongHoc){
        try{
            session.getTransaction().begin();
            session.merge(truongHoc);
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

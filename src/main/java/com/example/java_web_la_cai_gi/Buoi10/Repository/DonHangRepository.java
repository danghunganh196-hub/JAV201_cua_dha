package com.example.java_web_la_cai_gi.Buoi10.Repository;

import com.example.java_web_la_cai_gi.Buoi10.Model.DonHang;
import com.example.java_web_la_cai_gi.Buoi10.Utility.HibernateConfig;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class DonHangRepository {
    Session session = null;

    public DonHangRepository(){
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<DonHang> getAll(){
        return session.createQuery("SELECT dh FROM DonHang dh").list();
    }

    public DonHang getByID(Integer id){
        return session.find(DonHang.class, id);
    }

    public void adddh(DonHang donHang){
        try{
            session.getTransaction().begin();
            session.save(donHang);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void suadh(DonHang donHang){
        try{
            session.getTransaction().begin();
            session.merge(donHang);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void xoadh(Integer id){
        try{
            session.getTransaction().begin();
            session.remove(this.getByID(id));
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public List<DonHang> timkiemTT(Boolean trangThai){
        Query query = session.createQuery("SELECT dh FROM DonHang dh WHERE dh.daGiao = :trangThai");
        query.setParameter("trangThai",trangThai);
        return query.getResultList();
    }

    public List<DonHang> sortDH(int min, int max){
        Query query = session.createQuery("SELECT dh FROM DonHang dh WHERE dh.soLuong BETWEEN :min AND :max");
        query.setParameter("min",  min);
        query.setParameter("max",  max);
        return query.getResultList();
    }

}

package com.example.java_web_la_cai_gi.Buoi2.Repository;

import com.example.java_web_la_cai_gi.Buoi2.Model.GiangVien;
import com.example.java_web_la_cai_gi.Buoi2.Util.HibernateConfig;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class GiangVienRepository {
    private Session session = null;

    public GiangVienRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<GiangVien> getAll(){
        return session.createQuery("SELECT gv FROM GiangVien gv").list();
    }

    public GiangVien getByID(Integer id){
        return session.find(GiangVien.class, id);
    }

    public void them(GiangVien giangVien){
        try{
            session.getTransaction().begin();
            session.save(giangVien);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void sua(GiangVien giangVien){
        try{
            session.getTransaction().begin();
            session.merge(giangVien);
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

    public List<GiangVien> timKiem(String ten){
        Query query = session.createQuery("SELECT gv FROM GiangVien gv WHERE gv.tenGiangVien LIKE :ten"); // JPQL
        query.setParameter("ten","%" + ten + "%");
        return query.getResultList();
    }

    public List<GiangVien> phanTrang(int page, int size){
        Query query = session.createQuery("SELECT gv FROM GiangVien gv");
        query.setFirstResult(page * size);
        query.setMaxResults(size);
        return query.getResultList();
    }
}

package com.example.java_web_la_cai_gi.Buoi2.Controller;

import com.example.java_web_la_cai_gi.Buoi2.Model.GiangVien;
import com.example.java_web_la_cai_gi.Buoi2.Model.TruongHoc;
import com.example.java_web_la_cai_gi.Buoi2.Repository.GiangVienRepository;
import com.example.java_web_la_cai_gi.Buoi2.Repository.TruongHocRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="giangVienController",value = {"/giang-vien/hien-thi",
        "/giang-vien/view-update",
        "/giang-vien/them",
        "/giang-vien/xoa",
        "/giang-vien/sua"
})
public class GiangVienController extends HttpServlet {
    GiangVienRepository giangVienRepository = new GiangVienRepository();
    TruongHocRepository truongHocRepository = new TruongHocRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")){
            hienThi(req,resp);
        }else if(uri.contains("view-update")){
            viewUpdate(req, resp);
        }
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));

        GiangVien gv = giangVienRepository.getByID(id);

        req.setAttribute("gv_detail", id);
        req.setAttribute("listGiangVien",giangVienRepository.getAll());
        req.getRequestDispatcher("/buoi4/hien-thi.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listTruongHoc",truongHocRepository.getAll());

        req.setAttribute("listGiangVien",giangVienRepository.getAll());
        req.getRequestDispatcher("/buoi4/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("them")){
            them(req, resp);
        }
    }

    private void them(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        TruongHoc truongHoc = new TruongHoc();
        Integer id = Integer.valueOf(req.getParameter(req.getParameter("truongId")));
        TruongHoc truongHoc = truongHocRepository.getByID(id);

        String tenGiangVien = req.getParameter("tenGiangVien");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));

        String tenTruong = req.getParameter("tenTruong");
        String diaChi = req.getParameter("diaChi");

        GiangVien giangVien = new GiangVien();
        giangVien.setTenGiangVien(tenGiangVien);
        giangVien.setTuoi(tuoi);
        giangVien.setGioiTinh(gioiTinh);

//        truongHoc.setTenTruong(tenTruong);
//        truongHoc.setDiaChi(diaChi);

        giangVien.setTruongHoc(truongHoc);

        giangVienRepository.them(giangVien);

        resp.sendRedirect("/giang-vien/hien-thi");
    }
}

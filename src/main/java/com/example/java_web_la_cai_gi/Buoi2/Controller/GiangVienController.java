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
        "/giang-vien/sua",
        "/giang-vien/tim-kiem"
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
        }else if(uri.contains("xoa")){
            xoa(req, resp);
        }else if(uri.contains("tim-kiem")){
            timKiem(req,resp);
        }
    }

    private void timKiem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenGiangVien = req.getParameter("tenGiangVien");
        req.setAttribute("listGiangVien",giangVienRepository.timKiem(tenGiangVien));
        req.setAttribute("listTruongHoc",truongHocRepository.getAll());
        req.getRequestDispatcher("/buoi4/hien-thi.jsp").forward(req, resp);
    }

    private void xoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        giangVienRepository.xoa(id);
        resp.sendRedirect("/giang-vien/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));

        GiangVien gv = giangVienRepository.getByID(id);

        req.setAttribute("gv", gv);
        req.setAttribute("listGiangVien",giangVienRepository.getAll());
        req.setAttribute("listTruongHoc",truongHocRepository.getAll());
        req.getRequestDispatcher("/buoi4/view-update.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listTruongHoc",truongHocRepository.getAll());

//        String truongId = req.getParameter("truongId");
//        if(truongId != null){
//            TruongHoc truongHoc = truongHocRepository.getByID(Integer.valueOf(truongId));
//            req.setAttribute("diaChi",truongHoc.getDiaChi());
//        }

        req.setAttribute("listGiangVien",giangVienRepository.getAll());
        req.getRequestDispatcher("/buoi4/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("them")){
            them(req, resp);
        }else if(uri.contains("sua")){
            sua(req, resp);
        }
    }

    private void sua(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer truongId = Integer.valueOf(req.getParameter("truongId"));
        TruongHoc truongHoc = truongHocRepository.getByID(truongId);

        Integer id = Integer.valueOf(req.getParameter("id"));
        String tenGiangVien = req.getParameter("tenGiangVien");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));

        GiangVien giangVien = new GiangVien(id,tenGiangVien,tuoi,gioiTinh,truongHoc);
//        giangVien.setId(id);
//        giangVien.setTenGiangVien(tenGiangVien);
//        giangVien.setTuoi(tuoi);
//        giangVien.setGioiTinh(gioiTinh);

//        giangVien.setTruongHoc(truongHoc);

        giangVienRepository.sua(giangVien);

        resp.sendRedirect("/giang-vien/hien-thi");
    }

    private void them(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer truongId = Integer.valueOf(req.getParameter("truongId"));
        TruongHoc truongHoc = truongHocRepository.getByID(truongId);

        String tenGiangVien = req.getParameter("tenGiangVien");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));

        GiangVien giangVien = new GiangVien(null, tenGiangVien,tuoi,gioiTinh,truongHoc);
//        giangVien.setTenGiangVien(tenGiangVien);
//        giangVien.setTuoi(tuoi);
//        giangVien.setGioiTinh(gioiTinh);
//
//        giangVien.setTruongHoc(truongHoc);

        giangVienRepository.them(giangVien);

        resp.sendRedirect("/giang-vien/hien-thi");
    }


}

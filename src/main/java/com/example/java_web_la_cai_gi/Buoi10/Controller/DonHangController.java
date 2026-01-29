package com.example.java_web_la_cai_gi.Buoi10.Controller;

import com.example.java_web_la_cai_gi.Buoi10.Model.DonHang;
import com.example.java_web_la_cai_gi.Buoi10.Model.MonAn;
import com.example.java_web_la_cai_gi.Buoi10.Repository.DonHangRepository;
import com.example.java_web_la_cai_gi.Buoi10.Repository.MonAnRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "donHangController",value = {
        "/don-hang/hien-thi",
        "/don-hang/them",
        "/don-hang/sua",
        "/don-hang/xoa",
        "/don-hang/view-update",
        "/don-hang/tim-kiem-trang-thai",
        "/don-hang/sap-xep"
})
public class DonHangController extends HttpServlet {
    DonHangRepository donHangRepository = new DonHangRepository();
    MonAnRepository monAnRepository = new MonAnRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")){
            hienThi(req, resp);
        }else if(uri.contains("view-update")){
            viewUpdate(req,resp);
        }else if(uri.contains("xoa")){
            xoa(req,resp);
        }else if(uri.contains("tim-kiem-trang-thai")){
            timKiemTT(req,resp);
        }else if(uri.contains("sap-xep")){
            sortDH(req,resp);
        }
    }

    private void sortDH(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int min = Integer.valueOf(req.getParameter("min"));
        int max = Integer.valueOf(req.getParameter("max"));
        req.setAttribute("listDonHang",donHangRepository.sortDH(min,max));
        req.setAttribute("listMonAn",monAnRepository.getAll());
        req.getRequestDispatcher("/buoi10/hien-thi.jsp").forward(req, resp);
    }

    private void timKiemTT(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean trangThai = Boolean.valueOf(req.getParameter("trangThai"));
        req.setAttribute("listDonHang",donHangRepository.timkiemTT(trangThai));
        req.setAttribute("listMonAn",monAnRepository.getAll());
        req.getRequestDispatcher("/buoi10/hien-thi.jsp").forward(req, resp);
    }

    private void xoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        donHangRepository.xoadh(id);
        resp.sendRedirect("/don-hang/hien-thi");
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listDonHang",donHangRepository.getAll());
        req.setAttribute("listMonAn",monAnRepository.getAll());
        req.getRequestDispatcher("/buoi10/hien-thi.jsp").forward(req,resp);
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));

        req.setAttribute("dh",donHangRepository.getByID(id));

        req.setAttribute("listDonHang",donHangRepository.getAll());
        req.setAttribute("listMonAn",monAnRepository.getAll());
        req.getRequestDispatcher("/buoi10/view-update.jsp").forward(req,resp);
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

    private void them(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer monAnID = Integer.valueOf(req.getParameter("id_mon_an"));

        String khachHang = req.getParameter("khachHang");
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));
        Boolean daGiao = Boolean.valueOf(req.getParameter("daGiao"));

        MonAn monAn = monAnRepository.getByID(monAnID);

        DonHang donHang = new DonHang(null,khachHang,soLuong,daGiao,monAn);

        donHangRepository.adddh(donHang);

        resp.sendRedirect("/don-hang/hien-thi");
    }

    private void sua(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer monAnID = Integer.valueOf(req.getParameter("id_mon_an"));

        Integer id = Integer.valueOf(req.getParameter("id"));

        String khachHang = req.getParameter("khachHang");
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));
        Boolean daGiao = Boolean.valueOf(req.getParameter("daGiao"));

        MonAn monAn = monAnRepository.getByID(monAnID);

        DonHang donHang = new DonHang(id,khachHang,soLuong,daGiao,monAn);

        donHangRepository.suadh(donHang);

        resp.sendRedirect("/don-hang/hien-thi");
    }
}
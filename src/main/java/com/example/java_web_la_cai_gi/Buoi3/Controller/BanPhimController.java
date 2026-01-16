package com.example.java_web_la_cai_gi.Buoi3.Controller;

import com.example.java_web_la_cai_gi.Buoi3.Model.BanPhim;
import com.example.java_web_la_cai_gi.Buoi3.Repo.BanPhimRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name="BanPhimController", value={
            "/ban-phim/hien-thi",
            "/ban-phim/view-update",
            "/ban-phim/xoa",
            "/ban-phim/them",
            "/ban-phim/sua"
    })
public class BanPhimController extends HttpServlet{
    BanPhimRepository banPhimRepository = new BanPhimRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")){
            hienThi(req, resp);
        }else if(uri.contains("view-update")){
            viewUpdate(req, resp);
        }else if(uri.contains("xoa")){
            xoa(req, resp);
        }
    }

    private void xoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));

        banPhimRepository.xoa(id);

        resp.sendRedirect("/ban-phim/hien-thi");
    }


    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));

        BanPhim banPhim = banPhimRepository.getByID(id);

        req.setAttribute("bp", banPhim);
        req.setAttribute("listBanPhim",banPhimRepository.getAll());
        req.getRequestDispatcher("/buoi3/hien-thi.jsp").forward(req,resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listBanPhim",banPhimRepository.getAll());
        req.getRequestDispatcher("/buoi3/hien-thi.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("them")){
            them(req,resp);
        }else if(uri.contains("sua")){
            sua(req, resp);
        }
    }

    private void sua(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String tenBanPhim = req.getParameter("tenBanPhim");
        Boolean tinhTrang = Boolean.valueOf(req.getParameter("tinhTrang"));
        Float gia = Float.valueOf(req.getParameter("gia"));
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));

        BanPhim banPhim = banPhimRepository.getByID(id);
        banPhim.setTenBanPhim(tenBanPhim);
        banPhim.setTinhTrang(tinhTrang);
        banPhim.setGia(gia);
        banPhim.setSoLuong(soLuong);

        banPhimRepository.sua(banPhim);

        resp.sendRedirect("/ban-phim/hien-thi");
    }

    private void them(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tenBanPhim = req.getParameter("tenBanPhim");
        Boolean tinhTrang = Boolean.valueOf(req.getParameter("tinhTrang"));
        Float gia = Float.valueOf(req.getParameter("gia"));
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));

        BanPhim banPhim = new BanPhim();
        banPhim.setTenBanPhim(tenBanPhim);
        banPhim.setTinhTrang(tinhTrang);
        banPhim.setGia(gia);
        banPhim.setSoLuong(soLuong);

        banPhimRepository.them(banPhim);

        resp.sendRedirect("/ban-phim/hien-thi");
    }


}


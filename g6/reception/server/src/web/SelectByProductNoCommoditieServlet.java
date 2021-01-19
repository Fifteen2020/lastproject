package web;

import bean.Commodity;
import com.google.gson.Gson;
import dao.CommodityDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/SelectByProductNoCommoditieServlet")
public class SelectByProductNoCommoditieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productNo = Integer.parseInt(request.getParameter("productNo"));
        try {
            Commodity commodities = new CommodityDao().selectbyproductNocommoditie(new Commodity(productNo));
            PrintWriter writer = response.getWriter();
            writer.println(new Gson().toJson(commodities));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

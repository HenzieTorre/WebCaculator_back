package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import mapper.RecordMapper;
import util.SqlSessionUtil;
public class ClearHistoryServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Expires", "0");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        SqlSession session = SqlSessionUtil.openSession();
        RecordMapper mapper = session.getMapper(RecordMapper.class);
        int i = mapper.deleteAll();
        writer.print("成功删除" + i + "条记录");
        session.commit();
        session.close();
    }
}

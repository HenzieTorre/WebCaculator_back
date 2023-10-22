package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import mapper.RecordMapper;
import pojo.Record;
import util.SqlSessionUtil;

public class StoreServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("66666===============================================================");
        resp.setContentType("text/html;charset=UTF-8");
        // PrintWriter writer = resp.getWriter();
        String equation = req.getParameter("equation");
        String result = req.getParameter("result");

        equation = equation.replace("!", "+");
        equation = equation.replace("~", "%");
        equation = equation.replace("b", "^");

        SqlSession session = SqlSessionUtil.openSession();
        RecordMapper mapper = session.getMapper(RecordMapper.class);
        Record newRecord = new Record();
        newRecord.setEquation(equation);
        newRecord.setAnswer(result);
        mapper.insert(newRecord);
        session.commit();
        session.close();
    }
}

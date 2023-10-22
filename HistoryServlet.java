package Servlet;

import com.alibaba.fastjson.JSON;
import mapper.RecordMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.Record;
import util.SqlSessionUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
public class HistoryServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Pragma","no-cache");
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Expires","0");
        PrintWriter writer = resp.getWriter();
        SqlSession session = SqlSessionUtil.openSession();
        RecordMapper mapper = session.getMapper(RecordMapper.class);
        List<Record> records = mapper.selectLast10();
        session.close();
        for (Record record:records
        ) {
            record.setEquation(record.getEquation().replace("√","&radic;"));
            record.setEquation(record.getEquation().replace("π","&pi;"));
        }
        String jsonString = JSON.toJSONString(records);
        System.out.println(jsonString);
        writer.print(jsonString);
    }
}

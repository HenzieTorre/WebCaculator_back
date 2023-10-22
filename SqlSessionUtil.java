package util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class SqlSessionUtil {
    private SqlSessionUtil() {}

    private static final SqlSessionFactory SQL_SESSION_FACTORY;
    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SQL_SESSION_FACTORY = new SqlSessionFactoryBuilder().build(is);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 定义一个全局的，服务器级别的session，一个服务器定义一个即可
    private static final ThreadLocal<SqlSession> LOCAL = new ThreadLocal<>();

    public static SqlSession openSession() {
        SqlSession session = LOCAL.get();
        if (session == null) {
            session = SQL_SESSION_FACTORY.openSession();
            // 将SqlSession对象绑定到线程上
            LOCAL.set(session);
        }
        return session;
    }

    public static void close(SqlSession session) {
        if (session == null) {
            session.close();
            LOCAL.remove();
        }
    }
}

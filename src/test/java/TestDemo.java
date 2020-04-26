import com.damu.entity.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestDemo {




    @Test
    public void testDemo1() throws IOException {
        //初始化 mybatis 环境
        String resource = "mybatis-config.xml";


        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //打开数据 会话
        SqlSession session = factory.openSession();


        List<Users> ulist = session.selectList("usersList");
        for(Users user : ulist){
            System.out.println(user);
        }
        session.close();
    }
}

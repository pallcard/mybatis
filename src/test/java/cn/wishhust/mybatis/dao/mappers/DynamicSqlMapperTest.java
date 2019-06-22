package cn.wishhust.mybatis.dao.mappers;

import cn.wishhust.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class DynamicSqlMapperTest {

    private DynamicSqlMapper dynamicSqlMapper;

    @Before
    public void setUp() throws Exception {
        // 指定配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 1. 映射文件的命名空间（namespace）必须是mapper接口的全路径
        // 2. 映射文件的statement的id必须和mapper接口的方法名保持一致
        // 3. Statement的resultType必须和mapper接口方法的返回类型一致
        // 4. statement的parameterType必须和mapper接口方法的参数类型一致（不一定）
        this.dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);

    }

    @Test
    public void queryUserListByName() {
        List<User> users = dynamicSqlMapper.queryUserListByName("");
        System.out.println(users.toString());
    }

    @Test
    public void queryUserListByNameOrAge() {
        List<User> users = dynamicSqlMapper.queryUserListByNameOrAge("bigGod222", 20);
        System.out.println(users.size());
    }

    @Test
    public void queryUserListByNameAndAge() {
        List<User> users = dynamicSqlMapper.queryUserListByNameAndAge("ls", 21);
        System.out.println(users.size());
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("静静");
        user.setPassword("123456");
        user.setSex(0);
        user.setUserName("Jinjin");
        user.setId(4);
        this.dynamicSqlMapper.updateUser(user);

    }

    @Test
    public void queryUserListByIds() {
        List<User> users = this.dynamicSqlMapper.queryUserListByIds(new int[]{1,2,3,4});
        for (User user : users) {
            System.out.println(user);
        }

    }
}

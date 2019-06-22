package cn.wishhust.mybatis.dao.mappers;

import cn.wishhust.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSqlMapper {
    // 动态sql if
    // 需求：查询用户，如果输入了姓名，则按姓名查询
    List<User> queryUserListByName(@Param("userName") String userName);

    // 动态sql choose when otherwise
    // 需求：查询用户，如果输入了姓名则按照姓名模糊查找，
    // 否则如果输入了年龄则按照年龄查找，否则查找姓名为“ls”的用户。
    List<User> queryUserListByNameOrAge(@Param("userName") String userName,
                                        @Param("age") Integer age);
    // 动态sql where 和 set
    // 需求1：查询所有用户，如果输入了姓名按照姓名进行模糊查询，
    // 如果输入年龄，按照年龄进行查询，
    // 如果两者都输入，两个条件都要成立。
    List<User> queryUserListByNameAndAge(@Param("userName") String userName,
                                         @Param("age") Integer age);
    // 需求2：修改用户信息，如果参数user中的某个属性为null，则不修改。
    void updateUser(User user);

    // 动态sql foreach
    // 需求：按照多个id查询用户信息
    List<User> queryUserListByIds(@Param("ids") int[] ids);
}

package cn.wishhust.mybatis.dao.mappers;

import cn.wishhust.mybatis.pojo.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    /**
     * 根据订单号查询订单用户的信息
     * @param number
     * @return
     */
    Order queryOrderWithUserByOrderNumber(@Param("number") String number);


}

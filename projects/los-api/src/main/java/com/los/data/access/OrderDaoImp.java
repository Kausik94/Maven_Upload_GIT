package com.los.data.access;

import com.los.entity.FoodOrder;
import com.los.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class OrderDaoImp extends JdbcDaoSupport implements OrderDao {
    @Autowired
    DataSource dataSource;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
        this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public void addOrder(FoodOrder foodOrder)
    {

        String sql = "INSERT INTO foodorder " +
                "(date,userid,providerid,meal,quantity,amount) VALUES (?,?, ?,?,?,?)";

        int amount = foodOrder.getQuantity() * foodOrder.getAmount();

        getJdbcTemplate().update(sql, new Object[]{
                foodOrder.getDate(),foodOrder.getUserId(), foodOrder.getProviderId() ,foodOrder.getMeal(),foodOrder.getQuantity(),amount
        });
    }

    @Override
    public List<FoodOrder> getAllOrders() {
        String sql="select * from foodorder";
        List<FoodOrder> orderList = getJdbcTemplate().query(sql, new OrderMapper());

        return  orderList;
    }

    @Override
    public FoodOrder getOrderById(int orderId) {
        String sql="select * from foodorder where orderid=?";
        FoodOrder foodOrder= (FoodOrder) getJdbcTemplate().queryForObject(sql, new Object[]{orderId}, new OrderMapper());
        return foodOrder;
    }

    @Override
    public List<FoodOrder> getOrderByUserId(int userId) {
        String sql="select * from foodorder where userid=?";
        List<FoodOrder> orderList1 = getJdbcTemplate().query(sql, new Object[]{userId}, new OrderMapper());
        return orderList1 ;
    }

    @Override
    public List<FoodOrder> getOrderByPoviderId(int providerId) {
        String sql="select * from foodorder where providerid=?";
        List<FoodOrder> orderList1=  getJdbcTemplate().query(sql, new Object[]{providerId}, new OrderMapper());
        return orderList1;
    }

    @Override
    public List<FoodOrder> getOrderByDate(String date) {
        String sql="select * from foodorder where date=?";
        List<FoodOrder> orderList1=  getJdbcTemplate().query(sql, new Object[]{date}, new OrderMapper());
        return orderList1;
    }


    @Override
    public void deleteOrder(int orderId) {
        try{
            String sql = "DELETE FROM foodorder where orderid=?";
            int rows = getJdbcTemplate().update(sql,orderId);
            System.out.println("UPDATED " + rows);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public void updateOrder(FoodOrder foodOrder) {
        String sql="update foodorder set providerid=? ,meal=? , quantity=? where orderid=?";

        int id = foodOrder.getOrderId();
        try {
            int rows = getJdbcTemplate().update(sql,foodOrder.getProviderId(),foodOrder.getMeal(),foodOrder.getQuantity(),id);
            System.out.println( rows + " rows UPDATED ");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

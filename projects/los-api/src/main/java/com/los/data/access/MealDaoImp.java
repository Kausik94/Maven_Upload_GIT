package com.los.data.access;

import com.los.entity.Meal;
import com.los.mapper.MealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class MealDaoImp extends JdbcDaoSupport implements MealDao {

    @Autowired
    DataSource dataSource;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
        this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void addMeal(Meal meal)
    {

        String sql = "INSERT INTO meal " +
                "(mealname,providerid,price) VALUES (?,?,?)";



        getJdbcTemplate().update(sql, new Object[]{
                meal.getMealName(),meal.getProviderId(), meal.getPrice()
        });
    }

    @Override
    public List<Meal> getAllMeals() {
        String sql="select * from meal";
        List<Meal> mealList = getJdbcTemplate().query(sql, new MealMapper());

        return  mealList;
    }

    @Override
    public Meal getMealById(int mealId) {
        String sql="select * from meal where mealid=?";
        Meal meal= (Meal) getJdbcTemplate().queryForObject(sql, new Object[]{mealId}, new MealMapper());
        return meal;
    }

//    @Override
//    public List<FoodOrder> getOrderByUserId(int userId) {
//        String sql="select * from foodorder where userid=?";
//        List<FoodOrder> orderList1 = getJdbcTemplate().query(sql, new Object[]{userId}, new OrderMapper());
//        return orderList1 ;
//    }
//
//    @Override
//    public List<FoodOrder> getOrderByPoviderId(int providerId) {
//        String sql="select * from foodorder where providerid=?";
//        List<FoodOrder> orderList1=  getJdbcTemplate().query(sql, new Object[]{providerId}, new OrderMapper());
//        return orderList1;
//    }
//
//    @Override
//    public List<FoodOrder> getOrderByDate(String date) {
//        String sql="select * from foodorder where date=?";
//        List<FoodOrder> orderList1=  getJdbcTemplate().query(sql, new Object[]{date}, new OrderMapper());
//        return orderList1;
//    }


    @Override
    public void deleteMeal(int mealId) {
        try{
            String sql = "DELETE FROM meal where mealid=?";
            int rows = getJdbcTemplate().update(sql,mealId);
            System.out.println("UPDATED " + rows);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public void updateMeal(Meal meal) {
        String sql="update meal set mealname=? ,providerid=? , price=? where mealid=?";

        int id = meal.getMealId();
        try {
            int rows = getJdbcTemplate().update(sql,meal.getMealName(),meal.getProviderId(),meal.getPrice(),id);
            System.out.println( rows + " rows UPDATED ");
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}

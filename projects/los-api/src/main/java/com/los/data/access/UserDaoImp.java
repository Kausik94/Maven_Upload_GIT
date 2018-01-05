package com.los.data.access;
import com.los.entity.User;
import com.los.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by nuwantha on 11/10/16.
 */
@Repository
public class UserDaoImp extends JdbcDaoSupport implements UserDao{

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }


    @Override
    public void updateUserAccount(User user) {
        String sql="update userh set role=? , dep_id=? where email=?";
        System.out.println(user.getEmail());
        try {
            int rows = getJdbcTemplate().update(sql, user.getRole(), Integer.parseInt(user.getDepId()), user.getEmail());
            System.out.println( rows + " rows UPDATED ");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void createUserAccount(User user) {
        System.out.println(user.getDepId()+" "+user.getRole()+" "+user.getUserName());
        String sql = "INSERT INTO userh " +
                "(name,email,role,dep_id) VALUES (?,?,?,?)" ;
        getJdbcTemplate().update(sql,user.getUserName(),user.getEmail(),String.valueOf(user.getRole()),Integer.parseInt(user.getDepId())
        );

    }

    @Override
    public List<User> getAllUsers() {
        String sql="select * from userh";
        List<User> userList = getJdbcTemplate().query(sql, new UserMapper());
        return userList;
    }

    @Override
    public User getUserByName(String name) {
        String sql="select * from userh where name= ?";
        User user= (User) getJdbcTemplate().queryForObject(sql, new Object[]{name}, new UserMapper());
        return user;
    }

    @Override
    public User getUserById(int id) {
        String sql="select * from userh where userid= ?";
        User user= (User) getJdbcTemplate().queryForObject(sql, new Object[]{id}, new UserMapper());
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        String sql="select * from userh where email=?";
        System.out.println("EMAIL FROM" + sql);
        try{
            User user= (User) getJdbcTemplate().queryForObject(sql, new Object[]{email}, new UserMapper());
            return user;
        } catch (Exception e){
            System.out.println("EMPTY result");
        }
        return null;
    }

    @Override
    public int getUserCount() {
        String sql="select count(*) from userh";
        int epmloyeeCount = getJdbcTemplate().queryForObject(sql, Integer.class);
        return  epmloyeeCount;
    }

    @Override
    public boolean isUserHasAccountByEmail(String email) {
        String sql="select count( *) from userh where email=?";
        int count = getJdbcTemplate().queryForObject(sql, Integer.class,email);
        if(count==0) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean isUserHasAccount(String userName) {
        String sql="select count( *) from userh where name=?";
        int count = getJdbcTemplate().queryForObject(sql, Integer.class,userName);
        if(count==0) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public List<User> getUserHasNotLeaveToday() {
        Date date = new Date();
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        String  dateS= simpleDateFormat.format(date);
        Date dateD=null;
        try {
            dateD= simpleDateFormat.parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String sql="select * from userh where userid not in(select userid from leave where leavedate=?)";
        List<User> userList = getJdbcTemplate().query(sql, new Object[]{dateD}, new UserMapper());
        return userList;

    }

}

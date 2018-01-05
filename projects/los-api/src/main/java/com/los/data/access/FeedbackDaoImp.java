package com.los.data.access;

import com.los.entity.Feedback;
import com.los.mapper.FeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class FeedbackDaoImp extends JdbcDaoSupport implements FeedbackDao {
    @Autowired
    DataSource dataSource;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
        this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
    }
    @Override
    public List<Feedback> getAllFeedbacks() {
        String sql="select * from feedback";
        List<Feedback> feedbackList = getJdbcTemplate().query(sql, new FeedbackMapper());

        return  feedbackList;
    }

    @Override
    public void addFeedback(Feedback feedback)
    {

        String sql = "INSERT INTO feedback " +
                "(userid,providerid,meal,feedback) VALUES (?,?,?,?)";
        getJdbcTemplate().update(sql, new Object[]{
                 feedback.getUserId(), feedback.getProviderId() ,feedback.getMeal(),feedback.getFeedback()

        });
    }
}

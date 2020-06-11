package com.reda.engine.center.dao.impl;

import com.reda.engine.center.dao.RuleManageDao;
import com.reda.engine.center.entity.Rule;
import com.reda.engine.center.utils.GetConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class RuleManageDaoImpl implements RuleManageDao {

    @Override
    public void insert(Rule rule)  {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            String sql = "insert into rule_table (uuid,rule_name,rule_body,up_line,create_by,create_date,updata_date) " +
                    "value"+ "(" +"'"+ 3+"'"+ "," +
                    "'"+ rule.getRuleName() +"'"+ "," +
                    "'"+rule.getRuleBody() + "'"+"," +
                    "'"+"Y" + "'"+"," +
                    "'"+rule.getCreateBy() +"'"+ "," +
                    "null"+ "," +
                    "null"
                    + ")";
            connection = GetConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
//            connection.commit();
        } catch (Exception e) {
e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    @Override
    public List selectAll() {
        return null;
    }

    @Override
    public void delete(Rule rule) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            String sql = "delete from rule_table where uuid = "+ rule.getUuid();
            connection = GetConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            connection.commit();
        } catch (Exception e) {

        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void update(Rule rule) {


    }
}

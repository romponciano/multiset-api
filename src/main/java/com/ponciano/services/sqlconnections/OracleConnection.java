package com.ponciano.services.sqlconnections;

import com.ponciano.models.database.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OracleConnection extends SQLBaseConnection {

    @Autowired
    public OracleConnection() {}

    @Override
    public void loadDriver() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public List<Attribute> listAllAttributes(String table) throws SQLException {
        String sql = "SELECT column_name FROM all_tab_cols WHERE table_name = '{TABLE_NAME}';";
        ResultSet resultSet = getConnection().createStatement().executeQuery(
                sql.replace("{TABLE_NAME}", table)
        );
        List<Attribute> out = new ArrayList<>();
        while(resultSet.next()) {
            Attribute attr = new Attribute();
            attr.setDatabase(getInfo().getDatabase());
            attr.setTable(table);
            attr.setName(resultSet.getString("column_name"));
            attr.setType(resultSet.getString("data_type"));
            attr.setKey(attr.getDatabase() + "." + attr.getTable() + "." + attr.getName());
            out.add(attr);
        }
        return out;
    }
}

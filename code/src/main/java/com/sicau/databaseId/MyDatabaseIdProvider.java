package com.sicau.databaseId;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class MyDatabaseIdProvider implements DatabaseIdProvider {

    private static final String DATABASE_TYPE_DB2 = "BD2";
    private static final String DATABASE_TYPE_MYSQL = "MySQL";
    private static final String DATABASE_TYPE_ORACLE = "Oracle";

    private Logger log = Logger.getLogger(MyDatabaseIdProvider.class);

    @Override
    public void setProperties(Properties props) {
        log.info(props);
    }

    @Override
    public String getDatabaseId(DataSource dataSource) throws SQLException {
        Connection conn = dataSource.getConnection();
        // 获得数据库名称标识
        String dbProductName = conn.getMetaData().getDatabaseProductName();
        if (MyDatabaseIdProvider.DATABASE_TYPE_DB2.equals(dbProductName)){
            return "db2";
        } else if (MyDatabaseIdProvider.DATABASE_TYPE_MYSQL.equals(dbProductName)){
            return "mysql";
        } else if (MyDatabaseIdProvider.DATABASE_TYPE_ORACLE.equals(dbProductName)) {
            return "oracle";
        } else {
            return null;
        }
    }
}

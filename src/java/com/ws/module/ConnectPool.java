/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ws.module;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

/**
 *
 * @author leo
 */
public class ConnectPool {
    
    public Connection preparedConnectionPool(){
        PoolProperties p = new PoolProperties();
	p.setUrl("jdbc:mysql://210.80.86.237:3306/acer_pushapp?useUnicode=true&characterEncoding=utf-8");
	p.setDriverClassName("com.mysql.jdbc.Driver");
	p.setUsername("acer");
	p.setPassword("qpwoeiruty");
	p.setJmxEnabled(true);
	p.setTestWhileIdle(false);
	p.setTestOnBorrow(true);
	p.setValidationQuery("SELECT 1");
	p.setTestOnReturn(false);
	p.setValidationInterval(30000);
	p.setTimeBetweenEvictionRunsMillis(30000);
	p.setMaxActive(100);
	p.setInitialSize(10);
	p.setMaxWait(10000);
	p.setRemoveAbandonedTimeout(60);
	p.setMinEvictableIdleTimeMillis(30000);
	p.setMinIdle(10);
	p.setLogAbandoned(true);
	p.setRemoveAbandoned(true);
	p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
	  "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
	DataSource datasource = new DataSource();
	datasource.setPoolProperties(p);

	Connection con = null;
        try {
            con = datasource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public void test(){
    PoolProperties p = new PoolProperties();
	p.setUrl("jdbc:mysql://210.80.86.237:3306/acer_pushapp?useUnicode=true&characterEncoding=utf-8");
	p.setDriverClassName("com.mysql.jdbc.Driver");
	p.setUsername("acer");
	p.setPassword("qpwoeiruty");
	p.setJmxEnabled(true);
	p.setTestWhileIdle(false);
	p.setTestOnBorrow(true);
	p.setValidationQuery("SELECT 1");
	p.setTestOnReturn(false);
	p.setValidationInterval(30000);
	p.setTimeBetweenEvictionRunsMillis(30000);
	p.setMaxActive(100);
	p.setInitialSize(10);
	p.setMaxWait(10000);
	p.setRemoveAbandonedTimeout(60);
	p.setMinEvictableIdleTimeMillis(30000);
	p.setMinIdle(10);
	p.setLogAbandoned(true);
	p.setRemoveAbandoned(true);
	p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
	  "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
	DataSource datasource = new DataSource();
	datasource.setPoolProperties(p);

	Connection con = null;
	try {
	  con = datasource.getConnection();
	  Statement st = con.createStatement();
	  ResultSet rs = st.executeQuery("select * from user");
	  int cnt = 1;
	  while (rs.next()) {
	      System.out.println((cnt++)+". Name:" +rs.getString("name")+
		" email:"+rs.getString("email")+" Password:"+rs.getString("password"));
	  }
	  rs.close();
	  st.close();
	} catch (SQLException ex) {
            Logger.getLogger(ConnectPool.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
	  if (con!=null) try {con.close();}catch (Exception ignore) {}
	}
    }
    
}

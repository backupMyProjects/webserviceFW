/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ws.controller;

import LeoLib.tools.CommonDAO;
import static LeoLib.utils.Constants.DBServer.MySQL;
import LeoLib.utils.DBPrepared;
import static LeoLib.utils.DBPrepared.*;
import com.ws.module.ConnectPool;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author leo
 */
@WebServlet(name = "ServletSample", urlPatterns = {"/ServletSample", "/TestServlet"})
public class ServletSample extends ServletBase {
    
    @Override
    protected void processRequest()
            throws ServletException, IOException {
        try {
            /************************ DATA MODULE *****************************/
            /** Workable original sample. */
            /* Sample
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://210.80.86.237:3306/acer_pushapp?useUnicode=true&characterEncoding=utf-8","acer","qpwoeiruty");
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user WHERE name=? AND password=?");
            stmt.setString(1, "author1");
            stmt.setString(2, "author1");
            ResultSet rs = stmt.executeQuery();
            */
            
            /** Connect Pool Style. */
            /* Sample
            String sql = "SELECT * FROM getUser WHERE name=? AND password=?";
            List<String> where = new ArrayList();
            where.add("author1");
            where.add("author1");
            
            ConnectPool cp = new ConnectPool();
            Connection con = cp.preparedConnectionPool();
            
            DBPrepared dbp = new DBPrepared("com.mysql.jdbc.Driver", "jdbc:mysql://210.80.86.237:3306/acer_pushapp?useUnicode=true&characterEncoding=utf-8","acer","qpwoeiruty");
            dbp.setConnection(con);
            List resultList1 = dbp.getDataList(sql, where);
            dbp.disconnect();
            
            LeoLib.tools.Toolets.printALHM((ArrayList<HashMap>) resultList1);
            */
            
            /** Single Connect Style */
            /* Sample
            String sql = "SELECT * FROM getUser WHERE name=? AND password=?";
            List<String> where = new ArrayList();
            where.add("author1");
            where.add("author1");
            
            DBPrepared dbp = new DBPrepared("com.mysql.jdbc.Driver", "jdbc:mysql://210.80.86.237:3306/acer_pushapp?useUnicode=true&characterEncoding=utf-8","acer","qpwoeiruty");
            List resultList1 = dbp.getDataListConn(sql, where);
            
            LeoLib.tools.Toolets.printALHM((ArrayList<HashMap>) resultList1);
            */
            
            /************************ RESULT **********************************/
            
            /** String Result */
            /* Sample 
            String result = "<html>Hello</html>";
            */
            /** Type I */
            //this.dispatchPageXML(ResultType.XML, "/resultString.jsp", result);
            /** Type II */
            //this.dispatchPageXML("/resultString.jsp", result);
            /** Type III */
            //this.dispatchPageXML(result);
            
            /** List Result */
            /* Sample
            ArrayList<HashMap<String,String>> resultList = new ArrayList<>();
            HashMap<String,String> hm = new HashMap<>();
            hm.put("name", "Leo");
            hm.put("email", "hello123@gmail.com");
            resultList.add(hm);
            */
            /** Type I */
            //this.dispatchPageXML(ResultType.XML, "/resultList.jsp", resultList);
            /** Type II */
            //this.dispatchPageXML("/resultList.jsp", resultList);
            /** Type III */
            //this.dispatchPageXML(resultList);
            
            /************************ Template ********************************/
            String sql = "SELECT * FROM getUser WHERE name=? AND password=?";
            List<String> where = new ArrayList();
            where.add("author1");
            where.add("author1");
            
            DBPrepared dbp = new DBPrepared(
                    MYSQL_DRIVER, 
                    "jdbc:mysql://210.80.86.237:3306/acer_pushapp?useUnicode=true&characterEncoding=utf-8",
                    "acer",
                    "qpwoeiruty");
            this.dispatchPageXML(dbp.getDataListCon(sql, where));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletSample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletSample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServletSample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

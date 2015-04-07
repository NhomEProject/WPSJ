/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.StudentEntityBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author NamIT
 */
public class StudentModelBean extends DataAccessHelper{
    
    Connection con;
    private final String GET_STUDENT_BY_ID = "select * from student";
    
    public ArrayList<StudentEntityBean> GetALL(){
        ArrayList<StudentEntityBean> objs = new ArrayList<>();
        try {
           con = getConnection();           
                PreparedStatement ps = con.prepareStatement(GET_STUDENT_BY_ID);
                ResultSet rs = ps.executeQuery();
                if(rs!=null){
                    while (rs.next()) {                
                       StudentEntityBean item = new StudentEntityBean();
                       item.setId(rs.getInt("id"));
                       item.setName(rs.getString("name"));
                       item.setAge(rs.getInt("age"));
                       item.setAdđress(rs.getString("[address]"));
                       objs.add(item);
                    }
                }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return objs;
    }
            
}

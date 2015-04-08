/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.ProductEntityBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author NamIT
 */
public class ProductModelBean extends DataAccessHelper{
    
    Connection con;
    private final String GET_PRODUCT_BY_ID = "select * from product where [user]=?";
    
    public ArrayList<ProductEntityBean> GetByID(String user){
        ArrayList<ProductEntityBean> objs = new ArrayList<>();
        try {
           con = getConnection();           
                PreparedStatement ps = con.prepareStatement(GET_PRODUCT_BY_ID);
                ps.setString(1,user);
                ResultSet rs = ps.executeQuery();
                if(rs!=null){
                    while (rs.next()) {                
                       ProductEntityBean item = new ProductEntityBean();
                       item.setId(rs.getInt("id"));
                       item.setName(rs.getNString("name"));
                       item.setAmount(rs.getInt("amout"));
                       item.setPrice(rs.getFloat("price"));
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author NamIT
 */
public class SessionModel {
    public boolean CheckSession(HttpServletRequest request){
        boolean check = false;
        HttpSession session = request.getSession(true);
        if(session.getAttribute("userName")!=null){
            check =true;
        }
        return check;
    }
}

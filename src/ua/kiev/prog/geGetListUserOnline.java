package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 07.11.2016.
 */
public class geGetListUserOnline extends HttpServlet {
    private  UserList userList = UserList.getInstance();
    private MessageList msgList = MessageList.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();

        if (cookies!=null) {
            for (Cookie cookie : cookies) {

                if (cookie.getName().equals("user"))
                {
                    if (userList.getUserbyLogin(cookie.getValue())!=null)
                    {

//   Залогиненый пользователь
                        String usersonline = userList.getOnlineUsersStr();
                        if (usersonline==null)
                              msgList.add(new Message("Server",cookie.getValue(),"All","No logined users"));
                        else
                        msgList.add(new Message("Server",cookie.getValue(),"All","Users online: "+usersonline));
                        return;
                    }

                }

            }
        }

        resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);




    }
}

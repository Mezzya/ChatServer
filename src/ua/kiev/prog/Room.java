package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 08.11.2016.
 */
public class Room extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Проверим зологиненый ли пользователь
        Cookie[] cookies = req.getCookies();

        if (cookies!=null)
        {

            for (Cookie cookie: cookies) {

                if (cookie.getName().equals("user"))
                {

//                   Залогиненый
                    String room = req.getParameter("room");

                    if (room!=null)
                    {
                        if (room.equals("exit"))
                        {
//                          Выходим из комнаты
                            Cookie cook = new Cookie("room","All");
                            resp.addCookie(cook);
                            return;

                        }
                        else
                        {

//                         Заходим в комнату
                           Cookie cook = new Cookie("room",room);
                           resp.addCookie(cook);
                           return;
                        }

                    }

                }

            }
        }
        resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);








    }
}

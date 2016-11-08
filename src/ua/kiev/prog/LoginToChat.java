package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by andre on 11/2/2016.
 */
public class LoginToChat extends HttpServlet {
    private UserList userList = UserList.getInstance();
    private MessageList msgList = MessageList.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
//        System.out.println(">> login= "+login+" pass ="+password+ " not found.");
        if (userList.check(login,password))
        {

//            Заделаем куки типа для валидации на 24 часа
            Cookie cookieOne = new Cookie("user",login);
            cookieOne.setMaxAge(60*60*24);
            resp.addCookie(cookieOne);
            Cookie cookieTwo = new Cookie("room","All");
            cookieTwo.setMaxAge(60*60*24);
            resp.addCookie(cookieTwo);



//            Все ок пускаем в чат
            System.out.println("User - "+login+" Connected to chat");
//            устанавливаем ползователя в онлайн
            userList.getUserbyLogin(login).setOnline(true);
//            добавляем пользоваетля в сессию
            HttpSession session = req.getSession(true);
//            Создадим сообщение что пользователь зашел
            msgList.add(new Message("Server",login+" connected"));
            session.setAttribute("user", userList.getUserbyLogin(login));
//            resp.setStatus(HttpServletResponse.SC_OK);
            resp.setContentType("Welcome to Chat server"+ login);
            return;
        }
        resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);






    }

}

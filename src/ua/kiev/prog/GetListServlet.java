package ua.kiev.prog;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetListServlet extends HttpServlet {
	
	private MessageList msgList = MessageList.getInstance();
	private UserList userList = UserList.getInstance();

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {


		Cookie[] cookies = req.getCookies();

		if (cookies!=null)
		{
			for (Cookie cookie: cookies ) {
//				System.out.println(cookie.getName()+" : "+cookie.getValue());
				if (cookie.getName().equals("user"))
				{


					if (userList.getUserbyLogin(cookie.getValue())!=null)
					{
//					Такой клиент присутствуетв списке пользователей. Можно отдавать чат

						String fromStr = req.getParameter("from");
						int from = 0;
						try {
							from = Integer.parseInt(fromStr);
						} catch (Exception ex) {
							resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
							return;
						}

						String json = msgList.toJSON(from, cookie.getValue());
						if (json != null) {
							OutputStream os = resp.getOutputStream();
							byte[] buf = json.getBytes(StandardCharsets.UTF_8);
							os.write(buf);
						}
						return;

					}

				}



			}
		}

		resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	}
}

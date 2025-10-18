package ru.itis.servlets;

import ru.itis.models.User;
import ru.itis.repository.UsersRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

    private UsersRepository usersRepository;
//    @Override
//    public void init() throws ServletException {
////        users = new ArrayList<>();
////        User userOne = User.builder()
////                .id(1L)
////                .firstName("Danil")
////                .lastName("Smirnov")
////                .age(40)
////                .build();
////
////        User userTwo = User.builder()
////                .id(2L)
////                .firstName("Kamil")
////                .lastName("Slabodenuk")
////                .age(18)
////                .build();
////
////        User userThree = User.builder()
////                .id(3L)
////                .firstName("Egor")
////                .lastName("Gazizanov")
////                .age(25)
////                .build();
////
////        users.add(userThree);
////        users.add(userTwo);
////        users.add(userOne);
//
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter writer = response.getWriter();
//
//        StringBuilder resultHtml = new StringBuilder();
//
//                resultHtml.append("<!DOCTYPE html>\n" +
//                "<html lang=\"en\">\n" +
//                "<head>\n" +
//                "    <meta charset=\"UTF-8\">\n" +
//                "    <title>Users</title>\n" +
//                "</head>\n" +
//                "<body>\n" +
//                "<h1>Users</h1>\n" +
//                "<div>\n" +
//                "    <table>\n" +
//                "        <tr>\n" +
//                "            <th>ID</th>\n" +
//                "            <th>FIRST NAME</th>\n" +
//                "            <th>LAST NAME</th>\n" +
//                "            <th>AGE</th>\n" +
//                "        </tr>\n");
//
//                for (User user : users) {
//                    resultHtml.append("<tr>\n");
//                    resultHtml.append("<td>").append(user.getId()).append("</td>\n");
//                    resultHtml.append("<td>").append(user.getFirstName()).append("</td>\n");
//                    resultHtml.append("<td>").append(user.getLastName()).append("</td>\n");
//                    resultHtml.append("<td>").append(user.getAge()).append("</td>\n");
//                    resultHtml.append("</tr>");
//                }
//
//                resultHtml.append("    </table>\n" +
//                "</div>\n" +
//                "</body>\n" +
//                "</html>");
//
//                writer.write(resultHtml.toString());
        List list = usersRepository.findAll();
        System.out.println(list.size());
        request.setAttribute("usersForJsp", usersRepository.findAll());
        HttpSession httpSession = request.getSession();
        System.out.println(httpSession.getAttribute("authenticated"));

        request.getRequestDispatcher("/jsp/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        usersRepository = (UsersRepository) config.getServletContext().getAttribute("usersRepository");
    }
}

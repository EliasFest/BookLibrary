package users;

import Library.LibraryService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "userServlet", value = "/users/*")
public class UserServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathInfo = request.getPathInfo();
        LibraryService libraryService = new LibraryService();
        if (pathInfo == null || pathInfo.equals("/users")) {
            response.setHeader("Access-Control-Allow-Origin", "*");
            PrintWriter writer = response.getWriter();

            String responseJson = new ObjectMapper().writeValueAsString(libraryService.showAllUsers());
            writer.write(responseJson);
        } else {
            System.out.println("Halloooo");
        }
    }
}
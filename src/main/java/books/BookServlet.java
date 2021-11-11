package books;

import Library.LibraryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import users.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "bookServlet", value = "/books/*")
public class BookServlet extends HttpServlet {
    LibraryService libraryService = new LibraryService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/books")) {
            response.setHeader("Access-Control-Allow-Origin","*");
            PrintWriter writer = response.getWriter();

            String responseJson = new ObjectMapper().writeValueAsString(libraryService.showAllBook());
            writer.write(responseJson);
        } else if (pathInfo.equals("/456")) {
            response.setHeader("Access-Control-Allow-Origin","*");
            PrintWriter writer2 = response.getWriter();

            String responseJson = new ObjectMapper().writeValueAsString(libraryService.showThatBook(456));
            writer2.write(responseJson);
        } else if (pathInfo.equals("/789")) {
            response.setHeader("Access-Control-Allow-Origin","*");
            PrintWriter writer2 = response.getWriter();

            String responseJson = new ObjectMapper().writeValueAsString(libraryService.showThatBook(789));
            writer2.write(responseJson);
        } else {
            System.out.println("Halloooo");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        String bodyAsJsonString = getBodyAsJsonString(request);

        Book book = new ObjectMapper().readValue(bodyAsJsonString, Book.class);
        User user = new ObjectMapper().readValue(bodyAsJsonString, User.class);
        libraryService.lendOut(book, user);
    }

    private String getBodyAsJsonString(HttpServletRequest request) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line.trim());
        }

        String jsonString = sb.toString();
        return jsonString;
    }

    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");
        response.setHeader("Allow", "GET, POST, DELETE, OPTIONS");
    }

}
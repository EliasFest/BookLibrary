package books;

import Library.LibraryService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "bookServlet", value = "/books/*")
public class BookServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathInfo = request.getPathInfo();
        LibraryService libraryService = new LibraryService();
        if (pathInfo == null || pathInfo.equals("/books"))
        {
            response.setHeader("Access-Control-Allow-Origin", "*");
            PrintWriter writer = response.getWriter();

            String responseJson = new ObjectMapper().writeValueAsString(libraryService.showAllBook());
            writer.write(responseJson);
        } else if (pathInfo.equals("/456")) {
            response.setHeader("Access-Control-Allow-Origin", "*");
            PrintWriter writer2 = response.getWriter();

            String responseJson = new ObjectMapper().writeValueAsString(libraryService.showThatBook(456));
            writer2.write(responseJson);
        } else if (pathInfo.equals("/789")) {
            response.setHeader("Access-Control-Allow-Origin", "*");
            PrintWriter writer2 = response.getWriter();

            String responseJson = new ObjectMapper().writeValueAsString(libraryService.showThatBook(789));
            writer2.write(responseJson);
        } else {
            System.out.println("Halloooo");
        }
    }
}
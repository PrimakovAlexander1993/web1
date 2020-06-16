package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();

        String val = request.getParameter("value");

        if (val.equals("")){
            writer.println(0);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }else {
            try{
                int valInt = Integer.parseInt(val);
                writer.println(valInt + valInt);
                response.setStatus(HttpServletResponse.SC_OK);
            }catch (NumberFormatException | NullPointerException e){
                writer.println(0);
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }

        }


       // response.setContentType("text/html;charset=utf-8");
       // response.setStatus(HttpServletResponse.SC_OK);

    }
}

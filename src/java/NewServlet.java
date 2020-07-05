/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.ResponseProcessingException;

/**
 *
 * @author Igor
 */
@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>O seu IMC é:</h1>");
            out.println("</body>");
            out.println("</html>");

            PrintWriter resposta = response.getWriter();

            String sexo, altura, peso;

            sexo = request.getParameter("Sexo");
            altura = request.getParameter("altura");
            peso = request.getParameter("peso");

            double Altura, Peso, IMC;
            Altura = Double.parseDouble(altura);
            Peso = Double.parseDouble(peso);
            IMC = Peso / (Altura * Altura);

            /*resposta.print("<html>" + sexo + "<p></html>");
            resposta.print("<html>" + IMC + "<p></html>");
            resposta.print("<html>" + Altura + "<p></html>");
            resposta.print("<html>" + Peso + "<p></html>");*/
            resposta.print("<html>");

            resposta.print("Seu IMC é = " + IMC + "<p>");
            resposta.print("Seu IMC é categorizado como ");

            if (IMC < 17) {
                resposta.print("Magreza Grave");
                resposta.print("<p><img src=\"animais.jpg\"width=\"200\" height=\"200\"/>");
            }
            if (IMC >= 17 && IMC < 18.5) {
                resposta.print("Magreza Moderada");
                resposta.print("<p><img src=\"animais.jpg\"width=\"200\" height=\"200\"/>");
            }
            if (IMC >= 18.5 && IMC < 25) {
                resposta.print("Normal");
                resposta.print("<p><img src=\"animais.jpg\"/>");
            }
            if (IMC >= 25 && IMC < 30) {
                resposta.print("Sobrepeso");
                resposta.print("<p><img src=\"pastos.jpg\"width=\"200\" height=\"200\"/>");
            }
            if (IMC >= 30 && IMC < 35) {
                resposta.print("Obsidade I");
                resposta.print("<p><img src=\"animais.jpg\"width=\"200\" height=\"200\"/>");
            }
            if (IMC >= 55 && IMC < 40) {
                resposta.print("Obesidade Severa");
                resposta.print("<p><img src=\"animais.jpg\"width=\"200\" height=\"200\"/>");
            }
            if (IMC > 40) {
                resposta.print("Obesidade Morbida");
                resposta.print("<p><img src=\"baixa.jpg\"width=\"200\" height=\"200\"/>");
            }

            resposta.print("</html>");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet_DAO;

import Classes_DAO.ContatoDAO;
import Exercico_DAO_01.Contato;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RafaelaEmília
 */
@WebServlet(name = "CriarContatoServlet", urlPatterns = {"/novo.html"})
public class CriarContatoServlet extends HttpServlet {

   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {request.getRequestDispatcher("WEB-INF/novo-contato.jsp").forward(request, response);
            
        
        
    }
       
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Contato novoContato = new Contato();
        novoContato.setNome(request.getParameter("nome"));
        novoContato.setSobrenome(request.getParameter("sobrenome"));
        novoContato.setTelefone(request.getParameter("telefone"));
        
        
        try {
            ContatoDAO dao = new ContatoDAO();
            dao.cria(novoContato);
        } catch (Exception ex) {
           request.setAttribute("mensagem", ex);
           request.getRequestDispatcher("WEB-INF/novo-contato.jsp").forward(request, response);
           return;
        }
        
        response.sendRedirect("contatos.html");
        
        
        
        
   
}
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moz.dev.group.tasks.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import moz.dev.group.tasks.services.interfaces.UserJpaService;


 
@WebServlet(name = "projectos.index", urlPatterns = {"/projectos"})
public class ProjectsIndexController extends HttpServlet 
{
    private final ObjectMapper mapper = new ObjectMapper();
    @Inject
    private UserJpaService users;
            
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        request.getRequestDispatcher("/views/module/projectos/index.jsp").forward(request, response);
    }

}

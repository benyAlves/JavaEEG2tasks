/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moz.dev.group.tasks.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import moz.dev.group.tasks.model.User;
import moz.dev.group.tasks.services.interfaces.TaskManagementService;
import moz.dev.group.tasks.services.interfaces.UserJpaService;
import util.PostRequest;

/**
 *
 * @author delfi
 */
@WebServlet(name = "tarefas.index", urlPatterns = {"/tarefas"})
public class TarefasIndexController extends HttpServlet 
{
    private final ObjectMapper mapper = new ObjectMapper();
    @Inject
    private TaskManagementService tasks;
    @Inject
    private UserJpaService users;
            
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        request.setAttribute("tasks", tasks.findAll(new User("Delfimarime")));
        request.getRequestDispatcher("/views/module/tarefas/pages/index.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException
    {
         // 1. get received JSON data from request
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if(br != null)
            json = br.readLine();

        PostRequest obj = mapper.readValue(json, PostRequest.class);

        this.handleUsers((String) obj.getValue(),resp);
    }

    private void handleUsers(String name , HttpServletResponse response) throws IOException 
    {
        final Set<User>data=new HashSet<>();
        if(name.isEmpty())
            data.addAll(this.users.findAll());
        else
            data.addAll(this.users.findByUsernameLike(name));
        
        mapper.writeValue(response.getOutputStream(), data);   
    }


}

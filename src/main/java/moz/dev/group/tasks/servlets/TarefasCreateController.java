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
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import moz.dev.group.tasks.model.Task;
import moz.dev.group.tasks.model.TaskState;
import moz.dev.group.tasks.model.User;
import moz.dev.group.tasks.services.interfaces.TaskManagementService;

/**
 *
 * @author delfi
 */
@WebServlet(name = "tarefas.create", urlPatterns = {"/tarefas/create"})
@Stateless
public class TarefasCreateController extends HttpServlet 
{
    private final ObjectMapper mapper = new ObjectMapper();
    
    @Inject
    private TaskManagementService tasks;
    @Resource
    private UserTransaction t;
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException
    {
        if("view".equalsIgnoreCase(request.getParameter("operation")))
        {
            long id=Long.parseLong(request.getParameter("id"));
            mapper.writeValue(resp.getOutputStream(), tasks.findOne(id,new User("Delfimarime"))); 
        }
        else
        {
            try
            {
                t.begin();
                TaskState state;
                
                User user=new User("Delfimarime");
                
                long id=Long.parseLong(request.getParameter("id"));
                switch(request.getParameter("operation"))
                {
                    case "start":    state=tasks.changeState(id,TaskState.EXECUTING,user);break;
                    case "finish":   state=tasks.changeState(id,TaskState.SUCESSFUL,user);break;
                    case "pause":    state=tasks.changeState(id,TaskState.WAIT,user)     ;break;
                    case "cancel":   state=tasks.changeState(id,TaskState.CANCELED,user);break;
                    default:            throw new UnsupportedOperationException(); 
                }
                t.commit();
                mapper.writeValue(resp.getOutputStream(),state); 
                
            }
            catch(Exception e)
            {
                    try 
                   {
                           t.rollback();   
                   } catch (IllegalStateException|SecurityException|SystemException ex) {
                       Logger.getLogger(TarefasCreateController.class.getName()).log(Level.SEVERE, null, ex);
                   }
                    e.printStackTrace();
                    throw new UnsupportedOperationException();
            }
        }
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException
    {
    
         // 1. get received JSON data from request
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if(br != null)
            json = br.readLine();

        Task task = mapper.readValue(json, Task.class);
        task.setState(TaskState.NOT_STARTED);
        task.setInstant(LocalDateTime.now());
        
        //TODO fetch User
        task.setDelegator(new User("Delfimarime"));
        
        try 
        {
            t.begin();
            tasks.save(task);
            t.commit();
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(TarefasCreateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print(task);
    }


}

package controllers;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.TaskDAO;
import models.TaskModel;
import models.UserDAO;
import models.UserModel;

@WebServlet(urlPatterns = {"/Controller", "/tasks", "/insertUser", "/insertTask", "/deleteTask", "/updateTask", "/index"} )
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TaskDAO taskDAO = new TaskDAO();
	UserDAO userDAO = new UserDAO();
	TaskModel task = new TaskModel();
	UserModel user = new UserModel();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if(action.equals("/tasks")) {
			tasks(request, response);
		}
		else if(action.equals("/insertUser")) {
			newUser(request, response);
		}
		else if(action.equals("/insertTask")) {
			newTask(request, response);
		}
		else if(action.equals("/updateTask")) {
			updateTask(request, response);
		}
		else if(action.equals("/deleteTask")) {
			deleteTask(request, response);
		}
		else {
			response.sendRedirect("/index.html");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if(action.equals("/insertTask")) {
			newTask(request, response);
		}
		else if(action.equals("/insertUser" )) {
			newUser(request, response);
		}
	}
	
	protected void tasks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<TaskModel> taskList = taskDAO.listTasks();
		
		request.setAttribute("tasks", taskList);
		RequestDispatcher  rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
		
		for(int i=0; i< taskList.size(); i++){
			System.out.println(taskList.get(i).getDescription());
		}
		
	}
	
	protected void newUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(userDAO.checkEmail(request.getParameter("email"))) {			
			response.sendRedirect("register.jsp");
			return;
		}
		
		userDAO.insertUser(new UserModel(request.getParameter("email"), request.getParameter("password")));
		
		response.sendRedirect("");
	}
	
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel user = userDAO.Login(request.getParameter("email"), request.getParameter("password"));
		if(user != null) {
			response.sendRedirect("tasks");
		}
		else {
			response.sendRedirect("");
		}
	}
	
	
	protected void deleteTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		taskDAO.deleteTask(request.getParameter("id"));
		response.sendRedirect("tasks");
	}
	
	protected void updateTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		taskDAO.updateTask(request.getParameter("id"));
		response.sendRedirect("tasks");
	}
	
	protected void newTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		task.setDescription(request.getParameter("description"));
		task.setUser_id("1");
		if(request.getParameter("completed") != null) {
			task.setCompleted(true);
		}
		else {
			task.setCompleted(false);
		}
		
		//task.setCompleted(request.getParameter("completed"));
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			task.setCreated_at(formato.parse(request.getParameter("created_at")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("this right here: " + e);
		}
		
		//chamando TaskDAO para criar o objeto no banco

		taskDAO.insertTask(task);
		
		tasks(request, response);
	}
	
}

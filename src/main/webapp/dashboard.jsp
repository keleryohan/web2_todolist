<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ page import="models.TaskModel" %>
<%@ page import="java.util.ArrayList" %>
<%
ArrayList<TaskModel> taskList = (ArrayList<TaskModel>) request.getAttribute("tasks");
%>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>My tasks</title>

    <style>
      .card {
        border: none;
      }
    </style>
  </head>
  <body>
    <div class="container">
	    <div class="row d-flex justify-content-between">
	      	
    	</div>
    	
      <div class="row">
        <div class="col mt-4">
          <div class="p-5 mb-4 bg-light rounded-3">
            <div class="container-fluid py-5">
              <h1 class="display-5 fw-bold">My tasks</h1>
              <p class="col-md-8 fs-4">
                Visualize e gerencie seus afazeres do dia a dia.
              </p>
              <a href="index.html" class="btn btn-dark" type="button">Sair</a>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col">
          <div class="card bg-light">
            <div class="card-body">
              <div class="row mb-2">
                <div class="col d-flex justify-content-between">
                  <h4 class="card-title">Pendentes</h5>
                  <button class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@getbootstrap" type="button">+</button>
                </div>
              </div>

              <ul class="list-group list-group-flush">
              <%for(int i=0; i< taskList.size(); i++){  
            	  if(!taskList.get(i).isCompleted() ){
              %>
              	<li href="#" class="list-group-item list-group-item-action d-flex align-items-center">
                  	<%=taskList.get(i).getDescription() %>
                  	
               	<a href="deleteTask?id=<%out.print(taskList.get(i).getId()); %>"  style="margin-left: auto">
             		<img width="20px" height="20px" src="images/sign-delete-icon.png">
             	</a>
             	<a href="updateTask?id=<%out.print(taskList.get(i).getId()); %>" >
             		<img width="20px" height="20px" src="images/inspection-131964752898110361.png">
             	</a>
                  <span class="badge bg-info rounded-pill"> <% taskList.get(i).getCreated_at(); %> </span>
                </li>
              <% }} %>
                
              </ul>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card bg-light">
            <div class="card-body">
              <h4 class="card-title">Concluídas</h5>

              <ul class="list-group list-group-flush">
              <%for(int i=0; i< taskList.size(); i++){  
              	if(taskList.get(i).isCompleted() ){
              %>
              	<li href="#" class="list-group-item list-group-item-action d-flex align-items-center">
                  	<%=taskList.get(i).getDescription() %>
                  	
               	<a href="deleteTask?id=<%out.print(taskList.get(i).getId()); %>"  style="margin-left: auto">
             		<img width="20px" height="20px" src="images/sign-delete-icon.png">
             	</a>
                  <span class="badge bg-info rounded-pill"> <% taskList.get(i).getCreated_at(); %> </span>
                </li>
              <% }} %>
                
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Nova Tarefa</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form name="formNewTask" action="insertTask" method="post">
              <div class="mb-3">
                <label for="recipient-name" class="col-form-label"  >Descrição:</label>
                <input type="text" class="form-control" id="recipient-name" name="description">
              </div>
              <div class="mb-3">
                <label for="message-text" class="col-form-label">Data de entrega:</label>
                <input type="date" class="form-control" name="created_at" id="recipient-name">
              </div>
              <div class="form-check mb-3">
                <input class="form-check-input" type="checkbox" name="completed" id="flexCheckDefault">
                <label class="form-check-label" for="flexCheckDefault">
                  Concluído
                </label>
              </div>
              <div class="modal-footer">
	            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
	            <button type="submit" class="btn btn-primary" >Salvar</button>
	          </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script> -->

    <!-- Option 2: Separate Popper and Bootstrap JS -->    
    <!-- <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script> -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
  </body>
</html>
<%-- 
    Document   : index
    Created on : Jul 27, 2016, 7:16:47 PM
    Author     : delfi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  uri ="/taglibs/customized/java8/TemporalAcessor.tld" prefix ="javatime" %>
<%@ taglib  uri ="/taglibs/customized/java8/TemporalDuration.tld" prefix ="duration" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Gestor de Tarefas</title>
        <!-- Bootstrap -->
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/assets/css/template.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/assets/lib/Datatables 1.10.12/media/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
        <link href="assets/lib/Datatables 1.10.12/extensions/Responsive/css/responsive.bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/assets/lib/parsley/parsley.css" rel="stylesheet" type="text/css">
    </head>
    <body>

                <nav class="navbar navbar-default">
                  <div class="container-fluid"> 
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#defaultNavbar1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                      <a class="navbar-brand" href="#">Brand</a></div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="defaultNavbar1">
                      <ul class="nav navbar-nav">
                        <li class="active"><a href="${pageContext.request.contextPath}/tarefas"><span class="glyphicon glyphicon-list-alt"></span> Tarefas<span class="sr-only">(current)</span></a></li>
                        <li><a href="${pageContext.request.contextPath}/projectos"><span class="glyphicon glyphicon-book"></span>Projectos</a></li>

                      </ul>

                <ul class="nav navbar-nav navbar-right">
                        <li></li>
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"> </span> Usuario<span class="caret"></span></a>
                          <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Configuracoes</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                          </ul>
                        </li>
                      </ul>
                    </div>
                    <!-- /.navbar-collapse --> 
                  </div>
                  <!-- /.container-fluid --> 
                </nav>

                <div class="container-fluid" id="main-container">
                                <div class="row">


                    <div  id="location" class="panel panel-default" >

                        <div class="panel-body">
                        <span class="pull-left">
                        <a href="javascript:void(0)"> Tarefas</a> > <a href="javascript:void(0)"> Index</a>
                        </span>
                        <span class="pull-right">
                                <!-- SEARCH SPACE -->
                        </span>

                        </div>

                    </div>
                   
                        <div class="panel panel-default">
                                <div class="well">Gestao de Tarefas <span class="pull-right"><button class="btn btn-info" id="btn_modal">Criar</button></span></div>
                                <div class="panel-body">


                                <table id="tbl_tarefas" class="table-bordered dt-responsive" width="100%" border="1">
                                         <thead>
                                                <tr>
                                              <th scope="col" width="10%">Codigo</th>
                                              <th scope="col" width="30%">Titulo</th>
                                              <th scope="col" width="15.5%">Hora Inicio</th>
                                              <th scope="col" width="5%">Duracao</th>
                                              <th scope="col" width="15.5%">Hora Terminio</th>
                                              <th scope="col" width="10%">Estado</th>
                                              <th scope="col" width="10%">Accoes</th>
                                            </tr>
                                     </thead>
                                      <tbody>
                                          <c:forEach var="each" items="${tasks}">
                                            <tr>
                                              <td scope="col" >${each.id}</td>
                                              <td scope="col" >${each.name}</td>
                                              <td scope="col" ><javatime:parse value="${each.possibleStart}" pattern="dd/MM/yyyy hh:mm" /></td>
                                              <td scope="col" ><duration:parse begin="${each.possibleStart}"  end="${each.possibleEnd}" /></td>
                                              <td scope="col" ><javatime:parse value="${each.possibleEnd}" pattern="dd/MM/yyyy hh:mm" /></td>
                                              <td scope="col" data-state="${each.id}">
                                                  <c:choose>
                                                      <c:when test="${each.state eq 'NOT_STARTED'}">Por iniciar</c:when>
                                                      <c:when test="${each.state eq 'EXECUTING'}"> Em Execucao</c:when>
                                                      <c:when test="${each.state eq 'WAIT'}">Em Espera</c:when>
                                                      <c:when test="${each.state eq 'CANCELED'}">Cancelada</c:when>
                                                      <c:when test="${each.state eq 'SUCESSFUL'}">Finalizada</c:when>
                                                      <c:otherwise>N/A</c:otherwise>
                                                  </c:choose>
                                                  
                                              </td>
                                              <td scope="col" >
                                                      <a data-id="${each.id}" class="${((each.state eq 'NOT_STARTED') || (each.state eq 'WAIT')) ? '' :'hidden'}" href="javascript:void(0)" data-toggle="tooltip" data-placement="bottom" title="start"><span class="glyphicon glyphicon-play"></span></a>
                                                      <a data-id="${each.id}"  class="${each.state eq 'EXECUTING' ? '':'hidden'}" href="javascript:void(0)" data-toggle="tooltip" data-placement="bottom" title="pause"><span class="glyphicon glyphicon-pause"></span></a>
                                                      <a href="javascript:void(0)" data-id="${each.id}" data-toggle="tooltip" data-placement="bottom" title="View"><span class="glyphicon glyphicon-info-sign"></span></a>
                                                      <a href="javascript:void(0)" class="${((each.state eq 'EXECUTING') || (each.state eq 'WAIT')) ? '' :'hidden'}" data-id="${each.id}"  data-group="${each.id}" data-toggle="tooltip" data-placement="bottom" title="finish"><span class="glyphicon glyphicon-ok"></span></a>
                                                    <a href="javascript:void(0)" class="${((each.state eq 'EXECUTING') || (each.state eq 'WAIT')) ? '' :'hidden'}" data-id="${each.id}" data-group="${each.id}"  data-toggle="tooltip" data-placement="bottom" title="cancel"><span class="glyphicon glyphicon-remove"></span></a>
                                              </td>
                                            </tr>  
                                          </c:forEach>
                                      
                                      </tbody>
                                                </table>

                                </div>
                        </div>

                        </div>
                    
                    
              
                    
                    
               </div>

                <footer class="footer">
                      <div class="container">
                        <p class="text-muted">RaitonBL</p>
                      </div>
                </footer>

            <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Criar Tarefa</h4>
        </div>
        <div class="modal-body">
                <%@include file="../forms/tarefa.jsp"%>
        </div>
        <div class="modal-footer">
            <button type="button" id="btn_submit"  class="btn btn-success">Criar</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
        </div>
      </div>
      
    </div>
  </div>
  
        
        
        
        
         <!-- Modal -->
  <div class="modal fade" id="check" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
            <div class="col-md-12">
                <span class="pull-left text-muted"><strong>Codigo:</strong><span id="view_id" class=" text-muted">Codigo</span></span><button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <%@include file="../pieces/view.jsp"%>
        </div>
      </div>
      
    </div>
  </div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 

<script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/lib/Datatables 1.10.12/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/lib/Datatables 1.10.12/extensions/Responsive/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/lib/moment/moment.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/lib/bootstrap-datetimepicker-master/build/js/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/lib/parsley/parsley.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/lib/parsley/i18n/pt-pt"></script>
<script src="${pageContext.request.contextPath}/assets/lib/select2-4.0.3/dist/js/select2.full.min.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed --> 

<script src="${pageContext.request.contextPath}/assets/lib/animatedModal.js-master/animatedModal.min.js"></script>
<script src="${pageContext.request.contextPath}/views/module/tarefas/scripts/index.js"></script>
<script> var ctx="${pageContext.request.contextPath}";</script>


<script>
    
    
    
    
</script>

    </body>
</html>

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
        <link href="${pageContext.request.contextPath}/assets/lib/Datatables 1.10.12/extensions/Responsive/css/responsive.bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/assets/lib/parsley/parsley.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/assets/lib/animatedModal.js-master/demo/css/animate.min.css" rel="stylesheet" type="text/css">
         <link href="${pageContext.request.contextPath}/assets/lib/animatedModal.js-master/demo/css/normalize.min.css" rel="stylesheet" type="text/css">
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
                        <li ><a href="${pageContext.request.contextPath}/tarefas"><span class="glyphicon glyphicon-list-alt"></span> Tarefas<span class="sr-only">(current)</span></a></li>
                        <li class="active"><a href="${pageContext.request.contextPath}/projectos"><span class="glyphicon glyphicon-book"></span>Projectos</a></li>

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
                        <a href="javascript:void(0)"> Projectos</a> > <a href="javascript:void(0)"> Index</a>
                        </span>
                        <span class="pull-right">
                                <!-- SEARCH SPACE -->
                        </span>

                        </div>

                    </div>
                   
                        <div class="panel panel-default">
                            <div class="well">Gestao de Projectos <span class="pull-right"><a href="${pageContext.request.contextPath}/projectos/create" class="btn btn-info">Criar</a></span></div>
                                <div class="panel-body">


                                <table id="tbl_tarefas" class="table-bordered dt-responsive" width="100%" border="1">
                                         <thead>
                                                <tr>
                                              <th scope="col" width="10%">Codigo</th>
                                              <th scope="col" width="30%">Titulo</th>
                                              <th scope="col" width="15.5%">Hora Inicio</th>
                                              <th scope="col" width="5%">Duracao</th>
                                              <th scope="col" width="15.5%">Hora Terminio</th>
                                              <th scope="col" width="10%">Responsavel</th>
                                            </tr>
                                     </thead>
                                      <tbody>
                                          <c:forEach var="each" items="${projects}">
                                            <tr>
                                              <td scope="col" >${each.id}</td>
                                              <td scope="col" >${each.name}</td>
                                              <td scope="col" ><javatime:parse value="${each.start}" pattern="dd/MM/yyyy hh:mm" /></td>
                                              <td scope="col" ><duration:parse begin="${each.start}"  end="${each.end}" /></td>
                                              <td scope="col" ><javatime:parse value="${each.end}" pattern="dd/MM/yyyy hh:mm" /></td>
                                              <td scope="col" >
                                                  ${each.inCharge.name}
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
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title" id="lbl_titulo"> <span id="lbl_other"></span></h4>
        </div>
        <div class="modal-body">
               
        </div>
      </div>
      
    </div>
  </div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 

<script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/assets/lib/moment/moment.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/lib/bootstrap-datetimepicker-master/build/js/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/lib/parsley/parsley.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/lib/parsley/i18n/pt-pt"></script>
<script src="${pageContext.request.contextPath}/assets/lib/select2-4.0.3/dist/js/select2.full.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed --> 
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/lib/Datatables 1.10.12/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/lib/Datatables 1.10.12/extensions/Responsive/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/lib/animatedModal.js-master/animatedModal.min.js"></script>
<script> var ctx="${pageContext.request.contextPath}";</script>

<script>

	        $("#tbl_tarefas").DataTable
			({
		    			"rowReorder": true,  			
		    			"colReorder": true,
		    			"ordering": true,
		    			"language": 
		    			{
		    			            "lengthMenu": "Mostrar _MENU_ registos por pagina",
		    			            "zeroRecords": "N&atilde;o foram encontrados resultados",
		    			            "info": "Mostrando de _PAGE_ at&eacute; _MAX_ registos",
		    			            "infoEmpty": "Mostrando de 0 até 0  registos",
		    			            "infoFiltered": "(Filtrado apartir _MAX_ registos)",
		    			            "search": "",
		    			            "oPaginate": 
		    			            {
		                                "sFirst":    "Primeiro",
		                                "sPrevious": "Anterior",
		                                "sNext":     "Seguinte",
		                                "sLast":     "&Uacuteltimo"
		                            }
		    			}
		    		});
</script>

<script>
$("#btn_submit").click(function()
{
    $("#task_form").parsley().validate();
    if($("#task_form").parsley().isValid())
    {
        var obj={'name':$("#name").val(),'description':$("#description").val(),'delegated':{'username':$("#delegated").val()},
        'possibleStart':$("#possibleStart").val(),'possibleEnd':$("#possibleEnd").val()};
        sendData(obj);
    }
});

$("#btn_modal").click(function()
{
    $("#pls").html("");
    $("#task_form").trigger('reset');
    $("#myModal").modal({backdrop: 'static',keyboard: false}) ;
});

$("a[title='View']").click(function()
{
  doGetSubmit($(this).data("id"),'view');
});
</script>

<script>
 
 function doGetSubmit(id,operation)
    {
        $.ajax(
               {
                       type: 'get',
                       data: {'id':id,'operation':operation},
                       url:ctx+"/tarefas/create",
                        dataType : 'json',
                       beforeSend:function(xhr)
                       {
                          // xhr.setRequestHeader(header, token);
                       },
                       success: function (response) 
                       {
                           fillTask(response);
                       },
                       error: function (xhr,ajaxOptions,thrownException) 
                       {
                           alert(xhr.responseText);

                       }
               }
           );     
    }
</script>


<script>
 
    function sendData(data)
    {
        $.ajax(
               {
                       type: 'post',
                       contentType : 'application/json; charset=utf-8',
                       dataType : 'json',
                       url: ctx+"/tarefas/create",
                       data: JSON.stringify(data),
                       mimeType: 'application/json',
                       beforeSend:function(xhr)
                       {
                          // xhr.setRequestHeader(header, token);
                       },
                       success: function (response) 
                       {
                           alert("done");
                       },
                       error: function (xhr,ajaxOptions,thrownException) 
                       {
                           alert(xhr.responseText);

                       }
               }
           );    
    }
    
</script>

<script>
function fillTask(data)
{
   // $("#lbl_titulo").html();
    var other=data['name']+" por "+data['delegator']['name']+" a "+data['instant'];
    $("#lbl_titulo").html(other);
    
    if(!data['description'] || 0 === data['description'].length)
        $("#lbl_detalhes").html("Sem detalhes");
    else    
        $("#lbl_detalhes").html(data['description']);
    
    
    
    $("#lbl_encarregado").html(data['delegated']['name']+"("+data['delegated']['username']+")");
    $("#lbl_fim_esperado").html(data['possibleEnd']);
    $("#lbl_inicio_esperado").html(data['possibleStart']);
    
    $("#lbl_inicio_real").html(data['end']);
    
    if(!data['end'] || 0 === data['end'].length)
        $("#lbl_fim_real").html("N/A");
    else    
        $("#lbl_fim_real").html(data['end']);
    
    
    if(!data['start'] || 0 === data['start'].length)
        $("#lbl_inicio_real").html("N/A");
    else    
        $("#lbl_inicio_real").html(data['start']);
    
    
    if(data['state']==='NOT_STARTED')
        $("#lbl_estado").html("Nao iniciado");
    else if(data['state']==='EXECUTING')
        $("#lbl_estado").html("Em execucao");
     else if(data['state']==='WAIT')
        $("#lbl_estado").html("Em espera");
     else if(data['state']==='CANCELED')
        $("#lbl_estado").html("Cancelada");
     else if(data['state']==='SUCESSFUL')
        $("#lbl_estado").html("Finalizada");
     else 
        $("#lbl_estado").html("Indefinido!");
    
    
    
     $("#check").modal({backdrop: 'static',keyboard: false}) ;
}    
    
</script>

<script>
$("a[title='start']").click(function()
{
       var f=function(data,id)
        {
             changeState(data,id);
        };
        call($(this).data("id"),"start",f);
  
});    
    
    $("a[title='pause']").click(function()
    {
        var f=function(data,id)
        {
               changeState(data,id);
        };
        call($(this).data("id"),"pause",f);
    });
   
    $("a[title='finish']").click(function()
    {
         var f=function(data,id)
        {
               changeState(data,id);
        };
        call($(this).data("id"),"finish",f);
     
    });
   
    $("a[title='cancel']").click(function()
    {
        var f=function(data,id)
        {
                  changeState(data,id);
        };
        call($(this).data("id"),"cancel",f);
     
    });
    
    
    function call(id,operation,onSucess)
    {
         $.ajax(
               {
                       'type': 'get',
                       'data': {'id':id,'operation':operation},
                       'url':ctx+"/tarefas/create",
                       'dataType' : 'json',
                       'beforeSend':function(xhr)
                       {
                          // xhr.setRequestHeader(header, token);
                       },
                       'success': function (info) 
                       {
                           onSucess(info,id);
                       },
                       'error': function (xhr,ajaxOptions,thrownException) 
                       {
                           alert(xhr.responseText);
                       }
               }
           );  
    }
   
   
   function changeState(value,id)
   {
       if('EXECUTING'===value)
       {
            $("td[data-state="+id+"]").html("Em Execucao");
            $("a[title='start'][data-id="+id+"]").addClass('hidden');
            $("a[title='pause'][data-id="+id+"]").removeClass('hidden');
            $("a[data-group="+id+"][data-id="+id+"]").removeClass('hidden');
       }
       else   if('WAIT'===value)
       {
             $("td[data-state="+id+"]").html("Em Espera");
             $("a[title='pause'][data-id="+id+"]").addClass('hidden');
             $("a[title='start'][data-id="+id+"]").removeClass('hidden');
             $("a[data-group="+id+"][data-id="+id+"]").removeClass('hidden');
       }
       else   if('CANCELED'===value)
       {
             $("td[data-state="+id+"]").html("Cancelada");
             $("a[data-group="+id+"][data-id="+id+"]").addClass('hidden');
             $("a[title='start'][data-id="+id+"]").addClass('hidden');
            $("a[title='pause'][data-id="+id+"]").addClass('hidden');
       }
       else   if('SUCESSFUL'===value)
       {
             $("td[data-state="+id+"]").html("Finalizada");
             $("a[data-group="+id+"][data-id="+id+"]").addClass('hidden');
                 $("a[title='start'][data-id="+id+"]").addClass('hidden');
            $("a[title='pause'][data-id="+id+"]").addClass('hidden');
       }
   }
   
</script>

    </body>
</html>

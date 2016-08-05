<%-- 
    Document   : tarefa
    Created on : Jul 29, 2016, 3:51:34 AM
    Author     : delfi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Special version of Bootstrap that only affects content wrapped in .bootstrap-iso -->
<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" /> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/lib/vitalets-bootstrap-datepicker-c7af15b/css/datepicker.css" /> 
<!--Font Awesome (added because you use icons in your prepend/append)-->
<link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/lib/bootstrap-datetimepicker-master/build/bootstrap-datetimepicker.min.css" />
<link href="${pageContext.request.contextPath}/assets/lib/select2-4.0.3/dist/css/select2.min.css" rel="stylesheet" type="text/css">
<!-- Inline CSS based on choices in "Settings" tab -->
<style>.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p, .bootstrap-iso form{font-family: Arial, Helvetica, sans-serif; color: black}.bootstrap-iso form button, .bootstrap-iso form button:hover{color: #ffffff !important;} .asteriskField{color: red;}</style>

<div class="bootstrap-iso">
 <div class="container-fluid">
  <div class="row">
   <div class="">
       <form action="/tarefas" method="post" autocomplete="false" id="task_form">
     <div class="form-group ">
      <label class="control-label requiredField" for="name">
       Titulo
       <span class="asteriskField">
        *
       </span>
      </label>
         <input class="form-control" id="name" required="" data-parsley-error-message="Titulo e' Campo obrigatorio" name="name" placeholder="Titulo" type="text" data-parsley-errors-container="#pls"/>
     </div>
     <div class="form-group ">
      <label class="control-label " for="description">
       Detalhes
      </label>
      <textarea class="form-control" cols="40" id="description" name="description" placeholder="Detalhes" rows="10" data-parsley-errors-container="#pls"></textarea>
     </div>
     <div class="form-group ">
      <label class="control-label requiredField" for="delegated">
       Encarregado
       <span class="asteriskField">
        *
       </span>
      </label>
         <select class="select form-control"  id="delegated" data-parsley-error-message="Selecione o Encaregado da Tarefa" required="" name="delegated" data-parsley-errors-container="#pls">
       <option value="">
           Selecione
       </option>
      </select>
     </div>
     <div class="form-group ">
      <label class="control-label requiredField" for="possibleBegin">
       Inicio
       <span class="asteriskField">
        *
       </span>
      </label>
      <div class="input-group date" id='inicio'>
          <input type='text' class="form-control" required="" data-parsley-error-message="Indique o inicio da tarefa" id='possibleStart' name="possibleStart" data-parsley-errors-container="#pls" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
      </div>
     </div>
     <div class="form-group ">
      <label class="control-label requiredField" for="possibleEnd">
       Fim
       <span class="asteriskField">
        *
       </span>
      </label>
         <div class="input-group date" id="fim">
             <input type='text' class="form-control" data-parsley-error-message="Indique o fim da tarefa"  id='possibleEnd'  name="possibleEnd" required="" data-parsley-errors-container="#pls" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
      </div>
     </div>
     <div class="form-group">
     </div>
           
           <div id="pls">
               
           </div>
           
    </form>
   </div>
  </div>
 </div>
</div>

<script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/assets/lib/moment/moment.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/lib/bootstrap-datetimepicker-master/build/js/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/lib/parsley/parsley.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/lib/parsley/i18n/pt-pt"></script>
<script src="${pageContext.request.contextPath}/assets/lib/select2-4.0.3/dist/js/select2.full.min.js"></script>
<script>
var context="${pageContext.request.contextPath}";
$(function () 
{
    $('#inicio').datetimepicker
    ({
        locale: 'pt'
    });

    $('#fim').datetimepicker
    ({
        locale: 'pt'
    });

    $('#delegated').select2
    (
      {
        minimumInputLength: 2,  
        width: '100%',
          ajax: 
         {
            url:context+"/tarefas",
            data:function(data)
            {
                var query={'operation':'users','value':data.term};
                return JSON.stringify(query);
            },
            type:"POST",
            error:function(xhr,p,a)
            {
                alert("Ocorreu algum erro!");
            },
            contentType: 'application/json; charset=utf-8',
             mimeType: 'application/json',
             dataType: 'json',
             processResults: function (data) {
            return {
                results: $.map(data, function (item) {
                    return {
                        text: item.name+"("+item.username+")",
                        id: item.username
                    }
                })
            };
        }
         }
          
        }); 
});

</script>
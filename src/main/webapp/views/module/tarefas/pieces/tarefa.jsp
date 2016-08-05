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
    <div class="form-group ">
      <label class="control-label requiredField" for="possibleEnd">
       Descricao
      </label>
        <div class="input-group">
             <span id="lbl_detalhes"></span>
        </div>
     </div>
 <div class="form-group ">
      <label class="control-label requiredField" for="possibleEnd">
       Encarregado
      </label>
        <div class="input-group">
             <span id="lbl_encarregado"></span>
        </div>
     </div>
     <div class="form-group ">
      <label class="control-label requiredField" for="possibleBegin">
       Inicio(Esperado)
      </label>
      <div class="input-group">
          <span id="lbl_inicio_esperado"></span>
      </div>
     </div>
     <div class="form-group ">
      <label class="control-label requiredField" for="possibleEnd">
       Fim(Esperado)
      </label>
         <div class="input-group">
             <span id="lbl_fim_esperado"></span>
      </div>
     </div>
       
        <div class="form-group ">
      <label class="control-label requiredField" for="possibleBegin">
       Inicio(Real)
      </label>
      <div class="input-group">
          <span id="lbl_inicio_real"></span>
      </div>
     </div>
     <div class="form-group ">
      <label class="control-label requiredField" for="possibleEnd">
       Fim(Real)
      </label>
         <div class="input-group">
             <span id="lbl_fim_real"></span>
      </div>
     </div>
       
     <div class="form-group ">
      <label class="control-label requiredField" for="possibleEnd">
       Estado
      </label>
        <div class="input-group">
             <span id="lbl_estado"></span>
        </div>
     </div>
  
           

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

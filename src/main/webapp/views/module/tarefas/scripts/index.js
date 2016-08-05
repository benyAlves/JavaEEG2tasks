
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
                           alert("Com Sucesso!");
                       },
                       error: function (xhr,ajaxOptions,thrownException) 
                       {
                           alert(xhr.responseText);

                       }
               }
           );    
    }
    

function fillTask(data)
{
   // $("#lbl_titulo").html();
    //var other=data['name']+" por "+data['delegator']['name']+" a "+data['instant'];
    var other=data['name'];
    $("#view_titulo").html(other);
     $("#view_id").html(data['id']);
    
    if(!data['description'] || 0 === data['description'].length)
        $("#view_description").html("Sem detalhes");
    else    
        $("#view_description").html(data['description']);
    
    
    
    $("#view_delegated").html(data['delegated']['name']+"("+data['delegated']['username']+")");
    $("#view_delegator").html(data['delegator']['name']+"("+data['delegator']['username']+")");
    $("#view_possibleEnd").html(data['possibleEnd']);
    $("#view_possibleStart").html(data['possibleStart']);
    
    //$("#view_end").html(data['end']);
    
    if(!data['end'] || 0 === data['end'].length)
        $("#view_end").html("N/A");
    else    
        $("#view_end").html(data['end']);
    
    
    if(!data['start'] || 0 === data['start'].length)
        $("#view_start").html("N/A");
    else    
        $("#view_start").html(data['start']);
    
    
    if(data['state']==='NOT_STARTED')
        $("#view_state").html("Nao iniciado");
    else if(data['state']==='EXECUTING')
        $("#view_state").html("Em execucao");
     else if(data['state']==='WAIT')
        $("#view_state").html("Em espera");
     else if(data['state']==='CANCELED')
        $("#view_state").html("Cancelada");
     else if(data['state']==='SUCESSFUL')
        $("#view_state").html("Finalizada");
     else 
        $("#view_state").html("Indefinido!");
    
    
    
     $("#check").modal({backdrop: 'static',keyboard: false}) ;
}    
    

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
   
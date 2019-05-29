(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            method: 'GET',
            url: '/Zoo/api/show',
            dataType: 'json',
            contentType: 'application/json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {
                var tableRow = $('<tr>');
                // División de la fila
                var animal= $('<td>');
                animal.text(data[i].animal);
                var horario= $('<td>');
                horario.text(data[i].horario);
                var lugar= $('<td>');
                lugar.text(data[i].lugar);
                var encargado= $('<td>');
                encargado.text(data[i].encargado);
                var evaluacion= $('<td>');
                evaluacion.text(data[i].evaluacion);
                var nombre= $('<td>');
                nombre.text(data[i].nombre);
                

                var acciones = $('<td>');
                var botonEliminar = $('<button>').addClass('btn btn-danger');
                botonEliminar.text('Eliminar').attr('data-id',data[i].id);
                botonEliminar.click(eliminar);
                var botonActualizar = $('<a href="/zoo/crearShow.html?id='+ data[i].id+'">').addClass('btn btn-primary');
                botonActualizar.text('Actualizar');

                acciones.append(botonEliminar);
                acciones.append(botonActualizar);

                tableRow.append(animal);
                tableRow.append(horario);
                tableRow.append(lugar);
                tableRow.append(encargado);
                tableRow.append(evaluacion);
                tableRow.append(nombre);
                tableRow.append(acciones);

                $('#tableShow table tbody').append(tableRow);
            }
            console.log(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });
    
    function eliminar(event){
        $.ajax({
            method: 'DELETE',
            url:'/Zoo/api/show/'+$(this).attr('data-id'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function(data){
            console.log("Elemento eliminado");
            window.location.reload();
        }).fail(function(xhr, status, error){
            console.log(error);
        });
    }
})(jQuery);
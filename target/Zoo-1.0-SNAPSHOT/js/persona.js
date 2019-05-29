(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            method: 'GET',
            url: '/Zoo/api/persona',
            dataType: 'json',
            contentType: 'application/json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {
                var tableRow = $('<tr>');
                // División de la fila
                var cargo= $('<td>');
                cargo.text(data[i].cargo);
                var tipoDocumento= $('<td>');
                tipoDocumento.text(data[i].tipoDocumento);
                var nombre= $('<td>');
                nombre.text(data[i].nombre);
                var fechaNacimiento= $('<td>');
                fechaNacimiento.text(data[i].fechaNacimiento);
                var telefono= $('<td>');
                telefono.text(data[i].telefono);
                

                var acciones = $('<td>');
                var botonEliminar = $('<button>').addClass('btn btn-danger');
                botonEliminar.text('Eliminar').attr('data-id',data[i].id);
                botonEliminar.click(eliminar);
                var botonActualizar = $('<a href="/zoo/crearPersona.html?id='+ data[i].id+'">').addClass('btn btn-primary');
                botonActualizar.text('Actualizar');

                acciones.append(botonEliminar);
                acciones.append(botonActualizar);

                tableRow.append(cargo);
                tableRow.append(tipoDocumento);
                tableRow.append(nombre);
                tableRow.append(fechaNacimiento);
                tableRow.append(telefono);
                tableRow.append(acciones);

                $('#tablePersona table tbody').append(tableRow);
            }
            console.log(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });
    
    function eliminar(event){
        $.ajax({
            method: 'DELETE',
            url:'/Zoo/api/persona/'+$(this).attr('data-id'),
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
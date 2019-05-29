(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            method: 'GET',
            url: '/Zoo/api/animal',
            dataType: 'json',
            contentType: 'application/json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {
                var tableRow = $('<tr>');
                // División de la fila
                var evaluacion= $('<td>');
                evaluacion.text(data[i].evaluacion);
                var cuidador= $('<td>');
                cuidador.text(data[i].cuidador);
                var tipoAnimal= $('<td>');
                tipoAnimal.text(data[i].tipoAnimal);
                var nombreAnimal= $('<td>');
                nombreAnimal.text(data[i].nombreAnimal);
                var nombreCientifico= $('<td>');
                nombreCientifico.text(data[i].nombreCientifico);
                var descripcion= $('<td>');
                descripcion.text(data[i].descripcion);
                var especie= $('<td>');
                especie.text(data[i].especie);
                
                var acciones = $('<td>');
                var botonEliminar = $('<button>').addClass('btn btn-danger');
                botonEliminar.text('Eliminar').attr('data-id',data[i].id);
                botonEliminar.click(eliminar);
                var botonActualizar = $('<a href="/zoo/crearAnimal.html?id='+ data[i].id+'">').addClass('btn btn-primary');
                botonActualizar.text('Actualizar');

                acciones.append(botonEliminar);
                acciones.append(botonActualizar);

                tableRow.append(evaluacion);
                tableRow.append(cuidador);
                tableRow.append(tipoAnimal);
                tableRow.append(nombreAnimal);
                tableRow.append(nombreCientifico);
                tableRow.append(descripcion);
                tableRow.append(especie);
                tableRow.append(acciones);

                $('#tableAnimal table tbody').append(tableRow);
            }
            console.log(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });
    
    function eliminar(event){
        $.ajax({
            method: 'DELETE',
            url:'/Zoo/api/animal/'+$(this).attr('data-id'),
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
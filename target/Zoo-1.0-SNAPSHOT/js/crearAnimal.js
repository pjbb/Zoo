(function ($) {
    var getUrlParameter = function getUrlParameter(sParam) {
        var sPageURL = decodeURIComponent(window.location.search.substring(1)),
                sURLVariables = sPageURL.split('&'),
                sParameterName,
                i;
        for (i = 0; i < sURLVariables.length; i++) {
            sParameterName = sURLVariables[i].split('=');
            if (sParameterName[0] === sParam) {
                return sParameterName [1] === undefined ? true : sParameterName[1];
            }
        }
    };

    if (getUrlParameter('id')) {
        $.ajax({
            method: 'GET',
            url: '/Zoo/api/animal/' + getUrlParameter('id'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            var evaluacion= $('#evaluacion').val(data.evaluacion);
            var cuidador= $('#cuidador').val(data.cuidador);
            var tipoAnimal= $('#tipoAnimal').val(data.tipoAnimal);
            var nombreAnimal= $('#nombreA').val(data.nombreAnimal);
            var nombreCientifico= $('#nombreCientifico').val(data.nombreCientifico);
            var descripcion= $('#descripcion').val(data.descripcion);
            var especie= $('#especie').val(data.especie);
            var id = data.id;
            $('#crearBoton').text("Actualizar").click(function (event) {
                $.ajax({
                    method: 'PUT',
                    url: '/Zoo/api/animal/' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify({
                        id:id,
                        evaluacion: evaluacion,
                        cuidador: cuidador,
                        tipoAnimal: tipoAnimal,
                        nombre: nombreAnimal,
                        nombreCientifico: nombreCientifico,
                        descripcion: descripcion,
                        especie: especie
                    })
                }).done(function (data) {
                    window.location.href = '/Zoo';
                }).fail(function (xhr, status, error) {
                    console.log.error;
                });
            });

        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#crearBoton').click(function (event) {
            var evaluacion= $('#evaluacion').val();
            var cuidador= $('#cuidador').val();
            var tipoAnimal= $('#tipoAnimal').val();
            var nombreAnimal= $('#nombreA').val();
            var nombreCientifico= $('#nombreCientifico').val();
            var descripcion= $('#descripcion').val();
            var especie= $('#especie').val();
            $.ajax({
                method: 'POST',
                url: '/Zoo/api/animal',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify({
                    evaluacion: evaluacion,
                    cuidador: cuidador,
                    tipoAnimal: tipoAnimal,
                    nombre: nombreAnimal,
                    nombreCientifico: nombreCientifico,
                    descripcion: descripcion,
                    especie: especie
                })
            }).done(function (data) {
                window.location.href = '/Zoo';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);
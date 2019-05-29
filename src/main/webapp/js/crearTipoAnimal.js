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
            url: '/Zoo/api/tipoAnimal/' + getUrlParameter('id'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            var nombreTipoAnimal= $('#nombreTipoA').val(data.nombreTipoAnimal);
            var horarioAlimentacion= $('#idHorarioAlimentacion').val(data.horarioAlimentacion);
            
            var id = data.id;
            $('#crearBoton').text("Actualizar").click(function (event) {
                $.ajax({
                    method: 'PUT',
                    url: '/Zoo/api/tipoAnimal/' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify({
                        id:id,
                        nombreTipoAnimal: nombreTipoAnimal,
                        idHorarioAlimentacion: horarioAlimentacion
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
            var nombreTipoAnimal= $('#nombreTipoA').val();
            var horarioAlimentacion= $('#idHorarioAlimentacion').val();
            $.ajax({
                method: 'POST',
                url: '/Zoo/api/tipoAnimal',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify({
                    nombreTipoAnimal: nombreTipoAnimal,
                    idHorarioAlimentacion: horarioAlimentacion
                })
            }).done(function (data) {
                window.location.href = '/Zoo';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);


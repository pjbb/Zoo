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
            url: '/Zoo/api/horariosAlimentacion/' + getUrlParameter('id'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            var horaInicio= $('#horaInicio').val(data.horaInicio);
            var horaFinal= $('#horaFinal').val(data.horaFinal);
            var id = data.idHorarioAlimentacion;
            $('#crearBoton').text("Actualizar").click(function (event) {
                $.ajax({
                    method: 'PUT',
                    url: '/Zoo/api/horariosAlimentacion/' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify({
                        idHorarioAlimentacion:id,
                        horaInicio: horaInicio,
                        horaFinal: horaFinal
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
            var horaInicio = $('#horaInicio').val();
            var horaFinal = $('#horaFinal').val();
            $.ajax({
                method: 'POST',
                url: '/Zoo/api/horariosAlimentacion',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify({
                    horaInicio: horaInicio,
                    horaFinal: horaFinal
                })
            }).done(function (data) {
                window.location.href = '/Zoo';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);
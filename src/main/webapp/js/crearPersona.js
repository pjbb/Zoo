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
            url: '/Zoo/api/persona/' + getUrlParameter('id'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            var cargo= $('#cargo').val(data.cargo);
            var tipoDocumento= $('#tipoDoc').val(data.tipoDocumento);
            var nombre= $('#nombre').val(data.nombre);
            var fechaNacimiento= $('#fechaNac').val(data.fechaNacimiento);
            var telefono= $('#telefono').val(data.telefono);
            
            var id = data.id;
            $('#crearBoton').text("Actualizar").click(function (event) {
                $.ajax({
                    method: 'PUT',
                    url: '/Zoo/api/persona/' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify({
                        id:id,
                        cargo: cargo,
                        tipoDocumento: tipoDocumento,
                        nombre: nombre,
                        fechaNacimiento: fechaNacimiento,
                        telefono: telefono
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
            var cargo= $('#cargo').val();
            var tipoDocumento= $('#tipoDoc').val();
            var nombre= $('#nombre').val();
            var fechaNacimiento= $('#fechaNac').val();
            var telefono= $('#telefono').val();
            $.ajax({
                method: 'POST',
                url: '/Zoo/api/persona',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify({
                    cargo: cargo,
                    tipoDocumento: tipoDocumento,
                    nombre: nombre,
                    fechaNacimiento: fechaNacimiento,
                    telefono: telefono
                })
            }).done(function (data) {
                window.location.href = '/Zoo';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);
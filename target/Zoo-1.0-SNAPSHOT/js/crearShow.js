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
            url: '/Zoo/api/show/' + getUrlParameter('id'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            var animal= $('#idAnimal').val(data.animal);
            var horario= $('#horario').val(data.horario);
            var lugar= $('#idLugar').val(data.lugar);
            var encargado= $('#encargado').val(data.encargado);
            var evaluacion= $('#evalucaion').val(data.evaluacion);
            var nombre= $('#nombreShow').val(data.nombre);
            
            var id = data.id;
            $('#crearBoton').text("Actualizar").click(function (event) {
                $.ajax({
                    method: 'PUT',
                    url: '/Zoo/api/show/' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify({
                        id:id,
                        idAnimal: animal,
                        horario: horario,
                        lugar: lugar,
                        encargado: encargado,
                        evaluacion: evaluacion,
                        nombreShow: nombre
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
            var animal= $('#idAnimal').val();
            var horario= $('#horario').val();
            var lugar= $('#idLugar').val();
            var encargado= $('#encargado').val();
            var evaluacion= $('#evalucaion').val();
            var nombre= $('#nombreShow').val();
            $.ajax({
                method: 'POST',
                url: '/Zoo/api/show',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify({
                    idAnimal: animal,
                    horario: horario,
                    lugar: lugar,
                    encargado: encargado,
                    evaluacion: evaluacion,
                    nombreShow: nombre
                })
            }).done(function (data) {
                window.location.href = '/Zoo';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);
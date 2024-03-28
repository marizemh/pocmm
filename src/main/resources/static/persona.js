$(document).ready(function() {

    // Mostrar tabla de personas
    var table = $('#personas').DataTable({
        "ajax": "/personas/all",
        "columns": [
            { "data": "id" },
            { "data": "nombres" },
            { "data": "apellidos" },
            { "data": "pais" },
            {
                "data": null,
                "render": function (data, type, row) {
                    return "<a href='/personas/" + data.id + "' class='btn btn-info'>Editar</a> " +
                        "<a href='#' class='btn btn-danger' onclick='eliminarPersona(" + data.id + ")'>Eliminar</a>";
                }
            }
        ]
    });

    // Agregar persona
    $('#crearPersona').submit(function(event) {
        event.preventDefault();

        var data = {
            "nombres": $('#nombres').val(),
            "apellidos": $('#apellidos').val(),
            "pais": $('#pais').val()
        };

        $.ajax({
            url: '/personas',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function(data) {
                table.ajax.reload();
                $('#crearPersona').modal('hide');
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert('Error al agregar persona: ' + textStatus + ' - ' + errorThrown);
            }
        });
    });

    // Eliminar persona
    function eliminarPersona(id) {
        $.ajax({
            url: '/personas/' + id,
            type: 'DELETE',
            success: function(data) {
                table.ajax.reload();
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert('Error al eliminar persona: ' + textStatus + ' - ' + errorThrown);
            }
        });
    }

});

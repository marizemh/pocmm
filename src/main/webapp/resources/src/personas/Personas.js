$(document).ready(function () {
    // Inicializar Datatables
    var table = $('#personas').DataTable({
        // Configuración de Datatables
        ajax: {
            url: '/api/personas', // Endpoint para obtener el listado de personas
            dataSrc: ''
        },
        columns: [
            { data: 'id' },
            { data: 'nombres' },
            { data: 'apellidos' },
            { data: 'pais' },
            {
                data: null,
                render: function (data, type, row) {
                    return '<button class="editButton" data-id="' + data.id + '">Editar</button>' +
                        '<button class="deleteButton" data-id="' + data.id + '">Eliminar</button>';
                }
            }
        ]
    });

    // Manejar evento de envío del formulario de creación y edición de persona
    $('#personaForm').submit(function (event) {
        event.preventDefault();
        var id = $('#personaId').val(); // Obtener el ID de la persona si se está editando
        var nombres = $('#nombres').val();
        var apellidos = $('#apellidos').val();
        var pais = $('#pais').val();
        var method = id ? 'PUT' : 'POST';
        var url = id ? '/api/personas/' + id : '/api/personas';

        $.ajax({
            url: url,
            type: method,
            contentType: 'application/json',
            data: JSON.stringify({ nombres: nombres, apellidos: apellidos, pais: pais }),
            success: function (response) {
                // Recargar el listado de personas después de la creación/edición
                table.ajax.reload();
                // Limpiar el formulario y cerrar el modal
                $('#personaForm')[0].reset();
                $('#personaModal').modal('hide');
            },
            error: function (xhr, status, error) {
                // Manejar errores
                var errorMessage = xhr.responseJSON.message; // Suponiendo que la API REST devuelve un mensaje de error en formato JSON
                $('#modalMessageContent').text(errorMessage);
                $('#modalMessage').modal('show');
            }
        });
    });

    // Manejar evento de clic en el botón de eliminar persona
    $('#personas').on('click', '.deleteButton', function () {
        var id = $(this).data('id');
        if (confirm('¿Estás seguro de que deseas eliminar esta persona?')) {
            $.ajax({
                url: '/api/personas/' + id,
                type: 'DELETE',
                success: function (response) {
                    // Recargar el listado de personas después de la eliminación
                    table.ajax.reload();
                },
                error: function (xhr, status, error) {
                    // Manejar errores
                    var errorMessage = xhr.responseJSON.message; // Suponiendo que la API REST devuelve un mensaje de error en formato JSON
                    $('#modalMessageContent').text(errorMessage);
                    $('#modalMessage').modal('show');
                }
            });
        }
    });
});

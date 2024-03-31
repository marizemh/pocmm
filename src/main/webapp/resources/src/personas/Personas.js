import $ from 'jquery';
import 'datatables.net';
import 'datatables.net-dt/css/jquery.dataTables.min.css';

$(document).ready(function() {
    $('#personas').DataTable({
        ajax: {
            url: '/rest/personas',
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
});

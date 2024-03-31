import DataTable from 'datatables.net';
import 'datatables.net-dt/css/jquery.dataTables.min.css';
import $ from "jquery";

export default class Personas {
    constructor(config) {
        this.api = config.api;
        this.idTablaPersonas = config.idTablaPersonas;
    }

    render(personas) {
        this.tablaPersonas = new DataTable(`#${this.idTablaPersonas}`, {
            data: personas,
            autoWidth: true,
            responsive: true,
            language: {
                url: `${this.api.getContext()}/DataTables/i18n/es-CL.json`,
            },
            columns: [
                { data: "id" },
                { data: "nombres" },
                { data: "apellidos" },
                { data: "pais" },
                {
                    data: null,
                    render: function (data, type, row) {
                        return '<button class="editButton" data-id="' + data.id + '">Editar</button>' +
                            '<button class="deleteButton" data-id="' + data.id + '">Eliminar</button>';
                    }
                }
            ],
            dom: '<"datatable-header"fl><"datatable-scroll-wrap"t><"datatable-footer"ip>'
        });
    }
}

import DataTable from 'datatables.net';
import 'datatables.net-dt/css/jquery.dataTables.min.css';
import $ from "jquery";

export default class Paises {
    constructor(config) {
        this.api = config.api;
        this.idTablaPaises = config.idTablaPaises;
    }

    render(paises) {
        this.tablaPaises = new DataTable(`#${this.idTablaPaises}`, {
            data: paises,
            autoWidth: true,
            responsive: true,
            language: {
                url: `${this.api.getContext()}/DataTables/i18n/es-CL.json`,
            },
            columns: [
                {
                    data: "id",
                    render: (data, type, row) => data
                },
                {
                    data: "nombre",
                    render: (data, type, row) => data
                }
            ],
            dom: '<"datatable-header"fl><"datatable-scroll-wrap"t><"datatable-footer"ip>'
        });
    }
}

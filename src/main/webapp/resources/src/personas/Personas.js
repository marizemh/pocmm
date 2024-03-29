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
                {
                    data: "id",
                    render: (data, type, row) => data,
                },
                {
                    data: "nombres",
                    render: (data, type, row) => data,
                },
                {
                    data: "apellidos",
                    render: (data, type, row) => data,
                },
                {
                    data: "pais",
                    render: (data, type, row) => data,
                },
            ],
            dom: '<"datatable-header"fl><"datatable-scroll-wrap"t><"datatable-footer"ip>',
        });
    }

    // Función para obtener la fila seleccionada de la tabla
    getSelectedRow() {
        const selectedRow = this.tablaPersonas.row('.selected').node();
        return selectedRow;
    }

    // Función para abrir un modal (logica pendiente)
    showModal(action) {
        console.log(`Abriendo modal para ${action}`);
        // Implementar la lógica para abrir un modal (por ejemplo, con Bootstrap)
        // En el modal, puedes incluir un formulario para crear o editar una persona.
    }
}

$(document).ready(function () {
    $.ajax({
        url: `${config.api.getContext()}/rest/personas`,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            personas.render(data);
        },
        error: function (error) {
            console.error('Error al obtener las personas:', error);
            // Manejar el error mostrando un mensaje al usuario
        }
    });

    $('#createPersonaButton').click(function () {
        personas.showModal('create');
    });

    $('#deletePersonaButton').click(function () {
        const selectedRow = personas.getSelectedRow();
        if (selectedRow) {
            const idPersona = $(selectedRow).attr('data-id');
            $.ajax({
                url: `${config.api.getContext()}/rest/personas/${idPersona}`,
                method: 'DELETE',
                success: function () {
                    // Eliminar la fila de la tabla
                    $(selectedRow).remove();
                    // Mostrar un mensaje de éxito
                    console.log('Persona eliminada correctamente');
                },
                error: function (error) {
                    console.error('Error al eliminar la persona:', error);
                    // Manejar el error mostrando un mensaje al usuario
                }
            });
        } else {
            // Mostrar un mensaje de error al no seleccionar una fila
            console.error('Debe seleccionar una persona para eliminarla');
        }
    });

    // Agregar lógica para editar una persona (opcional)
    // Puedes agregar un botón para editar una persona y usar la función `showModal`
    // para abrir un modal con un formulario precargado con los datos de la persona a editar.

});

const config = {
    api: {
        getContext: () => window.location.origin,
    },
    idTablaPersonas: 'personas', // Actualizar con el id real de la tabla de personas
};

const personas = new Personas(config);

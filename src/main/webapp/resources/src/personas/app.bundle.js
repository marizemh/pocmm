import Personas from './Personas';
import $ from 'jquery';

const config = {
  api: {
    getContext: () => window.location.origin,
  },
  idTablaPersonas: 'personas', // Actualizar con el id real de la tabla de personas
};

const personas = new Personas(config);

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
    // Abrir modal para crear una nueva persona (logica pendiente)
    // Puedes usar la función `showModal` del módulo `Personas` para abrir un modal
    // con un formulario para crear una nueva persona.
    personas.showModal('create');
  });

  $('#deletePersonaButton').click(function () {
    // Eliminar la persona seleccionada (logica pendiente)
    // Puedes obtener la fila seleccionada de la tabla usando la función `getSelectedRow`
    // del módulo `Personas`. Luego, puedes obtener el ID de la persona a eliminar 
    // y enviarlo a la API mediante una solicitud `DELETE`.
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
  // del módulo `Personas` para abrir un modal con un formulario precargado con los
  // datos de la persona a editar.

});

export default personas;

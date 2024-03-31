// Import our custom CSS
import '../scss/styles.scss';
import bootstrap from 'bootstrap';
import Api from "./Api";
import Personas from "./Personas";
import { showError } from "../commons/Utils";

const config = {
    // Configuración
};

const api = new Api(config);
const personas = new Personas({ idTablaPersonas: 'personas', api: api, ...config });

function renderPersonas() {
    api.obtenerPersonas()
        .then(personas => {
            personas.render(personas);
        })
        .catch(error => {
            showError(error);
        });
}

renderPersonas();

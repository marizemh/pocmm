import $ from "jquery";
import Api from "./Api";
import Personas from "./Personas";
import { showError } from "../commons/Utils";

const config = {
    // Configuración
};

const api = new Api(config);
const personas = new Personas({ idTablaPersonas: 'personas', api: api, ...config });

personas.obtenerYRenderizarPersonas();

// Import our custom CSS
import '../scss/styles.scss';
// eslint-disable-next-line no-unused-vars
import bootstrap from 'bootstrap';

import Api from "./Api";
import Personas from "./Personas";
import { showError } from "../commons/Utils";

export default class App {
    constructor(config) {
        this.api = new Api(config);

        this.personas = new Personas({ idTablaPersonas: 'personas', api: this.api, ...config });

        this.renderPersonas();
    }

    renderPersonas() {
        this.api.obtenerPersonas()
            .then(personas => {
                this.personas.render(personas);
            })
            .catch(error => {
                showError(error);
            });
    }
}

// eslint-disable-next-line no-undef
globalThis.app = new App(config);

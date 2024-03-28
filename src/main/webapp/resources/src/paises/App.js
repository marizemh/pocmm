// Import our custom CSS
import '../scss/styles.scss';
// eslint-disable-next-line no-unused-vars
import bootstrap from 'bootstrap';

import Api from "./Api";
import Paises from "./Paises";
import { showError } from "../commons/Utils";

export default class App {
    constructor(config) {
        this.api = new Api(config);

        this.paises = new Paises({ idTablaPaises: 'paises', api: this.api, ...config });

        this.renderPaises();
    }

    renderPaises() {
        this.api.obtenerPaises()
            .then(paises => {
                this.paises.render(paises);
            })
            .catch(error => {
                showError(error);
            });
    }
}

// eslint-disable-next-line no-undef
globalThis.app = new App(config);

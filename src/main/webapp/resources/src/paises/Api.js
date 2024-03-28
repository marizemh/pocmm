import BaseApi from "../commons/BaseApi";

export default class Api extends BaseApi {
    constructor(config) {
        super(config);
        this.baseEndpoint = `${config.context}/rest/paises`;
    }

    #getBaseEndPoint() {
        return this.baseEndpoint;
    }

    obtenerPaises() {
        const url = this.#getBaseEndPoint();
        return Api.get(url);
    }
}

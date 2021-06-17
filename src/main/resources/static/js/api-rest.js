(function (ns) {
  class ApiRest {
    static get(url) {
      return fetch(url).then((res) => res.json());
    }
    static post(url, data) {
      return ApiRest._fetch(url, 'POST', data);
    }
    static put(url, data) {
      return ApiRest._fetch(url, 'PUT', data);
    }
    static delete(url) {
      return ApiRest._fetch(url, 'DELETE');
    }
    static createService(url) {
      return new ApiRestService(url);
    }
    // Opciones globales para todas las peticiones
    static _fetch(url, method, data = null) {
      return fetch(url, {
        method,
        body: data ? JSON.stringify(data) : undefined,
        headers: {
          'Content-Type': 'application/json'
        },
      }).then((res) => res.json());
    }
  };
  class ApiRestService {
    apiUrl;
    constructor(url) {
      this.apiUrl = url;
    }
    list() {
      return ApiRest.get(this.apiUrl);
    }
    get(id) {
      return ApiRest.get(`${this.apiUrl}/${id}`);
    }
    create(rec) {
      return ApiRest.post(this.apiUrl, rec);
    }
    update(rec) {
      return ApiRest.put(`${this.apiUrl}/${rec.id}`, rec);
    }
    save(rec) {
      return rec.id ? this.update(rec) : this.create(rec);
    }
    delete(id) {
      return ApiRest.delete(`${this.apiUrl}/${id}`);
    }
  };
  ns.ApiRest = ApiRest;

})(window)
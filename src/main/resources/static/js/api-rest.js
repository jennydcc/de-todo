(function (ns) {
  class ApiRest {
    static get(url) {
      return fetch(url).then((res) => res.json());
    }
    static post(url, data) {
      return API._fetch(url, 'POST', data);
    }
    static put(url, data) {
      return API._fetch(url, 'PUT', data);
    }
    static delete(url) {
      return API._fetch(url, 'DELETE');
    }
    static createService(url) {
      return new ApiRestService(url);
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
  // Opciones globales para todas las peticiones
  API._fetch = function (url, method, data = null) {
    return fetch(url, {
      method,
      body: data ? JSON.stringify(data) : undefined,
      headers: {
        'Content-Type': 'application/json'
      },
    }).then((res) => res.json());
  };

  ns.ApiRest = ApiRest;

})(window)
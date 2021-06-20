const View = {
  // Propiedades de la plantilla
  data() {
    return {
      record: {},
      modeEdition: false,
    }
  },
  mounted() {
    // Crea servicio para hacer peticiones REST
    this.defaultService = ApiRest.createService('/api/v1/clientes');
    this.loadData();
  },
  // Metodos
  methods: {
    /**
     * Cargar datos del servicio
     */
    loadData() {
      const me = this;
      me.defaultService.get('logged-in').then((rec) => {
        me.record = rec || {};
      }, (err) => {
        console.log(err);
      })
    },
    /* Event handlers */
    // Modificar
    handleUpdateClick() {
      this.modeEdition = true;
    },
    // Guardar
    handleSaveRecordClick() {
      const me = this;
      me.defaultService.update(me.record).then((resRecord) => {
        me.record = resRecord;
        me.modeEdition = false;
      }, (err) => {
        console.log(err);
      })
    },
  }
}

Vue.createApp(View).mount('#dynamicBlock')
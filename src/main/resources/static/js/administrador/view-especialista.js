const View = {
  // Propiedades de la plantilla
  data() {
    return {
      editingRecord: {},
      deletingRecord: {},
      records: []
    }
  },
  mounted() {
    // Crea servicio para hacer peticiones REST
    this.defaultService = ApiRest.createService('/api/v1/especialista');
    this.loadData();
  },
  // Metodos
  methods: {
    cambiarMiNombre() {
      this.miNombre = this.miNombre + 'X';
    },
    /**
     * Cargar datos del servicio
     */
    loadData() {
      const me = this;
      me.defaultService.list().then((data) => {
        me.records = data || [];
      }, (err) => {
        console.log(err);
      })
    },
    /* Event handlers */
    // Nuevo
    handleNewRecordClick() {
      this.editingRecord = {};
      this.getEditor().show();
    },
    // Guardar
    handleSaveRecordClick(rec) {
      const me = this;
      const isNewRecord = !rec.id;
      me.defaultService.save(rec).then((resRecord) => {
        me.getEditor().hide();
        if (isNewRecord) {
          me.records.push(resRecord);
        } else {
          me.records = me.records.map((iRec) => iRec.id == resRecord.id ? resRecord : iRec)
        }
      }, (err) => {
        console.log(err);
      })
    },
    // Editar
    handleEditRecordClick(rec) {
      this.editingRecord = { ...rec };
      this.getEditor().show();
    },
    // Eliminar
    handleDeleteRecordClick(rec) {
      this.deletingRecord = rec;
      this.getDeleteDialog().show();
    },
    handleConfirmDeleteRecordClick(rec) {
      const me = this, id = rec.id;
      me.defaultService.delete(id).then(() => {
        me.records = me.records.filter((rec) => rec.id !== id);
        me.getDeleteDialog().hide();
      }, (err) => {
        console.log(err);
      });
    },
    /** Modales */
    // Editor
    getEditor() {
      return this.editor || (this.editor = new bootstrap.Modal(document.getElementById('editorModal')));
    },
    // Confirmar eliminación
    getDeleteDialog() {
      return this.deleteDialog || (this.deleteDialog = new bootstrap.Modal(document.getElementById('deleteDialog')));
    },

  }
}

Vue.createApp(View).mount('#dynamicBlock')
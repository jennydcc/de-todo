package edu.integrador2.serviciosgenerales.controller;

import java.util.Calendar;

import org.springframework.ui.Model;

import edu.integrador2.serviciosgenerales.entity.Usuario;
import edu.integrador2.serviciosgenerales.security.SessionManager;

public class Template {
  public static void addGlobalAttributes(Model uiModel) {
    Usuario usuario = SessionManager.getUsuario();
    uiModel.addAttribute("hoy", Calendar.getInstance());
    uiModel.addAttribute("usuario", usuario);
  }

  public static void addPageIndex(Model uiModel, int index) {
    uiModel.addAttribute("pageIndex", index);
  }
}

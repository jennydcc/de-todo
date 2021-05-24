<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="_header.jsp" %>
<div class="container mt-5">

  <form method="POST" action="login">
    <div class="row" >
      <div class="col-12 col-md-8">
        <h3>Clientes</h3>
        <h6 class="text-black-50">Módulo solo para clientes</h6>

        <div class="mt-4 mb-3">
          <label for="email-input" class="form-label fw-bold fs-11">CORREO ELECTRÓNICO</label>
          <input type="email" name="correo" class="form-control app-login-input" id="email-input" placeholder="name@example.com">
        </div>
        <div class="mb-3">
          <label for="passwd-input" class="form-label fw-bold fs-11">CONTRASEÑA</label>
          <input type="password" name="contra" class="form-control app-login-input" id="passwd-input">
        </div>
        <div>
          <button type="submit" class="btn app-btn app-bg-darken-primary text-white p4">Ingresar</button>
          <a class="app-fg-darken-primary" style="margin-left: 32px;">Olvidé mi contraseña</a>
        </div>
        <div class="d-flex mt-5">
          <div class="alert alert-light mb-0" role="alert">
            Si deseas ser uno de nuestros clientes porfavor haz click aquí
          </div>
          <div class="align-self-center">
            <a href="registrarCliente.jsp" class="btn app-btn app-bg-primary text-white">REGISTRARSE</a>
          </div>
        </div>
      </div>
      <div class="col-12 col-md-4">
        <img src="images/login-clientes.jpg" class="img-fluid w-100" alt="Login clientes">
      </div>
    </div>
  </form>
</div>
<%@include file="_footer.jsp" %>
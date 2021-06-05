package edu.integrador2.serviciosgenerales.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AppAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
  private final PathTokens tokens;
  
  @Autowired
  public AppAuthenticationEntryPoint(PathTokens tokens) {
    // LoginUrlAuthenticationEntryPoint requires a default
    super("/");
    this.tokens = tokens;
  }

  /**
   * @param request   the request
   * @param response  the response
   * @param exception the exception
   * @return the URL (cannot be null or empty; defaults to
   *         {@link #getLoginFormUrl()})
   */
  @Override
  protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException exception) {
    return getLoginUrlFromPath(request);
  }

  private String getLoginUrlFromPath(HttpServletRequest request) {
    String requestUrl = request.getRequestURI();
    if (tokens.isTokenInPath(requestUrl)) {
      return "/" + tokens.getTokenFromPath(requestUrl) + "/login";
    }
    return requestUrl;
  }
}

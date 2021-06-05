package edu.integrador2.serviciosgenerales.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class AppUrlAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

  private final PathTokens tokens;

  @Autowired
  public AppUrlAuthenticationFailureHandler(PathTokens tokens) {
    super();
    this.tokens = tokens;
  }

  /**
   * Performs the redirect or forward to the
   * {@code defaultFailureUrl associated with this path} if set, otherwise returns
   * a 401 error code.
   * <p/>
   * If redirecting or forwarding, {@code saveException} will be called to cache
   * the exception for use in the target view.
   */
  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException exception) throws IOException, ServletException {
    setDefaultFailureUrl(getFailureUrlFromPath(request));
    super.onAuthenticationFailure(request, response, exception);

  }

  private String getFailureUrlFromPath(HttpServletRequest request) {
    String refererUrl = request.getHeader("Referer");
    if (tokens.isTokenInPath(refererUrl)) {
      return "/" + tokens.getTokenFromPath(refererUrl) + "/login?error=1";
    }
    return refererUrl;
    /*
     * throw new PathTokenNotFoundException( "Token not found in referer URL " +
     * refererUrl + " when retrieving failureUrl for login form");
     */
  }
}
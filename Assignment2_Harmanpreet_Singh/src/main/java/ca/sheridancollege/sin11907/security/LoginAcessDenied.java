package ca.sheridancollege.sin11907.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
@Component
public class LoginAcessDenied implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//Gives us information about the user trying to access a page
		//they do not have the correct role for.
		//import from spring security core
		Authentication auth = 
				SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null) {
			System.out.println(auth.getName()
					+"was trying to access resource:"+request.getRequestURI());
		}
		//return "redirect:/access-denied"
		response.sendRedirect(request.getContextPath()+"/access-denied");
	}

}
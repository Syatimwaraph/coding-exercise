package dev.jaysyat.hospital_management_saiba.config;

import dev.jaysyat.hospital_management_saiba.services.UserDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import java.io.IOException;

public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String username = UserDetails.getUsername();


        // Get user ID (assuming a custom UserDetails implementsUserDetails userDetails = (UserDetails) authentication.getPrincipal();ntation)

        Long userId = UserDetails.getId();
        String role = UserDetails.getRole();

        if(authentication != null){
            session.setAttribute("username", username);
            session.setAttribute("userId", userId);
            session.setAttribute("role", role);
        }

        boolean fromGomaH = authentication.getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_HGR-GOMA"));
        boolean fromHealAfrica = authentication.getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_HEAL-AFRICA"));

        // Redirect the user according to the hospital they belong to
        if (fromGomaH){
            System.out.println("The system is arriving here Goma Raph");
            System.out.println("The User name after login is " + username);
            System.out.println("The User ID after login is " + userId);
            System.out.println("The User ROLE after login is " + role);
            setDefaultTargetUrl("/hgrgomadashboard");
        } else if (fromHealAfrica) {
            System.out.println("The system is arriving here Heal Africa Raph");
            setDefaultTargetUrl("/healafricadashboard");
        }

        // Important: Call the super method to handle the redirect
        super.onAuthenticationSuccess(request, response, authentication);
    }
}

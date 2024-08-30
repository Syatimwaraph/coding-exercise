package dev.jaysyat.hospital_management_saiba.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import java.io.IOException;

public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        boolean fromGomaH = authentication.getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_HGR-GOMA"));
        boolean fromHealAfrica = authentication.getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_HEAL-AFRICA"));

        // Redirect the user according to the hospital they belong to
        if (fromGomaH){
            System.out.println("The system is arriving here Goma Raph");
            setDefaultTargetUrl("/hgrgomadashboard");
        } else if (fromHealAfrica) {
            System.out.println("The system is arriving here Heal Africa Raph");
            setDefaultTargetUrl("/healafricadashboard");
        }

        // Important: Call the super method to handle the redirect
        super.onAuthenticationSuccess(request, response, authentication);
    }
}

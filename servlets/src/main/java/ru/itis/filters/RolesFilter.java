package ru.itis.filters;

import ru.itis.dto.UserDto;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

//@WebFilter
public class RolesFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        String adminUser = (String) session.getAttribute("user");

        if (request.getMethod().equals("POST") && request.getServletPath().equals("/adminUsers")) {
            if ((Objects.equals(adminUser, "ADMIN"))) {
                filterChain.doFilter(request, response);
            } else {
                response.setStatus(403);
            }

        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

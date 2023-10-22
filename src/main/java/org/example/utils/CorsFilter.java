package org.example.utils;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.MultivaluedMap;

import java.io.IOException;

public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {

        MultivaluedMap<String, Object> headers = responseContext.getHeaders();

        // Permite solicitações de qualquer origem
        headers.add("Access-Control-Allow-Origin", "*");
        // Permite métodos HTTP específicos (GET, POST, PUT, DELETE, etc.)
        headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        // Permite cabeçalhos personalizados
        headers.add("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");

        // Permita cookies e credenciais em solicitações CORS (use com cuidado)
        headers.add("Access-Control-Allow-Credentials", "true");
    }
}
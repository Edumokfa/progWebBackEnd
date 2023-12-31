package org.example.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.model.Brand;
import org.example.service.BrandService;
import org.glassfish.grizzly.http.util.HttpStatus;

@Path("/brand")
public class DeleteBrand {

    private final BrandService brandService;

    public DeleteBrand() {
        this.brandService = new BrandService();
    }

    @DELETE
    @Path("{brandId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBrands(@PathParam("brandId") Integer brandId) {
        boolean updatedBrand = brandService.deleteBrand((Integer) brandId);
        if (updatedBrand) {
            return Response.ok().build();
        }
        return Response.status(HttpStatus.NOT_FOUND_404.getStatusCode()).entity("Marca não encontrada").build();
    }
}

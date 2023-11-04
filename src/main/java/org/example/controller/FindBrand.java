package org.example.controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.service.BrandService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/brand")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FindBrand {

    private BrandService brandService;

    public FindBrand() {
        this.brandService = new BrandService();
    }

    @GET
    public Response getBrands() {
        return Response.ok(brandService.getAllBrands()).build();
    }
}

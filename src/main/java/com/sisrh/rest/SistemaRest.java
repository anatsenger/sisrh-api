package com.sisrh.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.swagger.annotations.Api;

@Api
@Path("/sistema")
public class SistemaRest {

    @GET
    @Path("ping")
    @Produces(MediaType.TEXT_PLAIN)
    public Response ping() {
        UUID uuid = UUID.randomUUID();
        return Response.ok().entity("pong: " + uuid).build();
    }

    @GET
    @Path("datahora")
    @Produces(MediaType.TEXT_PLAIN)
    public Response dataHora() {
        String pattern = "dd/MM/YYYY - HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return Response.ok().entity(simpleDateFormat.format(new Date())).build();
    }
}

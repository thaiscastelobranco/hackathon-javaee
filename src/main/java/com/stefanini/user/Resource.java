package com.stefanini.user;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Resource {

    private final Service service;

    @Inject
    public Resource(Service service) {
        this.service = service;
    }

    @GET
    public List<Usuario> listaUsuarios() {
        return List.of(new Usuario());
    }

    @GET
    @Path("/{id}")
    public Usuario buscaUsuario(@PathParam("id") Long id) {
        return new Usuario();
    }

    @POST
    public Usuario criarUsuario(Usuario usuario) {
        return usuario;
    }

    @PUT
    @Path("/{id}")
    public Usuario adicionarInformacao(@PathParam("id") Long id) {
        return new Usuario();

    }

    @DELETE
    @Path("/{id}")
    public Response deletarUsuario(@PathParam("id") Long id) {
        return Response.noContent().build();
    }




}


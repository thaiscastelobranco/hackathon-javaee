package com.stefanini.user;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
        return service.getUsuarios();
    }

    @GET
    @Path("/{id}")
    public Usuario buscaUsuario(@PathParam("id") Long id) {
        return service.getUsuario(id);
    }

    @POST
    public Usuario criarUsuario(@Valid Usuario usuario) {
        return service.createUsuario(usuario);
    }

    @PUT
    @Path("/{id}")
    public Usuario adicionarInformacao(@PathParam("id") Long id, @Valid Usuario usuario) {
        return service.updateUsuario(id, usuario);
    }

    @DELETE
    @Path("/{id}")
    public Response deletarUsuario(@PathParam("id") Long id) {
        service.deleteUsuario(id);
        return Response.noContent().build();
    }




}


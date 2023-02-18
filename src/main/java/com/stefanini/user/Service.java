package com.stefanini.user;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class Service {

    private final Repository repository;

    @Inject
    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<Usuario> getUsuarios(){
        return repository.findAll();
    }

    public Usuario getUsuario(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Usuario createUsuario(Usuario usuario){
        return repository.save(usuario);
    }

    public Usuario updateUsuario(Long id, Usuario usuario){
        Usuario existingUsuario = getUsuario(id);
        return repository.save(usuario);
    }

    public void deleteUsuario(Long id){
        repository.deleteById(id);
    }

}

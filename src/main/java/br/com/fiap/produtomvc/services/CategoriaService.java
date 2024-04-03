package br.com.fiap.produtomvc.services;

import br.com.fiap.produtomvc.models.Categoria;
import br.com.fiap.produtomvc.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Transactional(readOnly = true)
    public List<Categoria> findAll(){
       return repository.findAll();
    }

    @Transactional
    public Categoria insert(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria update(Long id, Categoria entity){
        try {
            Categoria categoria = repository.getReferenceById(id);
            copyToCategoria(entity, categoria);
            categoria = repository.save(categoria);
            return categoria;
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("Recurso não encontrado");
        }

    }
    private void copyToCategoria(Categoria entity, Categoria categoria) {
        categoria.setNome(entity.getNome());
    }

    @Transactional(readOnly = true)
    public Categoria findById(Long id) {
        Categoria categoria = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Categoria inválida - id: " + id)
        );
        return categoria;
    }

    @Transactional(readOnly = true)
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Recurso inválida - id: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Falha de integridade referencial - id: " + id);
        }
    }


}

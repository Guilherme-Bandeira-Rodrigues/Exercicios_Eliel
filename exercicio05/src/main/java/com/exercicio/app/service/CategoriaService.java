package com.exercicio.app.service;
import com.exercicio.app.entity.Categoria;
import com.exercicio.app.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public Categoria salvar(Categoria categoria) { return repository.save(categoria); }
    public List<Categoria> listarTodos() { return repository.findAll(); }
    public Optional<Categoria> buscarPorId(Long id) { return repository.findById(id); }
    public void deletar(Long id) { repository.deleteById(id); }
}

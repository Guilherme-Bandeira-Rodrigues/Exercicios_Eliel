package com.exercicio.app.service;
import com.exercicio.app.entity.Produto;
import com.exercicio.app.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto salvar(Produto produto) { return repository.save(produto); }
    public List<Produto> listarTodos() { return repository.findAll(); }
    public Optional<Produto> buscarPorId(Long id) { return repository.findById(id); }
    public void deletar(Long id) { repository.deleteById(id); }
}

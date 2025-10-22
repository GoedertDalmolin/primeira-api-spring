package com.bruno_goedert.org.projeto.service;

import com.bruno_goedert.org.projeto.dto.TurmaRequest;
import com.bruno_goedert.org.projeto.dto.TurmaResponse;
import com.bruno_goedert.org.projeto.exception.NotFoundException;
import com.bruno_goedert.org.projeto.model.TurmaEntity;
import com.bruno_goedert.org.projeto.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurmaService {

    private final TurmaRepository repository;

    public TurmaService(TurmaRepository repository) {
        this.repository = repository;
    }

    public TurmaResponse create(TurmaRequest req) {
        TurmaEntity e = new TurmaEntity(req.getNome(), req.getAnoLetivo(), req.getPeriodo(), req.getAtiva());
        e = repository.save(e);
        return toResponse(e);
    }

    public TurmaResponse getById(Long id) {
        TurmaEntity e = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Turma id=" + id + " não encontrada"));
        return toResponse(e);
    }

    public List<TurmaResponse> listAll() {
        return repository.findAll()
                .stream().map(this::toResponse).collect(Collectors.toList());
    }

    public TurmaResponse update(Long id, TurmaRequest req) {
        TurmaEntity e = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Turma id=" + id + " não encontrada"));
        e.setNome(req.getNome());
        e.setAnoLetivo(req.getAnoLetivo());
        e.setPeriodo(req.getPeriodo());
        e.setAtiva(req.getAtiva());
        e = repository.save(e);
        return toResponse(e);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Turma id=" + id + " não encontrada");
        }
        repository.deleteById(id);
    }

    private TurmaResponse toResponse(TurmaEntity e) {
        return new TurmaResponse(e.getId(), e.getNome(), e.getAnoLetivo(), e.getPeriodo(), e.getAtiva());
    }
}

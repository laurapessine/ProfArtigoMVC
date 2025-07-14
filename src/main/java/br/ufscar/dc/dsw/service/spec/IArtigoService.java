package br.ufscar.dc.dsw.service.spec;

import java.util.List;
import br.ufscar.dc.dsw.domain.Artigo;

public interface IArtigoService {
    Artigo buscarPorId(Long id);

    List<Artigo> buscarTodos();

    Artigo salvar(Artigo artigo);

    Artigo criar(Artigo artigo);

    void excluir(Long id);
}
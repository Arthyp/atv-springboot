package biblioteca.biblioteca.Service;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;

import java.util.List;

public interface LivroCrudService {

    LivroResponseDto criarLivro(LivroPostPutDto livroPostPutDto);

    LivroResponseDto buscarLivroTitulo(String titulo);

    LivroResponseDto buscarLivroISBN(Long ISBN);

    LivroResponseDto atualizarLivro(Long ISBN, LivroPostPutDto livroPostPutDto);

    void removerLivro(Long ISBN);
}
package biblioteca.biblioteca.Service;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;

//import java.util.List;

public interface LivroCrudService {

    LivroResponseDto criarLivro(LivroPostPutDto livroPostPutDto);

    LivroResponseDto buscarLivroTitulo(String titulo);

    LivroResponseDto buscarLivroISBN(String ISBN);

    LivroResponseDto atualizarLivro(String ISBN, LivroPostPutDto livroPostPutDto);

    void removerLivro(String ISBN);
}
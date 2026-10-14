package biblioteca.biblioteca.Service;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;
import biblioteca.biblioteca.Model.Livro;
import biblioteca.biblioteca.Repository.LivroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LivroCrudPadraoService implements LivroCrudService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    LivroRepository livroRepository;

    @Override
    public LivroResponseDto criarLivro(LivroPostPutDto livroPostPutDto) {
        Livro livro = modelMapper.map(livropPostPutDto, Livro.class);
        return modelMapper.map(livroRepository.save(livro), LivroResponseDto.class);
    }

    /* SE QUISER ADICIONAR PESQUISA POR AUTOR DEPOIS ADICIONE AQUI
    @Override
    public List<AutorResponseDto> buscarTodosAutores() {
        return autorRepository.findAll()
                .stream()
                .map(autor -> modelMapper.map(autor, AutorResponseDto.class))
                .toList();
    }
    */

    @Override
    public LivroResponseDto buscarLivroISBN(Long ISBN) {
        return modelMapper.map(obterLivroISBN(ISBN), LivroResponseDto.class);
    }

    @Override
    public LivroResponseDto buscarLivroTitulo(String titulo) {
        return modelMapper.map(obterLivroTitulo(titulo), LivroResponseDto.class);
    }  

    @Override
    public LivroResponseDto atualizarLivro(Long ISBN, LivroPostPutDto livroPostPutDto) {
        Livro livro = obterLivroISBN(ISBN);
        livro.setNomeLivro(livroPostPutDto.getNomeLivro());
        livro.setNomeEdicao(livroPostPutDto.getNomeEdicao());
        livro.setAno(livroPostPutDto.getAno());
        return modelMapper.map(livroRepository.save(livro), LivroResponseDto.class);
    }

    @Override
    public void removerLivro(Long ISBN) {
        // delete(entidade) permite que o cascade da relação remova também os livros do autor
        livroRepository.delete(obterLivroISBN(ISBN));
    }

    // id inexistente = 404
    private Livro obterLivroISBN(Long ISBN) {
        return livroRepository.findById(ISBN)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
    }
}
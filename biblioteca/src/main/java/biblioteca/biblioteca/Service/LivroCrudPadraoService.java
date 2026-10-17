package biblioteca.biblioteca.Service;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;
import biblioteca.biblioteca.Model.Autor;
import biblioteca.biblioteca.Model.Livro;
import biblioteca.biblioteca.Repository.LivroRepository;
import biblioteca.biblioteca.Repository.AutorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

//import java.util.List;

@Service
public class LivroCrudPadraoService implements LivroCrudService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    LivroRepository livroRepository;

    @Autowired 
    AutorRepository autorRepository;

    @Override
    public LivroResponseDto criarLivro(LivroPostPutDto livroPostPutDto) {
        Autor autor = autorRepository.findById(livroPostPutDto.getAutorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado"));
        Livro livro = modelMapper.map(livroPostPutDto, Livro.class);
        livro.setAutor(autor);
        return modelMapper.map(livroRepository.save(livro), LivroResponseDto.class);
    }

    @Override
    public LivroResponseDto buscarLivroISBN(String ISBN) {
        return modelMapper.map(obterLivroISBN(ISBN), LivroResponseDto.class);
    }

    @Override
    public LivroResponseDto buscarLivroTitulo(String titulo) {
        return modelMapper.map(buscarLivroTitulo(titulo), LivroResponseDto.class);
    }  

    @Override
    public LivroResponseDto atualizarLivro(String ISBN, LivroPostPutDto livroPostPutDto) {
        Livro livro = obterLivroISBN(ISBN);
        livro.setTituloLivro(livroPostPutDto.getTituloLivro());
        livro.setNomeEdicao(livroPostPutDto.getNomeEdicao());
        livro.setAno(livroPostPutDto.getAno());
        return modelMapper.map(livroRepository.save(livro), LivroResponseDto.class);
    }

    @Override
    public void removerLivro(String ISBN) {
        // delete(entidade) permite que o cascade da relação remova também os livros do autor
        livroRepository.delete(obterLivroISBN(ISBN));
    }

    // id inexistente = 404
    private Livro obterLivroISBN(String ISBN) {
        return livroRepository.findById(ISBN)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
    }
}
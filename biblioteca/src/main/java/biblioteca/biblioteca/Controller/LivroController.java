package biblioteca.biblioteca.Controller;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;
import biblioteca.biblioteca.Service.LivroCrudService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
    value = "/v1/livros",
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class LivroController {

    @Autowired
    private LivroCrudService livroCrudService;

    @PostMapping
    public ResponseEntity<LivroResponseDto> criarLivro(
            @RequestBody @Valid LivroPostPutDto dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(livroCrudService.criarLivro(dto));
    }

    @GetMapping
    public ResponseEntity<List<LivroResponseDto>> buscarLivros(
            @RequestParam(required = false) String ISBN,
            @RequestParam(required = false) String titulo) {

        // Implementar a busca pelos parâmetros informados
        // e retornar a lista de resultados.
        throw new UnsupportedOperationException(
            "Implementar busca por ISBN ou título"
        );
    }

    @GetMapping("/{ISBN}")
    public ResponseEntity<LivroResponseDto> buscarLivro(
            @PathVariable String ISBN) {

        return ResponseEntity.ok(
            livroCrudService.buscarLivroISBN(ISBN)
        );
    }

    @PutMapping("/{ISBN}")
    public ResponseEntity<LivroResponseDto> atualizarLivro(
            @PathVariable String ISBN,
            @RequestBody @Valid LivroPostPutDto dto) {

        return ResponseEntity.ok(
            livroCrudService.atualizarLivro(ISBN, dto)
        );
    }

    @DeleteMapping("/{ISBN}")
    public ResponseEntity<Void> removerLivro(
            @PathVariable String ISBN) {

        livroCrudService.removerLivro(ISBN);

        return ResponseEntity.noContent().build();
    }
}

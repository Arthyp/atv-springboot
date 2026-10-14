package biblioteca.biblioteca.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroPostPutDto {
    @JsonProperty("tituloLivro")
    @NotBlank(message = "Titulo do livro não pode ser vazio")
    private String tituloLivro;

    @JsonProperty("ISBN")
    @NotBlank(message = "ISBN não pode ser vazio")
    private String ISBN;

    @JsonProperty("Ano")
    @NotBlank(message = "Ano não pode ser vazio")
    private Int Ano;
    
    @JsonProperty("nomeEdicao")
    @NotBlank(message = "Nome da Edição não pode ser vazio")
    private String nomeEdicao;
}
package biblioteca.biblioteca.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroPostPutDto {

    @JsonProperty("tituloLivro")
    @NotBlank(message = "Título não pode ser vazio")
    private String tituloLivro;

    @JsonProperty("ISBN")
    @NotBlank(message = "ISBN não pode ser vazio")
    private String ISBN;

    @JsonProperty("ano") // Not Null e Positive por que not blank é para String
    @NotNull(message = "Ano não pode ser vazio")
    @Positive(message = "Ano deve ser positivo")
    private Integer ano;

    @JsonProperty("nomeEdicao")
    @NotBlank(message = "Edição não pode ser vazia")
    private String nomeEdicao;

    @JsonProperty("autorId")
    @NotNull(message = "Autor é obrigatório")
    private Long autorId;
}

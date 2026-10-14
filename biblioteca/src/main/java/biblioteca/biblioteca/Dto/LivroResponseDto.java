package biblioteca.biblioteca.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AutorResponseDto {
    @JsonProperty("ISBN")
    private Long ISBN;

    @JsonProperty("tituloLivro")
    private String tituloLivro;

    @JsonProperty("ds_Ano")
    private Int Ano;

    @JsonProperty("nomeEdicao")
    private String nomeEdicao;
}